import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.*;
import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class EndPane extends BorderPane{
    public EndPane(Answers answers, EventHandler<ActionEvent> callback){
        int finalResult = answers.biggestTotal();
        Stop[] stops = new Stop[]  { new Stop(0, Color.PALETURQUOISE), new Stop(1, Color.PALEVIOLETRED)};
        LinearGradient lg1 = new LinearGradient(0,0,1,0,true, CycleMethod.NO_CYCLE, stops);
        setBackground(new Background(new BackgroundFill(lg1, null,null)));
        ImageView barbecue = new ImageView("barbecue.gif");
        ImageView frisbee = new ImageView("milhouse.gif");
        ImageView hiking = new ImageView("hiker.gif");
        ImageView horse = new ImageView("horsey.gif");
        ImageView gardening = new ImageView("garden.gif");
        Label label = new Label(answers.getName() + "! Your results are in!");
        setTop(label);
        VBox resultRestart = new VBox();
        HBox buttons = new HBox();
        buttons.setSpacing(30);
        resultRestart.setSpacing(30);

        Label result = new Label("");
        setBottom(result);
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        label.setStyle("-fx-text-alignment: center");
        label.setWrapText(true);
        setAlignment(getTop(), Pos.CENTER);
        result.setFont(Font.font("Georgia", FontWeight.BOLD, 24));
        result.setStyle("-fx-text-alignment: center");
        result.setWrapText(true);
        setAlignment(getBottom(), Pos.CENTER);
        Button restartButton = new Button("Restart Quiz!");
        Button saveButton = new Button("Save this page!");
        restartButton.setFont((Font.font("Tahoma", FontWeight.BOLD, 30)));
        saveButton.setFont((Font.font("Tahoma", FontWeight.BOLD, 30)));
        buttons.getChildren().addAll(restartButton, saveButton);
        buttons.setAlignment(Pos.CENTER);
        resultRestart.getChildren().addAll(result, buttons);
        setBottom(resultRestart);
        resultRestart.setAlignment(Pos.BOTTOM_CENTER);
        restartButton.setOnAction(callback);
        saveButton.setOnAction(event -> {
            File savedImage = new File("savedimage.png");
            WritableImage snapshot = this.snapshot(null, null);
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", savedImage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        setPadding(new Insets(30, 0, 30, 0));
        switch(finalResult){
            case 1:
                result.setText("If you were a spring activity you would be: Barbecuing!");
                setCenter(barbecue);
                break;
            case 2:
                result.setText("If you were a spring activity you would be: Frisbee!");
                setCenter(frisbee);
                break;
            case 3:
                result.setText("If you were a spring activity you would be: Hiking!");
                setCenter(hiking);
                break;
            case 4:
                result.setText("If you were a spring activity you would be: Horseback Riding!");
                setCenter(horse);
                break;
            case 5:
                result.setText("If you were a spring activity you would be: Gardening!");
                setCenter(gardening);
                break;
            default:
                result.setText("The results are inconclusive, sorry!"); //this message should never be shown
        }
    }
}
