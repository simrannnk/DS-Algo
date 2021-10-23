import java.util.*;
class Solution {
    
     public boolean isBipartite(int[][] graph, int src, int[] vis) {
        // -1 -> undefine, 0 -> red, 1 -> green.

        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);
        int color = 0;

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int rvtx = que.removeFirst();
                if (vis[rvtx] != -1) {
                    if (vis[rvtx] != color) // conflict
                        return false;

                    continue;
                }

                vis[rvtx] = color;
                for (int v : graph[rvtx]) {
                    if (vis[v] == -1) {
                        que.addLast(v);
                    }
                }
            }

            color = (color + 1) % 2;
        }

        return true;
    }

    
    public boolean isBipartite(int[][] graph) {
                    
        int N = graph.length;
        int[] vis = new int[N];
        Arrays.fill(vis, -1);

        for (int i = 0; i < N; i++) {
            if (vis[i] == -1 && !isBipartite(graph, i, vis))
                return false;
        }

        return true;
           
    }

    public static int spreadInfection(int src,int timeLimit)
    {
        LinkedList<Integer> que =new LinkedList<>();
        boolean[] vis=new boolean[N];
        int time=0;
        int infected=1;

        que.addLast(src);
        vis[src]=true;
        while(que.size()!=0)
        {
            int size=que.size();
            while(size-->0)
            {
                int rvtx=que.removeFirst();
                for(Edge e:graph[rvtx])
                {
                    if(!vis[e.v])
                    {
                        que.addLast(e.v);
                        vis[e.v]=true;

                        if(time+1<timeLimit)// que mai hum insert 0sec pe kre h pr voh insert 1sec pe hoge so time+1
                        {
                            infected++;
                        }

                        else{
                            return infected;
                        }
                    }
                }
            }
            time++;
        }
        return infected;
    }

    public static void main(String[] args)
    {
        isBipartite(graph);

    }
}