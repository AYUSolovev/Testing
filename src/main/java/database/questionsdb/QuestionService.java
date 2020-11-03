package database.questionsdb;

import questions.Question;

import java.sql.SQLException;
import java.util.*;

public interface QuestionService {
    void createQuestion(Question question);
    List<Question> readQuestion(int testId);
    void updateQuestions();
    void deleteQuestion(int i);
}
