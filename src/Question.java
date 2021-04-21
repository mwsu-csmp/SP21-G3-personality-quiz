import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String message;
    private ArrayList<String> answers;
    private ArrayList<String> images;
    private String currentAnswer;
    private ArrayList<List<Integer>> answerWeights;
//TODO: Make a method that connects current Answer to the correct list of weights from answerWeights

    public Question(String message, String answers, String weights, String images){
        this.message = message;
        this.answers = deserialize(answers);
        this.images = deserialize(images);
        this.answerWeights = deserializeWeights(weights);
    }

    public String toString(){

        StringBuffer stringList = new StringBuffer();
        for(String s : this.answers){
            stringList.append(s);
        }
        return "Question: "+ this.message + "Answers = "+ stringList.toString();
    }
    public ArrayList<String> getImageDir(){
        return this.images;
    }
    public String getQuestion(){
        return this.message;
    }
    public ArrayList<String> getAnswers(){ return this.answers;
    }

    public void load(BorderPane border){
        border.getChildren().clear();
        border.setBackground(new Background(new BackgroundFill(Color.LAVENDERBLUSH, null, null)));
        Label label = new Label(this.getQuestion());
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        label.setStyle("-fx-text-alignment: center");
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
        buttons.add(new Label(this.getAnswers().get(0)), 0, 1, 1, 1);
        buttons.add(b2, 1, 0, 1, 1);
        buttons.add(new Label(this.getAnswers().get(1)), 1, 1, 1,  1);
        buttons.add(b3, 0, 2, 1, 1);
        buttons.add(new Label(this.getAnswers().get(2)), 0, 3, 1, 1);
        buttons.add(b4, 1, 2, 1, 1);
        buttons.add(new Label(this.getAnswers().get(3)), 1, 3, 1, 1);
        buttons.setAlignment(Pos.CENTER);
        buttons.setHgap(10);
        buttons.setVgap(10);
        ArrayList<ImageView> pictures = new ArrayList<ImageView>();
        pictures.add(new ImageView(this.getImageDir().get(0)));
        pictures.add(new ImageView(this.getImageDir().get(1)));
        pictures.add(new ImageView(this.getImageDir().get(2)));
        pictures.add(new ImageView(this.getImageDir().get(3)));
        for(int i = 0; i < 8; i++){
            if(buttons.getChildren().get(i) instanceof Button) {
                Button currentButton = (Button)buttons.getChildren().get(i);
                currentButton.setGraphic(pictures.get(i/2));
            }
        }
        buttons.setPadding(new Insets(10, 50, 10, 50));
        class ButtonHandler implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent e){
                Button currentButton = (Button)e.getSource();
                Label answerLabel = (Label)getNodeRowCol(buttons.getRowIndex(currentButton)+1, buttons.getColumnIndex(currentButton), buttons);
                String finalAnswer = answerLabel.getText();
                currentAnswer = finalAnswer;
                System.out.println(currentAnswer);
                System.out.println(answerWeights);
                System.out.println(getCurrentWeights());
            }
        }
        b1.setOnAction(new ButtonHandler());
        b2.setOnAction(new ButtonHandler());
        b3.setOnAction(new ButtonHandler());
        b4.setOnAction(new ButtonHandler());
    }

    private Node getNodeRowCol(int row, int column, GridPane grid){
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
    public String getCurrentAnswer() { return this.currentAnswer; }

    public ArrayList<Integer> getCurrentWeights() {
        int ansIndex = answers.indexOf(currentAnswer);
        return (ArrayList)answerWeights.get(ansIndex);
    }

    private ArrayList<String> deserialize(String input){
        ArrayList<String> accList = new ArrayList<String>();
        StringBuilder current = new StringBuilder();
        for (int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(c != ' '){
                current.append(c);
            }else {
                accList.add(current.toString());
                current.setLength(0);
            }
        }
        accList.add(current.toString());
        return accList;
    }

    private ArrayList<List<Integer>> deserializeWeights(String input){
        ArrayList<List<Integer>> accList = new ArrayList<List<Integer>>();
        StringBuilder current = new StringBuilder();
        int listCount = 0;
        for (int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(c == '<'){
                ArrayList<Integer> currentList = new ArrayList<Integer>();
                listCount++;
                String sub = input.substring(i+1, input.indexOf('>', i));
                for(String s : deserialize(sub)) currentList.add(Integer.valueOf(s));
                accList.add(currentList);
                i = input.indexOf('>', i);
                continue;
            }
        }
        return accList;
    }
}
