
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainFX extends Application {

   private QuizGame quizGame;

   @Override
   public void start(Stage primaryStage) {
    //Initialize quiz game
     Question q1 = new Question(
"What is the capital of France?",
       new String[] {"Berlin", "Madrid", "Paris", "Rome"},
2, "Easy", 5
     );

     Question q2 = new Question(
"Who developed Java?",
       new String[] {"Microsoft", "Sun Microsystems", "Google", "Apple"},
1, "Medium", 10
     );

     Question q3 = new Question(
"Which is the largest planet in our solar system?",
       new String[] {"Earth", "Mars", "Jupiter", "Saturn"},
2, "Hard", 15
     );

     Question[] questions = {q1, q2, q3};
     quizGame = new QuizGame(questions);

     // Build UI
     primaryStage.setTitle("Quiz Game");
     VBox vbox = new VBox();

     Label questionLabel = new Label(quizGame.getCurrentQuestion().getQuestion());
    vbox.getChildren().add(questionLabel);

    ToggleGroup optionsGroup = new ToggleGroup();
    RadioButton[] optionButtons = new RadioButton[4];
    for (int i = 0; i < 4; i++) {
    optionButtons[i] = new RadioButton(quizGame.getCurrentQuestion().getOptions()[i]);

    optionButtons[i].setToggleGroup(optionsGroup);

    vbox.getChildren().add(optionButtons[i]);
    }

    Button submitButton = new Button("Submit");
    vbox.getChildren().add(submitButton);

    submitButton.setOnAction(e -> {
    RadioButton selectedButton = (RadioButton) optionsGroup.getSelectedToggle();
    if (selectedButton != null) {
    int selectedIndex = java.util.Arrays.asList(optionButtons).indexOf(selectedButton);

    boolean correct = quizGame.answerCurrentQuestion(selectedIndex);
    if (correct) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Correct!");
    alert.showAndWait();
    } else {
      Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong!");
      alert.showAndWait();
      }
    if (quizGame.hasNextQuestion()) {
    quizGame.nextQuestion();
    questionLabel.setText(quizGame.getCurrentQuestion().getQuestion());
   for (int i = 0; i < 4; i++) {
    optionButtons[i].setText(quizGame.getCurrentQuestion().getOptions()[i]);
   }
   } else {
      Alert alert = new Alert(Alert.AlertType.INFORMATION, "Quiz Finished! Final score:" + quizGame.getScore());
      alert.showAndWait();
    }
 
  }

 });

 Scene scene = new Scene(vbox, 400, 300);
  primaryStage.setScene(scene);
  primaryStage.show();
 }
  public static void main(String[] args) {
  launch(args);
 }

}