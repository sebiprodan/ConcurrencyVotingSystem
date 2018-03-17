package ro.siit.votingSystem;

import java.util.Map;

public class ElectionSystem {
    public static void main(String[] args) {
        BallotBox ballotBox = new BallotBox();
        int votersCount = Randomizer.getVotersCount();
        Voter[] voters = new Voter[votersCount];
        for (int i = 0; i < votersCount; i++) {
            voters[i] = new Voter(i, ballotBox);
            voters[i].start();
        }

        ExitPoll exitPoll = new ExitPoll(ballotBox);
        exitPoll.setDaemon(true);
        exitPoll.start();

        for (Voter voter: voters) {
            try {
                voter.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //display results
        ElectionSystem.printResults("Final results", ballotBox.getResults());
    }

    public static void printResults(String message, Map<Candidate, Integer> results){
        System.out.println("-------------------");
        System.out.println(message);
        for (Candidate candidate : results.keySet()){
            System.out.println(candidate + ":" + results.get(candidate));
        }
        System.out.println("-------------------");
    }
}
