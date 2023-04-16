/*
Problem Link: https://leetcode.com/problems/find-players-with-zero-or-one-losses/
*/

import java.util.*;

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {

        Set<Integer> teams = new HashSet<>();
        HashMap<Integer, Integer> loser = new HashMap<>();

        for(int[] match : matches) {
            teams.add(match[0]);
            teams.add(match[1]);
            loser.put(match[1], loser.getOrDefault(match[1], 0) + 1);
        }

        List<Integer> teamNotLostAnyMatch = new ArrayList<>();
        for(int team : teams) {
            if(!loser.containsKey(team)) {
                teamNotLostAnyMatch.add(team);
            }
        }

        List<Integer> teamLostOnlyOneMatch = new ArrayList<>();
        for(int team : teams) {
            if(loser.containsKey(team) && loser.get(team) == 1) {
                teamLostOnlyOneMatch.add(team);
            }
        }

        teamNotLostAnyMatch.sort(Comparator.naturalOrder());
        teamLostOnlyOneMatch.sort(Comparator.naturalOrder());
        
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(teamNotLostAnyMatch);
        answer.add(teamLostOnlyOneMatch);
        return answer;
    }
}