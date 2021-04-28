import java.util.ArrayList;
import java.util.Arrays;

// ORDER IS <Barbecuing, Frisbee, Hiking, HorsebackRiding, and Gardening>
public class Answers {
    private String name;
    private Integer barbecueTotal;//all of our weight totals
    private Integer frisbeeTotal;
    private Integer hikingTotal;
    private Integer horsebackRidingTotal;
    private Integer gardeningTotal;
    private ArrayList<Integer> runningTotals = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0));
    //TODO: Use runningTotals somehow

    public void storeTotals(ArrayList<Integer> weights) {//method to actually store our weighted totals that determine the final answer.
        this.barbecueTotal = weights.get(0); //sets all the individual totals to what they are in the inputted arraylist
        this.frisbeeTotal = weights.get(1);
        this.hikingTotal = weights.get(2);
        this.horsebackRidingTotal = weights.get(3);
        this.gardeningTotal = weights.get(4);
        runningTotals.set(0, runningTotals.get(0) + barbecueTotal);
        runningTotals.set(1, runningTotals.get(1) + frisbeeTotal);
        runningTotals.set(2, runningTotals.get(2) + hikingTotal);
        runningTotals.set(3, runningTotals.get(3) + horsebackRidingTotal);
        runningTotals.set(4, runningTotals.get(4) + gardeningTotal);

    }

    public int biggestTotal() { //just finds the biggest total so we can decide which final outcome to show
        int max = runningTotals.get(0);
        int count = 0;
        for(int i : runningTotals) {
            if(i > max) {
                max = i;
                count++;
            }
        }
        switch(count){
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
        }
        return 0;
    }
    public void resetWeights() {
        this.barbecueTotal = 0; //sets all the individual totals to what they are in the inputted arraylist
        this.frisbeeTotal = 0;
        this.hikingTotal = 0;
        this.horsebackRidingTotal = 0;
        this.gardeningTotal = 0;
        runningTotals.set(0, 0);
        runningTotals.set(1, 0);
        runningTotals.set(2, 0);
        runningTotals.set(3, 0);
        runningTotals.set(4, 0);

    }

    public String toString(){
        return "B:" + barbecueTotal + " F:" + frisbeeTotal + " Hi:" + hikingTotal + " Ho:" + horsebackRidingTotal + " G:" + gardeningTotal;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}