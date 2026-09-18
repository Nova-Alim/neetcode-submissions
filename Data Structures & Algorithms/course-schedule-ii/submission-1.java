class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] prerequisiteCount = new int[numCourses];
        int[] result = new int[numCourses];
        int index = 0;

        for (int row = 0; row < prerequisites.length; row++) {
            int course = prerequisites[row][0];
            int preReq = prerequisites[row][1];

            if (!graph.containsKey(preReq)) {
                List<Integer> list = new ArrayList<>();
                list.add(course);

                graph.put(preReq, list);

            } else {
                graph.get(preReq).add(course);
            }
            prerequisiteCount[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (prerequisiteCount[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();

            result[index] = course;
            index++;


            if (graph.containsKey(course)) {
                for (int next : graph.get(course)) {
                    prerequisiteCount[next]--;

                    if (prerequisiteCount[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }

        if(index != numCourses){
            return new int[]{};
        }

        return result;
    }
}
