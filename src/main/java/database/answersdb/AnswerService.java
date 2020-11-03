package database.answersdb;

import questions.Answer;

import java.sql.SQLException;
import java.util.List;

public interface AnswerService {
    void createAnswer(Answer answer);
    List<Answer> readAnswer(int questionId);
    void updateAnswer();
    void deleteAnswer();
}
