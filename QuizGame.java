import java.util.List;
import java.util.ArrayList;

public class QuizGame {
  private List<Question> questions;
  private int score;
  private int currentQuestionIndex;

  public QuizGame(Question[] questions) {
   this.questions = new ArrayList<>();
   for (Question q : questions) {
      this.questions.add(q);
} 
 this.score =0;
 this.currentQuestionIndex = 0;
}

  public Question getCurrentQuestion() {
   return
   questions.get(currentQuestionIndex);
}

  public boolean answerCurrentQuestion(int selectedAnswer) {
  Question currentQuestion = questions.get(currentQuestionIndex);
  if 
  (currentQuestion.isCorrectAnswer(selectedAnswer)) {
  score += currentQuestion.getPoints();
  return true;
  } else {
    return false;
}

}
  public boolean hasNextQuestion() {
  return currentQuestionIndex < questions.size() - 1;
  }

  public void nextQuestion() {
  currentQuestionIndex++;
  }

  public int getScore() {
  return score;
  }
  
}
