public class ErFenGrap {

    int V = 100;
    boolean[]color = new boolean[V];
    boolean[]marked = new boolean[V];
    boolean isBipartite = true;

    public boolean isBipartite(int[][] graph) {
        for(int i = 0; i < graph.length; i++){
            if(!isBipartite){//已知非二分图，提前结束
                break;
            }
            if(!marked[i]){
                dfs(graph,i);
            }
        }
        return isBipartite;
    }

    private void dfs(int[][]graph,int i){
        if(!isBipartite){
            return;
        }
        marked[i] = true;

        for(int neb : graph[i]){
            if(!marked[neb]){
                color[neb] = !color[i];
                dfs(graph,neb);
            }else if(color[neb] == color[i]){
                isBipartite = false;
            }
        }

    }



}
