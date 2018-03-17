package ro.siit.votingSystem;

public class Vote {
    private Candidate elected;

    public Vote( Candidate elected) {
        this.elected = elected;
    }

    Candidate getElected(){
        return elected;
    }
}
