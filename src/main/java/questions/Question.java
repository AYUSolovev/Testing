package questions;

import database.questionsdb.QuestionInterface;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private String question;
    private TypeQuestion typeQuestion;
    private List<Answer> answer;
    private String authorQuestion;


    public Question() {
        answer = new ArrayList<Answer>();
    }

    public TypeQuestion getTypeQuestion() {
        return typeQuestion;
    }

    public void setTypeQuestion(TypeQuestion typeQuestion) {
        this.typeQuestion = typeQuestion;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAuthorQuestion() {
        return authorQuestion;
    }

    public void setAuthorQuestion(String authorQuestion) {
        this.authorQuestion = authorQuestion;
    }

    public List<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }
}
