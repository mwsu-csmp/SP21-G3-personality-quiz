import javafx.scene.image.Image;

import java.util.ArrayList;

public class Question {
    String message;
    ArrayList<String> answers;
    ArrayList<String> images;

    public Question(String message, String answers, String images){
        this.message = message;
        ArrayList<String> answerList = new ArrayList<String>();
        StringBuilder current = new StringBuilder();
        for (int i = 0; i < answers.length(); i++){
            char c = answers.charAt(i);
            if(c != ' '){
                current.append(c);
            }else {
                answerList.add(current.toString());
                current.setLength(0);
            }
        }
        answerList.add(current.toString());

        current.setLength(0);
        ArrayList<String> imageList = new ArrayList<String>();
        for (int i = 0; i < images.length(); i++){
            char c = images.charAt(i);
            if(c != ' '){
                current.append(c);
            }else {
                imageList.add(current.toString());
                current.setLength(0);
            }
        }
        imageList.add(current.toString());
        this.answers = answerList;
        this.images = imageList;
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
    public ArrayList<String> getAnswers(){
        return this.answers;
    }

}
