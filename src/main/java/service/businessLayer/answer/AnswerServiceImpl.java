package service.businessLayer.answer;

import model.question.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.dataLayer.answer.AnswerAccessService;
import service.dataLayer.answer.AnswerAccessServiceImpl;

import java.util.List;

@Component
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerAccessService answer = new AnswerAccessServiceImpl();

    public void addAnswer(Answer answer) {

    }

    public List<Answer> readAnswer(int idQuestion) {
        List<Answer> answerList = this.answer.readAnswer(idQuestion);
        return answerList;
    }

    public void updateAnswer() {

    }

    public void deleteAnswer() {

    }
}
