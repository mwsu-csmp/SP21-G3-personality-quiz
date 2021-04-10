import javafx.scene.image.Image;

import java.util.ArrayList;

public class Question {
    String message;
    ArrayList<String> answers;
    String image;
    public Question(String message, String answers, String image){
        this.message = message;
        this.image = image;
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
        this.answers = answerList;
    }

    public String toString(){

        StringBuffer stringList = new StringBuffer();
        for(String s : this.answers){
            stringList.append(s);
        }
        return "Question: "+ this.message + "Answers = "+ stringList.toString();
    }
    public String getImageDir(){
        return this.image;
    }
    public String getQuestion(){
        return this.message;
    }
    public ArrayList<String> getAnswers(){
        return this.answers;
    }

}
