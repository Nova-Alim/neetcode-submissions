class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] prerequisiteCount = new int[numCourses];

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int row = 0; row < prerequisites.length; row++) {
            int course = prerequisites[row][0];
            int preReq = prerequisites[row][1];

            if (!graph.containsKey(preReq)) {
                List<Integer> list = new ArrayList<>();
                list.add(course);

                graph.put(preReq, list);

            } else {
                List<Integer> temp= graph.get(preReq);
                temp.add(course);
            }

            prerequisiteCount[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < prerequisiteCount.length; i++) {
            if (prerequisiteCount[i] == 0) {
                queue.offer(i);
            }
        }

        int completed = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            completed++;

            if (graph.containsKey(course)) {
                for (int next : graph.get(course)) {
                    prerequisiteCount[next]--;

                    if (prerequisiteCount[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }

        return completed == numCourses;
    }
}
