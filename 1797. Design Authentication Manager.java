/*
Problem Link: https://leetcode.com/problems/design-authentication-manager/
*/

import java.util.*;

class AuthenticationManager {
    int timeToLive;
    int currentTime;

    HashMap<String, Integer> map = new HashMap<>();

    public AuthenticationManager(int timeToLive) {
        this.currentTime = 0;
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        this.currentTime = currentTime;
        map.put(tokenId, currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        this.currentTime = currentTime;
        if (map.containsKey(tokenId)) {
            int time = map.get(tokenId);
            if (time + timeToLive > currentTime) {
                map.put(tokenId, currentTime);
            }
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        this.currentTime = currentTime;
        int count = 0;
        for (String key : map.keySet()) {
            int time = map.get(key);
            if (time + timeToLive > currentTime) {
                count++;
            }
        }
        return count;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */