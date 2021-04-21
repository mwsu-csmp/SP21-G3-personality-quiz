import java.util.ArrayList;
// ORDER IS <Barbecuing, Frisbee, Hiking, HorsebackRiding, and Gardening>
public class Answers {
    private Integer barbecueTotal;//all of our weight totals
    private Integer frisbeeTotal;
    private Integer hikingTotal;
    private Integer horsebackRidingTotal;
    private Integer gardeningTotal;
    private ArrayList<Integer> runningTotals;

    public void storeTotals(ArrayList<Integer> weights) {//method to actually store our weighted totals that determine the final answer.
        this.barbecueTotal = weights.get(0); //sets all the individual totals to what they are in the inputted arraylist
        this.frisbeeTotal = weights.get(1);
        this.hikingTotal = weights.get(2);
        this.horsebackRidingTotal = weights.get(3);
        this.gardeningTotal = weights.get(4);
        this.runningTotals.add(this.barbecueTotal); //adds all the totals to our running total arraylist that will be used to show the final total
        this.runningTotals.add(this.frisbeeTotal);
        this.runningTotals.add(this.hikingTotal);
        this.runningTotals.add(this.horsebackRidingTotal);
        this.runningTotals.add(this.gardeningTotal);


    }

    public int biggestTotal(ArrayList<Integer> weights) { //just finds the biggest total so we can decide which final outcome to show
        int max = weights.get(0);
        for(int i : weights) {
            if(i > max) {
                max = i;
            }
        }

        return max;
    }
    //TODO: have this class store the answers after each question answered.
}