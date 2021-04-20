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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.function.Consumer;


public class Main extends Application {
    /*
        Look in GGClient login pane for ideas on how to use consumers and lambdas.
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane border = new BorderPane();
        primaryStage.setTitle("What Spring Activity are You?");
        Question question1 = new Question(
                "What is your favorite flavor of ice-cream????",
                "Chocolate Strawberry Vanilla Rocky_Road",
                "<20 10 25 50 5> <5 20 15 15 50> <20 30 20 20 30> <40 15 50 10 20>",
                "chocolate.gif strawberry.gif vanilla.gif rockyroad.jpg");
        question1.load(border);
//TODO: Make the program check if there is a currentAnswer for the last question, if there isn't, then prevent moving to next question

        border.setPadding(new Insets(25));
        primaryStage.setScene(new Scene(border, 750, 700));

        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}

