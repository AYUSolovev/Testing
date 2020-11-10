package service.businessLayer.answer;

import model.question.Answer;

import java.util.List;

public interface AnswerService  {
    void addAnswer(Answer answer);
    List<Answer> readAnswer(int idQuestion);
    void updateAnswer();
    void deleteAnswer();
}
