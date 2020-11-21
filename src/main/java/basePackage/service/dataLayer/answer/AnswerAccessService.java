package basePackage.service.dataLayer.answer;

import basePackage.model.question.Answer;

import java.util.List;

public interface AnswerAccessService {
    void createAnswer(Answer answer);
    List<Answer> readAnswer(int idQuestion);
    void updateAnswer();
    void deleteAnswer();
}
