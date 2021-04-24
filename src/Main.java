import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.function.Consumer;


public class Main extends Application {
    private StartPane startPane;
    private Scene startScene;
    private Scene quizScene;
    private Question currentQuestion;
    private Question nextQuestion;
    ArrayList<Question> questions = new ArrayList<Question>();

    @Override
    public void start(Stage primaryStage) throws Exception{
        StackPane rootPane = new StackPane();
        BorderPane border = new BorderPane();
        primaryStage.setTitle("What Spring Activity are You?");
        startPane = new StartPane(event -> primaryStage.setScene(quizScene));
        startScene = new Scene(startPane, 500, 500);
        rootPane.getChildren().add(border);
        quizScene = new Scene(rootPane, 800, 750);

        ProgressBar p1 = new ProgressBar(0.0);
        Label errors = new Label("");
        errors.setWrapText(true);
        Button nextButton = new Button("Next question!");
        nextButton.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        nextButton.setPrefSize(200, 80);
        nextButton.setMinSize(Button.USE_PREF_SIZE, Button.USE_PREF_SIZE);
        HBox buttBox = new HBox(nextButton); //great variable name
        rootPane.getChildren().addAll(p1, errors, buttBox);
        p1.setPrefSize(300, 20);
        p1.setMinSize(ProgressBar.USE_PREF_SIZE, ProgressBar.USE_PREF_SIZE);
        p1.setTranslateX(-50); //moves left from the right most window boundary
        p1.setTranslateY(-50);
        errors.setTranslateX(-50);
        errors.setTranslateY(-25);
        buttBox.setAlignment(Pos.BOTTOM_LEFT);
        buttBox.setTranslateX(50);
        buttBox.setTranslateY(-25);
        buttBox.setMaxHeight(Button.USE_PREF_SIZE);
        //buttBox.setBackground(new Background(new BackgroundFill(Color.RED, null,null))); //used to see the boundaries of buttbox
        rootPane.setAlignment(Pos.BOTTOM_RIGHT);
        // ORDER IS <Barbecuing, Frisbee, Hiking, HorsebackRiding, and Gardening>

        Answers answers = new Answers();
        questions.add(new Question(
                "What is your favorite flavor of ice-cream????",
                "Chocolate Strawberry Vanilla Rocky_Road",
                "<20 10 25 50 5> <5 20 15 15 50> <20 30 20 20 30> <40 15 50 10 20>",
                "chocolate.gif strawberry.gif vanilla.gif rockyroad.jpg"));
        questions.add(new Question(
                "Pick an outfit.",
                "Outfit_1 Outfit_2 Outfit_3 Outfit_4",
                "<10 25 40 15 5> <15 20 10 30 50> <15 45 20 10 30> <30 35 10 20 10>",
                "cop.gif largejacket.gif skater.gif supreme.gif"));
        currentQuestion = questions.get(0);
        currentQuestion.load(border);
        nextButton.setOnAction(e -> {
            if(currentQuestion.getCurrentAnswer() == null){
                errors.setText("You need to select an answer first!");
            } else {
                answers.storeTotals(currentQuestion.getCurrentWeights());
                System.out.println(answers.toString());
                errors.setText("");
                try {
                    currentQuestion = getNextQuestion();
                    currentQuestion.load(border);
                }
                catch(IndexOutOfBoundsException x){
                    errors.setText("No more questions!");
                }
            }
        });



//TODO: Make the program check if there is a currentAnswer for the last question, if there isn't, then prevent moving to next question, also add progress bar
        border.setPadding(new Insets(25));
        primaryStage.setScene(startScene);
        primaryStage.show();
    }

    private Question getNextQuestion() throws IndexOutOfBoundsException{
        return questions.get(questions.indexOf(currentQuestion)+1);
    }


    public static void main(String[] args) {
        launch(args);
    }
}

