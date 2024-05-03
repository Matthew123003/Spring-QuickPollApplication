package io.zipcoder.tc_spring_poll_application.controller;

import dtos.OptionCount;
import dtos.VoteResult;
import io.zipcoder.tc_spring_poll_application.domain.Option;
import io.zipcoder.tc_spring_poll_application.domain.Vote;
import io.zipcoder.tc_spring_poll_application.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ComputeResultController {
    private VoteRepository voteRepository;

    @Autowired
    public ComputeResultController(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @RequestMapping(value = "/results/{pollId}", method = RequestMethod.GET)
    public ResponseEntity<?> computeResult(@PathVariable Long pollId) {
        VoteResult voteResult = new VoteResult();
        Iterable<Vote> allVotes = voteRepository.findVotesByPoll(pollId);
        //TODO: Implement algorithm to count votes

        // Check if there are no votes for the given poll
        if (allVotes == null || !allVotes.iterator().hasNext()) {
            // Return a ResponseEntity with an empty body and HTTP status OK
            return ResponseEntity.ok().build();
        }

        // Initialize a map to store the count of votes for each option
        Map<Long, Integer> optionVoteCounts = new HashMap<>();

        // Iterate over all votes
        for (Vote vote : allVotes) {
            Long optionId = vote.getOption().getId(); // Assuming getId() returns the ID of the option
            // Increment the count for the corresponding option
            optionVoteCounts.put(optionId, optionVoteCounts.getOrDefault(optionId, 0) + 1);
        }

        // Calculate the total number of votes
        int totalVotes = optionVoteCounts.values().stream().mapToInt(Integer::intValue).sum();

        // Create a list to store OptionCount objects
        List<OptionCount> optionCounts = new ArrayList<>();

        // Populate the list with OptionCount objects based on the counts in optionVoteCounts
        for (Map.Entry<Long, Integer> entry : optionVoteCounts.entrySet()) {
            OptionCount optionCount = new OptionCount(entry.getKey(), entry.getValue());
            optionCounts.add(optionCount);
        }

        // Create a VoteResult object and set the totalVotes and results fields
        VoteResult voteResults = new VoteResult();
        voteResults.setTotalVotes(totalVotes);
        voteResults.setResults(optionCounts);

        // Return the computed result in a ResponseEntity with HTTP status OK
        return new ResponseEntity<>(voteResults, HttpStatus.OK);
    }
}
