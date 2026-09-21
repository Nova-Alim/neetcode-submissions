class Solution {
    public int[] findRedundantConnection(int[][] edges) {

            int n= edges.length;

            int[] parent= new int[n+1];

            for(int i=1; i<n; i++){
                parent[i]=i;
            }

            for(int[] edge: edges){
                int a= edge[0];
                int b= edge[1];

                int rootA= find(parent,a);
                int rootB= find(parent,b);

                if(rootA==rootB){
                    return edge;
                }

                parent[rootA]= rootB;
            }

            return new int[0];
    }

    private int find(int[] parent, int node){
            if(parent[node]==node){
                return node;
            }

            return parent[node]=find(parent,parent[node]);
    }
}
