package 每日一题;

import java.util.*;

//git push origin master -u
public class daily_getSkyline_218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> b[1] - a[1]);
        List<Integer> arr = new ArrayList<Integer>();
        for (int[] building : buildings) {
            arr.add(building[0]);
            arr.add(building[1]);
        }
        Collections.sort(arr);

        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int n = buildings.length, idx = 0;
        for (int arrI : arr) {
            while (idx < n && buildings[idx][0] <= arrI) {
                pq.offer(new int[]{buildings[idx][1], buildings[idx][2]});
                idx++;
            }
            while (!pq.isEmpty() && pq.peek()[0] <= arrI) {
                pq.poll();
            }

            int maxn = pq.isEmpty() ? 0 : pq.peek()[1];
            if (ret.size() == 0 || maxn != ret.get(ret.size() - 1).get(1)) {
                ret.add(Arrays.asList(arrI, maxn));
            }
        }
        return ret;
    }

}
