package ro.siit.votingSystem;

public class Voter extends Thread {

    private BallotBox ballotBox;
    private int id;

    public Voter(Integer id, BallotBox ballotBox) {
        this.id = id;
        this.ballotBox = ballotBox;
    }

    @Override
    public void run() {
        try {
            sleep(Randomizer.getWaitingTime() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Candidate elected = Candidate.values()[Randomizer.getCandidateIndex(Candidate.values().length)];
        Vote vote = new Vote(elected);
        this.ballotBox.castVote(vote);
    }
}
