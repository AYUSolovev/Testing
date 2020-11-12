package service.businessLayer.question;

import model.question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.businessLayer.answer.AnswerService;
import service.businessLayer.answer.AnswerServiceImpl;
import service.dataLayer.question.*;

import java.util.List;

@Component
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionAccessService questionAccessService = new QuestionAccessServiceImpl();

    @Autowired
    private AnswerService answer = new AnswerServiceImpl();


    public List<Question> readQuestion(int idTest) {
        List<Question> listQuestion = this.questionAccessService.readQuestion(idTest);
        for (Question question:listQuestion
             ) {
            question.setAnswersList(this.answer.readAnswer(question.getId()));
        }
        return listQuestion;
    }
    public Question findQuestion(String textQuestion){
        Question question;
        question = questionAccessService.findQuestion(textQuestion);
        if(question != null) {
            question.setAnswersList(answer.readAnswer(question.getId()));
            return question;
        }
        throw new RuntimeException("Вопрос не найден");
    }

    public void addQuestion(Question question) {

    }

    public void updateQuestion(Question question) {

    }

    public void deleteQuestion(int id) {

    }
}
