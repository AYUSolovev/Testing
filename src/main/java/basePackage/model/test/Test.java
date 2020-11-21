package basePackage.model.test;

import basePackage.model.question.Question;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private int id;
    private String name;
    private List<Question> questionsList;

    public Test() {
        questionsList = new ArrayList<Question>();
    }

    public Test(String name, List<Question> questionsList) {
        this.name = name;
        this.questionsList = questionsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<Question> questionsList) {
        this.questionsList = questionsList;
    }
}
