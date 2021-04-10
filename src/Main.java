import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        StackPane rootPane = new StackPane();
        GridPane grid = new GridPane();
        primaryStage.setTitle("Hello World");
        Question question1 = new Question("What is your favorite flavor of ice-cream????", "Chocolate Strawberry Vanilla Rocky_Road", "icecream.gif");
        System.out.println(question1.toString());
        Label label = new Label(question1.getQuestion());
        label.setFont(Font.font("Comic Sans MS", 24));
        Image image = new Image(question1.getImageDir());
        grid.add(label, 1, 1, 5, 1);
        grid.add(new ImageView(image), 1, 2, 5, 1);
        grid.setGridLinesVisible(true);
        TilePane buttonGrid = generateButtonLayout(4,question1.getAnswers());
        buttonGrid.setPadding(new Insets(0, 0, 30, 0));
        buttonGrid.setAlignment(Pos.BOTTOM_CENTER);

        grid.setAlignment(Pos.TOP_CENTER);
        rootPane.getChildren().addAll(grid, buttonGrid);
        primaryStage.setScene(new Scene(rootPane, 600, 700));

        primaryStage.show();
    }

    private TilePane generateButtonLayout(int buttonNum, ArrayList<String> answers){
        TilePane layout = new TilePane();
        layout.setHgap(10);
        layout.setPrefColumns(buttonNum);
        layout.getChildren().setAll(createButtons(buttonNum, answers));
        layout.setPadding(new Insets(10));

        return layout;
    }

    private Button[] createButtons(int buttonNum, ArrayList<String> answers) {
        Button[] buttons = new Button[buttonNum];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = createButton(answers.get(i));
        }

        return buttons;
    }

    private Button createButton(String answer) {
        Button button = new Button();
        button.setText(answer);
        button.setPrefWidth(125);

        return button;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
