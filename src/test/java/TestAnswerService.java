/*import service.answer.*;
import Answer;
import Singleton;

import java.util.*;


public class TestAnswerService {
    public static void main(String[] args){
        Singleton.getSingleton().setConnection("jdbc:h2:/C:/Users/tolya/basePackage.Testing/DataBase/basePackage.Testing");
        TestAnswerService testAnswerService = new TestAnswerService();
        //testAnswerService.testCreate(28,"Answer1",false);
        testAnswerService.testRead(28);
    }

    public void testCreate(int questionId, String ans, Boolean isCorrect){
        Answer answer = new Answer();
        answer.setQuestionId(questionId);
        answer.setAnswer(ans);
        answer.setIsCorrect(isCorrect);
        AnswerAccessService answerService = new AnswerAccessServiceImpl();
        answerService.createAnswer(answer);
    }

    public void testRead(int questionId){
        AnswerAccessService answerService = new AnswerAccessServiceImpl();
        List<Answer> answersList = new ArrayList<Answer>();
        answersList = answerService.readAnswer(questionId);
        for (int i = 0; i < answersList.size(); i++){
            System.out.println(answersList.get(i).getAnswer()  + " " + answersList.get(i).getIsCorrect() + " "
            + answersList.get(i).getQuestionId());
        }
    }
}
*/