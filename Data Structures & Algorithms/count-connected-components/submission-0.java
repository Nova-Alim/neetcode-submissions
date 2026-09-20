class Solution {
    public int countComponents(int n, int[][] edges) {

        HashMap<Integer,List<Integer>> graph = new HashMap<>();

        int result=0;

        for(int row=0; row<edges.length;row++){

            int a= edges[row][0];
            int b= edges[row][1];

            if(!graph.containsKey(a)){
                List<Integer> list= new ArrayList<>();
                list.add(b);
                graph.put(a,list);
            }else{
                graph.get(a).add(b);
            }


            if(!graph.containsKey(b)){
                List<Integer> list= new ArrayList<>();
                list.add(a);
                graph.put(b,list);
            }else{
                graph.get(b).add(a);
            }
        }

        boolean[] visited= new boolean[n];

        Queue<Integer> queue = new LinkedList<>();

        for(int node=0; node<n; node++){

            if(!visited[node]){
               result++;
               visited[node]= true;
               queue.offer(node);


               while(!queue.isEmpty()){
                int current=queue.poll();

                if(graph.containsKey(current)){
                    
                    for(int neighbor: graph.get(current)){
                        if(!visited[neighbor]){
                            visited[neighbor]= true;
                            queue.offer(neighbor);
                        }
                    }
                }
               }
            }

        }

       
        return result;
    }
}
