import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

    private final Consumer<ActionEvent> beginGame;

    public StartPane(Consumer<ActionEvent> beginGame){
        this.beginGame = beginGame;
        Stop[] stops = new Stop[]  { new Stop(0, Color.PALETURQUOISE), new Stop(1, Color.PALEVIOLETRED)};
        LinearGradient lg1 = new LinearGradient(0,0,1,0,true, CycleMethod.NO_CYCLE, stops);
        setBackground(new Background(new BackgroundFill(lg1, null,null)));
        Label label = new Label("What Spring activity are you?");
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        label.setStyle("-fx-text-alignment: center");
        label.setWrapText(true);
        setTop(label);
        setAlignment(getTop(), Pos.CENTER);
        Button startButton = new Button("Start!");
        startButton.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        startButton.setPrefSize(120, 80);
        startButton.setMinSize(Button.USE_PREF_SIZE, Button.USE_PREF_SIZE);
        setBottom(startButton);
        setAlignment(getBottom(), Pos.CENTER);
        ImageView startBanner = new ImageView("springbench.gif");
        setCenter(startBanner);
        setPadding(new Insets(0, 0,30, 0));
        setBackground(new Background(new BackgroundFill(Color.LAVENDERBLUSH, null, null)));
        startButton.setOnAction(event -> {
            beginGame.accept(event);
        });
    }
}
