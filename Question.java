public class Question {

    private String question;
    private String[] options;
    private int correctAnswer;
    private String difficulty;
    private int points;

    public Question(String question, String[] options, int correctAnswer, String difficulty, int points){

      this.question = question;
      this.options = options;
      this.correctAnswer = correctAnswer;
      this.difficulty = difficulty;
      this.points = points;
    }

    public String getQuestion() {
      return question;
    }

    public String[] getOptions() {
      return options;
    }

    public boolean isCorrectAnswer(int answer) {
      return correctAnswer == answer;
    }

    public String getDifficulty() {
      return difficulty;
    }

    public int getPoints() {
      return points;
    }

}