package basePackage.model.question;

import java.util.ArrayList;
import java.util.List;


public class Question {

    private int id;
    private String question;
    private TypeQuestion typeQuestion;
    private List<Answer> answersList;
    private String authorQuestion;
    private int testId;

    public Question() {
        answersList = new ArrayList<Answer>();
    }

    public Question(int testId, String question, TypeQuestion typeQuestion, List<Answer> answersList, String authorQuestion) {
        this.testId = testId;
        this.question = question;
        this.typeQuestion = typeQuestion;
        this.answersList = answersList;
        this.authorQuestion = authorQuestion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public TypeQuestion getTypeQuestion() {
        return typeQuestion;
    }

    public void setTypeQuestion(TypeQuestion typeQuestion) {
        this.typeQuestion = typeQuestion;
    }

    public List<Answer> getAnswersList() {
        return answersList;
    }

    public void setAnswersList(List<Answer> answersList) {
        this.answersList = answersList;
    }

    public String getAuthorQuestion() {
        return authorQuestion;
    }

    public void setAuthorQuestion(String authorQuestion) {
        this.authorQuestion = authorQuestion;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }
}
