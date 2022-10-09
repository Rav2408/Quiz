package pl.edu.pb.wi;

public class Question {
    private int questionId;
    private boolean answer;

    public Question(int questionId, boolean answer) {
        this.questionId = questionId;
        this.answer = answer;
    }

    public boolean getAnswer() {
        return answer;
    }

    public int getQuestionId() {
        return questionId;
    }
}
