/*import service.question.*;
import question.*;
import singleton.Singleton;

import java.util.*;

public class TestQuestionService {
    public static void main(String[] args) {
        Singleton.getSingleton().setConnection("jdbc:h2:/C:/Users/tolya/servlet.Testing/DataBase/servlet.Testing");
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
        QuestionAccessService questionService = new QuestionAccessServiceImpl();
        questionService.createQuestion(question);
    }

    public void testRead(int testId){
        QuestionAccessService questionService = new QuestionAccessServiceImpl();
        List<Question> questionsList = new ArrayList<Question>();
        questionsList = questionService.readQuestion(testId);
        for(int i = 0; i < questionsList.size(); i++){
            System.out.println(questionsList.get(i).getId() + " " + questionsList.get(i).getQuestion()
            + " " + questionsList.get(i).getTestId() + " " + questionsList.get(i).getAuthorQuestion() + " "
            + questionsList.get(i).getTypeQuestion());
        }
    }
}
*/