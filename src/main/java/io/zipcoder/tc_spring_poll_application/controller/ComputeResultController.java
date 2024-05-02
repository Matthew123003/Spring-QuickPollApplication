package io.zipcoder.tc_spring_poll_application.controller;

import dtos.OptionCount;
import dtos.VoteResult;
import io.zipcoder.tc_spring_poll_application.domain.Option;
import io.zipcoder.tc_spring_poll_application.domain.Vote;
import io.zipcoder.tc_spring_poll_application.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/computeresult", method = RequestMethod.GET)
    public ResponseEntity<?> computeResult(@RequestParam Long pollId) {
        VoteResult voteResult = new VoteResult();
        Iterable<Vote> allVotes = voteRepository.findVotesByPoll(pollId);
        //TODO: Implement algorithm to count votes

        // Initialize a map to store the count of votes for each option
        Map<Long, Integer> optionVoteCounts = new HashMap<>();

        // Iterate over all votes
        for (Vote vote : allVotes) {
            Long optionId = vote.getOption().getId(); // Assuming getId() returns the ID of the option
            // Increment the count for the corresponding option
            optionVoteCounts.put(optionId, optionVoteCounts.getOrDefault(optionId, 0) + 1);
        }

        // Calculate the total number of votes
        int totalVotes = 0;
        for (Integer count : optionVoteCounts.values()) {
            totalVotes += count;
        }

        // Create a list to store OptionCount objects
        List<OptionCount> optionCounts = new ArrayList<>();

        // Populate the list with OptionCount objects based on the counts in optionVoteCounts
        for (Map.Entry<Long, Integer> entry : optionVoteCounts.entrySet()) {
            OptionCount optionCount = new OptionCount(entry.getKey(), entry.getValue());
            optionCounts.add(optionCount);
        }

        // Set the totalVotes and results fields of the VoteResult object
        voteResult.setTotalVotes(totalVotes);
        voteResult.setResults(optionCounts);

        // Return the computed result in a ResponseEntity with HTTP status OK
        return new ResponseEntity<VoteResult>(voteResult, HttpStatus.OK);
    }
}
