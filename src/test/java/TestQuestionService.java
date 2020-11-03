import database.questionsdb.*;
import questions.*;
import singleton.Singleton;

import java.util.*;

public class TestQuestionService {
    public static void main(String[] args) {
        Singleton.getSingleton().setConnection("jdbc:h2:/C:/Users/tolya/Testing/DataBase/Testing");
        TestQuestionService testQuestionService = new TestQuestionService();
        //testQuestionService.testCreate("Question2",5,TypeQuestion.ONE_ANSWER,"Author2");
        testQuestionService.testRead(5);
    }

    public void testCreate(String quest, int testId, TypeQuestion typeQuestion,String author){
        Question question = new Question();
        question.setQuestion(quest);
        question.setTestId(testId);
        question.setTypeQuestion(typeQuestion);
        question.setAuthorQuestion(author);
        QuestionService questionService = new QuestionServiceImpl();
        questionService.createQuestion(question);
    }

    public void testRead(int testId){
        QuestionService questionService = new QuestionServiceImpl();
        List<Question> questionsList = new ArrayList<Question>();
        questionsList = questionService.readQuestion(testId);
        for(int i = 0; i < questionsList.size(); i++){
            System.out.println(questionsList.get(i).getId() + " " + questionsList.get(i).getQuestion()
            + " " + questionsList.get(i).getTestId() + " " + questionsList.get(i).getAuthorQuestion() + " "
            + questionsList.get(i).getTypeQuestion());
        }
    }
}
