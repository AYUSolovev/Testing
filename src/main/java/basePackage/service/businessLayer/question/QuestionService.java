package basePackage.service.businessLayer.question;

import basePackage.model.question.Question;

import java.util.List;

public interface QuestionService {
    List<Question> readQuestion(int idTest);
    void addQuestion(Question question);
    void updateQuestion(Question question);
    void deleteQuestion(int id);
    Question findQuestion(String textQuestion);
}
