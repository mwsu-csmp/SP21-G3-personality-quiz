import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.*;

import java.util.function.Consumer;

public class StartPane extends BorderPane {

    private final Consumer<String> user;
    private String name;

    public StartPane(Consumer<String> user){
        this.user = user;
        Stop[] stops = new Stop[]  { new Stop(0, Color.PALETURQUOISE), new Stop(1, Color.PALEVIOLETRED)};
        LinearGradient lg1 = new LinearGradient(0,0,1,0,true, CycleMethod.NO_CYCLE, stops);
        setBackground(new Background(new BackgroundFill(lg1, null,null)));
        VBox ui = new VBox(10);
        TextField username = new TextField();
        username.setPrefSize(200, 18);
        username.setMaxSize(TextField.USE_PREF_SIZE, TextField.USE_PREF_SIZE);
        Label label = new Label("What Spring activity are you?");
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        label.setStyle("-fx-text-alignment: center");
        label.setWrapText(true);
        setTop(label);
        setAlignment(getTop(), Pos.CENTER);
        Label error = new Label("");
        error.setStyle("-fx-text-alignment: center");
        error.setWrapText(true);
        Button startButton = new Button("Start!");
        startButton.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        startButton.setPrefSize(120, 80);
        startButton.setMinSize(Button.USE_PREF_SIZE, Button.USE_PREF_SIZE);
        ui.getChildren().addAll(username, startButton, error);
        setBottom(ui);
        ui.setAlignment(Pos.CENTER);
        setAlignment(getBottom(), Pos.CENTER);
        ImageView startBanner = new ImageView("springbench.gif");
        setCenter(startBanner);
        setPadding(new Insets(0, 0,20, 0));
        startButton.setOnAction(event -> {
            if(!username.getText().equals("")){
                error.setText("");
                name = username.getText();
                user.accept(username.getText());
            } else {
                error.setText("Please enter a name!");
            }
        });
    }
    public String getName() { return name; }
}
