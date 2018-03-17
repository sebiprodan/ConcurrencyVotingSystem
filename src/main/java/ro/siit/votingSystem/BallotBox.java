package ro.siit.votingSystem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BallotBox {
    private Set<Vote> votes = new HashSet<>();

    public synchronized void castVote(Vote vote){
        this.votes.add(vote);
        System.out.println(vote.getElected());
    }

    Map<Candidate, Integer> getResults(){
        Map<Candidate, Integer> results  = new HashMap<>();
        for(Candidate candidate: Candidate.values()){
            results.put(candidate, 0);
        }
        for(Vote vote : votes){
            results.put(vote.getElected(), results.get(vote.getElected())+ 1);
        }
        return results;
    }
}
