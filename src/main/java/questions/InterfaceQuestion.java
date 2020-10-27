package questions;

public interface InterfaceQuestion {
        void setQuestion(String arg);
        String getQuestion();
        void setAuthorQuestion(String arg);
        String getAuthorQuestion();
        void setPoint(int arg);
        int getPoint();
        void setCorrectAnswer(String[] arg);
        String[] getCorrectAnswer();
        public void showQuestionAnswer();
}
