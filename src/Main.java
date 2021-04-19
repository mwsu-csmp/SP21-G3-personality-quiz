import javafx.application.Application;
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

        primaryStage.setScene(new Scene(border, 600, 700));
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
        border.setCenter(new TilePane());
        TilePane buttons = (TilePane)border.getCenter();
        Button b1 = new Button(question.getAnswers().get(0));
        Button b2 = new Button(question.getAnswers().get(1));
        Button b3 = new Button(question.getAnswers().get(2));
        Button b4 = new Button(question.getAnswers().get(3));
        buttons.getChildren().addAll(b1, b2, b3, b4);
        buttons.setAlignment(Pos.CENTER);
        buttons.setPrefColumns(2);
        buttons.setHgap(10);
        buttons.setVgap(10);
        ArrayList<ImageView> pictures = new ArrayList<ImageView>();
        pictures.add(new ImageView(question.getImageDir().get(0)));
        pictures.add(new ImageView(question.getImageDir().get(1)));
        pictures.add(new ImageView(question.getImageDir().get(2)));
        pictures.add(new ImageView(question.getImageDir().get(3)));
        for(int i = 0; i < 4; i++){
            Button currentButton = (Button)buttons.getChildren().get(i);
            currentButton.setGraphic(pictures.get(i));
            ButtonHandleClass buttonHandle = new ButtonHandleClass();
            currentButton.setOnAction(buttonHandle);
        }
        buttons.setPadding(new Insets(10, 50, 10, 50));

    }

    class ButtonHandleClass implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            Button sourceButton = (Button)e.getSource();
            System.out.println(sourceButton.getText());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

