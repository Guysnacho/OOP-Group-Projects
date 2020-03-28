//Author: Isaac Ojigho
//Input: Card[] hand
// What it does: This stats class has two methods: a total reps method and a total reps method skipped.
// this tells the number of The total number of repetitions per exercise, the total number of repetitions per exercise that were skipped and what was the biggest number of repetitions in a single hand for each exercise
public class stats {
  public int PushupReps, PushupRepskipped, SquatReps, SitupReps, LoungeReps, SquatRepskipped, SitupRepskipped, LoungeRepskipped, BignReps = 0;

  public void getTotalReps(Card hand[]){
     for(int i = 0; i < 7; i++) {
    	if(hand[i].getWorkout() == "Push Ups"){
        PushupReps += hand[i].getReps();
      } else if(hand[i].getWorkout() == "Squats"){
        SquatReps += hand[i].getReps();
      }else if(hand[i].getWorkout() == "Sit Ups"){
        SitupReps += hand[i].getReps();
      }else if(hand[i].getWorkout() == "Lounges"){
        LoungeReps += hand[i].getReps();
      }
       
    }
    
    if(PushupReps >= SquatReps && PushupReps >= SitupReps && PushupReps >= LoungeReps){
      BignReps = PushupReps;
    }else if(SquatReps >= PushupReps && SquatReps >= SitupReps && SquatReps >= LoungeReps){
      BignReps = SquatReps;
    }else if(SitupReps >= PushupReps && SitupReps >= SquatReps && SitupReps >= LoungeReps){
      BignReps = SquatReps;
    } else if(LoungeReps >= PushupReps && LoungeReps >= SitupReps && LoungeReps >= SquatReps){
      BignReps = LoungeReps;
    }
   //getTotalRepSkipped(Card[] hand);
  
  }
public void getTotalRepSkipped(Card hand[]) {
  for(int i = 0; i < 7; i++) {
    if(hand[i].getAction() == "SKIP" && hand[i].getWorkout() == "Push Ups"){
      for(int j = 0; j < 7;j++){
       if (hand[j].getWorkout() == "Push Ups"){
         PushupRepskipped += hand[i].getReps();
       }

      }
    }else if(hand[i].getAction() == "SKIP" && hand[i].getWorkout() == "Sit Ups"){
      for(int t = 0; t < 7;t++){
       if (hand[t].getWorkout() == "Sit Ups"){
         SitupRepskipped += hand[i].getReps();
       }

      }
    }else if(hand[i].getAction() == "SKIP" && hand[i].getWorkout() == "Lounges"){
      for(int t = 0; t < 7;t++){
       if (hand[t].getWorkout() == "Lounges"){
         LoungeRepskipped += hand[i].getReps();
       }

      }
    }else if(hand[i].getAction() == "SKIP" && hand[i].getWorkout() == "Squats"){
      for(int t = 0; t < 7;t++){
       if (hand[t].getWorkout() == "Squats"){
         SquatRepskipped += hand[i].getReps();
       }

      }
    }
      }
  }



}
