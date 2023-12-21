import java.util.*;

class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashMap<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).put(edge[1], edge[2]);
            graph.get(edge[1]).put(edge[0], edge[2]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        pq.offer(new int[]{0, maxMoves});
        Map<Integer, Integer> dist = new HashMap<>();
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int u = node[0], moves = node[1];
            if (!dist.containsKey(u)) {
                dist.put(u, moves);
                for (int v : graph.get(u).keySet()) {
                    int moves2 = moves - graph.get(u).get(v) - 1;
                    if (!dist.containsKey(v) && moves2 >= 0) {
                        pq.offer(new int[]{v, moves2});
                    }
                }
            }
        }
        int res = dist.size();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], cnt = edge[2];
            int du = dist.getOrDefault(u, 0), dv = dist.getOrDefault(v, 0);
            res += Math.min(cnt, du + dv);
        }
        return res;
    }
}