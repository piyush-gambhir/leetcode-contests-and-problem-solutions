/*
## Scenario
- Rooms: You have rooms numbered from 0 to n-1.
- Meetings: Meetings are defined by a start time (starti) and an end time (endi). The interval is half-closed, meaning the meeting includes the start time but not the end time.
- Uniqueness: All start times are unique. No two meetings begin at the exact same moment. 

## Room Allocation Rules
- Prioritize Lowest Room Number: Meetings are assigned to the available room with the lowest number.
- Delays: If no rooms are currently available, the meeting gets delayed. When a room frees up, the delayed meeting takes place (with its original duration).
- Start Time Priority: Among delayed meetings, priority is given to the meeting that had the earliest original start time.

## Goal
You need to find the room that holds the most meetings during the entire schedule. If there's a tie, return the room with the lowest number.

## Approach
1. Sorting: Arrange meeting start and end times to efficiently track room availability.
2. Priority Queue (Min-heap): Maintain available rooms. The room at the top of the heap is the one with the lowest number.
3. Tracking Usage: Store the end time of the meeting currently occupying each room.

## Example

meetings = [[1,4], [2,5], [7,9]]

Here's how the allocation might work:

- Meeting 1 (1,4): Allocated to Room 0 (lowest available)
- Meeting 2 (2,5): Allocated to Room 1 (Room 0 is still occupied)
- Meeting 1 ends (at time 4).
- Meeting 3 (7,9): Has to be delayed since no rooms are free.
- Meeting 2 ends (at time 5). Room 0 becomes available.
- Meeting 3 (7,9): Allocated to Room 0.

In this example, Room 0 held two meetings, making it the room that held the most meetings.
*/

import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(i); 
        }
        int[] roomCounts = new int[n];

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            while (!pq.isEmpty() && pq.peek() <= start) {
                int room = pq.poll();
                roomCounts[room]++;
                pq.offer(end);
            }

            int room = pq.poll();
            roomCounts[room]++;
            pq.offer(end);
        }

        int maxCount = 0;
        int mostUsedRoom = 0;

        for (int i = 0; i < n; i++) {
            if (roomCounts[i] > maxCount) {
                maxCount = roomCounts[i];
                mostUsedRoom = i;
            }
        }

        return mostUsedRoom;
    }
}
