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
        primaryStage.setTitle("Hello World");
        EventHandler<MouseEvent> miscEvent = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e){
                System.out.println("" + border.getWidth() + "||" + border.getHeight());
            }
        };
        Question question1 = new Question("What is your favorite flavor of ice-cream????",
                "Chocolate Strawberry Vanilla Rocky_Road",
                "chocolate.gif strawberry.gif vanilla.gif rockyroad.jpg");
        loadQuestion(question1, border);

        primaryStage.setScene(new Scene(border, 724, 700));
        primaryStage.setResizable(false);
        Button sizereturn = new Button("Return size");
        sizereturn.addEventFilter(MouseEvent.MOUSE_CLICKED, miscEvent);
        border.setBottom(sizereturn);
        primaryStage.show();
    }

    private void loadQuestion(Question question, BorderPane border){
        border.getChildren().clear();
        Label label = new Label(question.getQuestion());
        label.setFont(Font.font("Tahoma", 30));
        label.setWrapText(true);
        border.setTop(label);
        border.setAlignment(border.getTop(), Pos.CENTER);
        border.setCenter(new GridPane());
        GridPane buttons = (GridPane)border.getCenter();
        Button b1 = new Button();
        Button b2 = new Button();
        Button b3 = new Button();
        Button b4 = new Button();
        buttons.add(b1, 0, 0, 1, 1);
        buttons.add(new Label(question.getAnswers().get(0)), 0, 1, 1, 1);
        buttons.add(b2, 1, 0, 1, 1);
        buttons.add(new Label(question.getAnswers().get(1)), 1, 1, 1,  1);
        buttons.add(b3, 0, 2, 1, 1);
        buttons.add(new Label(question.getAnswers().get(2)), 0, 3, 1, 1);
        buttons.add(b4, 1, 2, 1, 1);
        buttons.add(new Label(question.getAnswers().get(3)), 1, 3, 1, 1);
        buttons.setAlignment(Pos.CENTER);
        buttons.setHgap(10);
        buttons.setVgap(10);
        ArrayList<ImageView> pictures = new ArrayList<ImageView>();
        pictures.add(new ImageView(question.getImageDir().get(0)));
        pictures.add(new ImageView(question.getImageDir().get(1)));
        pictures.add(new ImageView(question.getImageDir().get(2)));
        pictures.add(new ImageView(question.getImageDir().get(3)));
        for(int i = 0; i < 8; i++){
            if(buttons.getChildren().get(i) instanceof Button) {
                Button currentButton = (Button)buttons.getChildren().get(i);
                currentButton.setGraphic(pictures.get(i/2));
            }
        }

        buttons.setPadding(new Insets(10, 50, 10, 50));
        b1.setOnAction(event -> {
            Label answerLabel = (Label)getNodeRowCol(buttons.getRowIndex(b1)+1, buttons.getColumnIndex(b1), buttons);
            String finalAnswer = answerLabel.getText();
            System.out.println(finalAnswer);
        });
        b2.setOnAction(event -> {
            Label answerLabel = (Label)getNodeRowCol(buttons.getRowIndex(b2)+1, buttons.getColumnIndex(b2), buttons);
            String finalAnswer = answerLabel.getText();
            System.out.println(finalAnswer);
        });
        b3.setOnAction(event -> {
            Label answerLabel = (Label)getNodeRowCol(buttons.getRowIndex(b3)+1, buttons.getColumnIndex(b3), buttons);
            String finalAnswer = answerLabel.getText();
            System.out.println(finalAnswer);
        });
        b4.setOnAction(event -> {
            Label answerLabel = (Label)getNodeRowCol(buttons.getRowIndex(b4)+1, buttons.getColumnIndex(b4), buttons);
            String finalAnswer = answerLabel.getText();
            System.out.println(finalAnswer);
        });
    }

    public Node getNodeRowCol(int row, int column, GridPane grid){
        Node result = null;
        ObservableList<Node> children = grid.getChildren();

        for (Node node : children) {
            if(grid.getRowIndex(node) == row && grid.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        launch(args);
    }
}

