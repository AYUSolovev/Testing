package questions;

public abstract class Question implements InterfaceQuestion {
    protected String question;
    protected String authorQuestion;
    protected int point;
    protected String[] correctAnswer;

    public void setQuestion(String arg){

    }

    public String getQuestion(){
        return this.question;
    }

    public void setAuthorQuestion(String arg){

    }

    public String getAuthorQuestion(){
        return this.authorQuestion;
    }

    public void setPoint(int arg){
        this.point = arg;
    }

    public int getPoint(){
        return this.point;
    }

    public void setCorrectAnswer(String[] arg){

    }

    public String[] getCorrectAnswer(){
        return this.correctAnswer;
    }


}
