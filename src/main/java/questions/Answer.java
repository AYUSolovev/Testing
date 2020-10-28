package questions;

public class Answer {
    private boolean isCorrect;
    private String answer;

    public void setIsCorrect(boolean bool){
        this.isCorrect = bool;
    }

    public boolean getIsCorrect(){return this.isCorrect;}

    public void setAnswer(String arg){
        this.answer = arg;
    }

    public String getAnswer(){return this.answer;}
}
