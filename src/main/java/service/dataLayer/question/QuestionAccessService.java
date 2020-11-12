package service.dataLayer.question;

import model.question.Question;

import java.util.*;

public interface QuestionAccessService {
    void createQuestion(Question question);
    List<Question> readQuestion(int testId);
    void updateQuestions(Question question);
    void deleteQuestion(int id);
    Question findQuestion(String textQuestion);
}
