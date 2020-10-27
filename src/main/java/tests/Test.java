package tests;

import questions.*;

public class Test {
    private String name;
    private InterfaceQuestion[] questions;

    public void setName(String arg){

    }

    public String getName(){
        return this.name;
    }

    public void setQuestions(InterfaceQuestion[] arg){
        questions = arg;
    }

    public void showQuestion(){
        for (InterfaceQuestion g:questions
             ) {
            g.showQuestionAnswer();
        }
    }

    public void changeQuestion(String arg, int i){
        questions[i].setQuestion(arg);
    }

    public void deleteQuestion(){

    }

    public void editQuestion(){

    }


}
