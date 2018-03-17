package ro.siit.votingSystem;

public class ExitPoll extends Thread {

    private BallotBox ballotBox;

    public ExitPoll(BallotBox ballotBox) {
        this.ballotBox = ballotBox;
    }

    @Override
    public void run() {
        while(true) {
            ElectionSystem.printResults("Intermediate results", this.ballotBox.getResults());
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }
}
