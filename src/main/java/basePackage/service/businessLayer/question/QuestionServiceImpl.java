package basePackage.service.businessLayer.question;

import basePackage.model.question.Question;
import basePackage.service.dataLayer.question.QuestionAccessService;
import basePackage.service.dataLayer.question.QuestionAccessServiceImpl;
import basePackage.service.businessLayer.answer.AnswerService;
import basePackage.service.businessLayer.answer.AnswerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionAccessService questionAccessService;

    @Autowired
    private AnswerService answer;


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
