package database.questionsdb;

import questions.Question;
import questions.TypeQuestion;

import java.io.File;
import java.io.*;
import java.util.*;

public class QuestionDB implements QuestionInterface {

    public void createQuestion(Question question){

    }

    public List<Question> readQuestion(){
        List<Question> questionsList = new ArrayList<Question>();
        File f = new File("C:/Users/tolya/Testing/DataBase/Questions.txt");
        BufferedReader br = null;
        try{
            Question question = new Question();
            br = new BufferedReader(new FileReader(f));
            String str = null;
            String check = null;
            while ((str = br.readLine()) != null){
                if (str == "\n"){
                    questionsList.add(question);
                    question = null;
                }
                if(check.equals("|Question|")){
                    question.setQuestion(str);
                }
                if(check.equals("|Type|")){
                    question.setTypeQuestion(TypeQuestion.ONE_ANSWER);
                }
                if(check.equals("|Answer|")){
                    question.setQuestion(str);
                }
                if(check.equals("|iSCorrect|")){
                    question.setQuestion(str);
                }
                if(check.equals("|Author|")){
                    question.setQuestion(str);
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if(br != null) {
                try { br.close(); }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return questionsList;
    }

    public void updateQuestion(Question question){

    }

    public void deleteQuestion(Question question){

    }
}
