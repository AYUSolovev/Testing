package basePackage.model.question;

public class Answer {
    private boolean isCorrect;
    private String answer;
    private int questionId;

    public Answer() {
    }

    public Answer(boolean isCorrect, String answer, int questionId) {
        this.isCorrect = isCorrect;
        this.answer = answer;
        this.questionId = questionId;
    }

    public boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(boolean correct) {
        isCorrect = correct;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
}
