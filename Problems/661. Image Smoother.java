/*
Problem Link: https://leetcode.com/problems/image-smoother/
*/

import java.util.*;

class Solution {
    public int[][] imageSmoother(int[][] img) {
        int[][] ans = new int[img.length][img[0].length];
        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
        
        for(int i=0; i<img.length; i++){
            for(int j=0; j<img[0].length; j++){
                int sum = img[i][j];
                int count = 1;
                for(int k=0; k<8; k++){
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if(x>=0 && x<img.length && y>=0 && y<img[0].length){
                        sum += img[x][y];
                        count++;
                    }
                }
                ans[i][j] = sum/count;
            }
        }
        return ans;
    }
}