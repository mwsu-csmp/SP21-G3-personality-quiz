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

public class EndPane extends BorderPane{
    public EndPane(Answers answers){
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
