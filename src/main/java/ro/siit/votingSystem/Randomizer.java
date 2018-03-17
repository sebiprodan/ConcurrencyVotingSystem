package ro.siit.votingSystem;

import java.util.Random;

public class Randomizer {
    public static int getWaitingTime(){
        return (new Random()).nextInt(10) + 5;
    }

    public static int getCandidateIndex(int size){
        return (new Random()).nextInt(size);
    }

    public static int getVotersCount(){
        return (new Random()).nextInt(1000) + 1 ;
    }
}
