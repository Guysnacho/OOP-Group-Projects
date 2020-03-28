//Author - Samuel Adetunji
//Class - CS 2365-002

public class Card{
    boolean isAction;
    Integer repNum;
    String exercise;
    String action;

    Card(){
        System.out.println("You didn't pass any parameters. Check your code and try again");
    }

    //Constructor for number cards - given the number and color/workout
    Card(Integer reps, String workout){
        setType(false);
        setWorkout(workout);
        setReps(reps);
        setAction("null");
    }

    //Constructor for Special cards - needs to be given the type of card and its color.
    //Wild cards are considered rainbow
    Card(String specific, String Color){
        setType(true);
        setWorkout(Color);
        setReps(0);
        setAction(specific);
    }

    //sets the Action string to something to something
    //Like wildcard or draw 2
    public void setAction(String name){
        action = name;
    }

    //sets the number of reps for this individual card
    public void setReps(Integer reps){
        repNum = reps;
    }

    //sets the isAction boolean for future use
    public void setType(boolean type){
        isAction = type;
    }

    //sets the exercise String for future use
    public void setWorkout(String workout){
        exercise = workout;
    }

    //returns the particular action for this card
    public String getAction(){
        return action;
    }

    //returns the reps aka the number on the card
    public Integer getReps(){
        return repNum;
    }

    //returns whether or not the card is an action card
    public boolean getType(){
        return isAction;
    }

    //returns the workout aka the color of the current card
    public String getWorkout(){
        return exercise;
    }
}
