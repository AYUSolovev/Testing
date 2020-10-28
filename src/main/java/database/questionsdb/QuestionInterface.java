package database.questionsdb;

import questions.Question;

import java.util.*;

public interface QuestionInterface {
    void createQuestion(Question question);
    List<Question> readQuestion();
    void updateQuestion(Question question);
    void deleteQuestion(Question question);
}
