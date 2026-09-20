class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        Queue<int[]> queue = new LinkedList<>();

        for (int row = 0; row < edges.length; row++) {
            int a = edges[row][0];
            int b = edges[row][1];

            if (!graph.containsKey(a)) {
                List<Integer> list = new ArrayList<>();
                list.add(b);
                graph.put(a, list);
            } else {
                graph.get(a).add(b);
            }

            if (!graph.containsKey(b)) {
                List<Integer> list = new ArrayList<>();
                list.add(a);
                graph.put(b, list);
            } else {
                graph.get(b).add(a);
            }
        }

        boolean[] visited = new boolean[n];

        visited[0] = true;

        queue.offer(new int[] {0, -1});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int parent = current[1];

            if (graph.containsKey(node)) {
                for (int neighbor : graph.get(node)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(new int[] {neighbor, node});
                    } else if (neighbor != parent) {
                        return false;
                    }
                }
            }
        }

        for(boolean question: visited){
            if(question == false){
                return false;
            }
        }

        return true;
    }
}
