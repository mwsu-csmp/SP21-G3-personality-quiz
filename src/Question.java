public class Question {
    String message;
    String[] answers;
    String[] images;
    public Question(String message, String[] answers, String[] images){
        this.message = message;
        this.answers = answers;
        this.images = images;
    }

    public String toString(){
        StringBuilder answerString = new StringBuilder();
        for(int i = 0; i < this.answers.length; i++){
            answerString.append(i + ", ");
        }
        return "Question = " + message + "| Answers =  " + answerString;
    }

}
