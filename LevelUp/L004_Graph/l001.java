import java.util.ArrayList;
public class l001{

    public static class Edge{
        int v=0;
        int w=0;

        Edge(int v,int w)
        {
            this.v=v;
            this.w=w;
        }
    }

    public static void addEdge(ArrayList<Edge>[] graph , int u, int v, int w)
    {
        graph[u].add(new Edge(v,w));
        graph[v].add(new Edge(u,w));
    }

//O(2E)
    public static void display(ArrayList<Edge>[] graph){
        int N=graph.length;
        for(int i=0;i<N;i++)
        {
            System.out.print(i+"->");
            for(Edge e:graph[i]){
                System.out.print("("+e.v+","+e.w+")");
            }
             System.out.println();
        }
    }

    public static int findEdge(int u,int v){
        ArrayList<Edge> list=graph[u];
        for(int i=0;i<list.size();i++)
        {
            Edge e=list.get(i);
            if(e.v==v)
            {
                return i;
            }
        }

        return -1;
    }

    public static void removeEdge(int u,int v)
    {
        int idx1=findEdge(u,v);
        graph[u].remove(idx1);

        int idx2=findEdge(u,v);
        graph[v].remove(idx2);
    }

//Has Path
    public static boolean dfs_findPath(int src,int dest)
    {
        boolean[] vis=new boolean[N];
        vis[src]=true;

        boolean res=false;
        for(Edge e:graph[src])
        {
            if(!vis[e.v])
            {
                res=res||dfs_findPath(e.v,dest);
            }     
        }
        return res;
    }

    public static int printAllPath(int src,int dest,String pdf,int wsf)
    {

        if(src==dest)
        {
            System.oyt.println(psf+dest+"@"+wsf);
        }
        boolean[] vis=new boolean[N];

        vis[src]=true;
      
        int count=0;
        for(Edge e:graph[src])
        {
            if(!vis[e.v])
            {
               count+= printAllPath(e.v,dest,psf+src,wsf+e.w);

            }     
        }
        vis[src]=false;
        return count;
    }

    public static void dfs_gcc(int src,boolean[] vis){
        vis[src]=true;
        for(Edge e:graph[src])
        {
            if(!vis[e.v])
            {
                dfs_gcc(e.v,vis);
            }
        }

    }
//O(E+V)
    public static int getConnectedComponents()
    {
        boolean[] vis=new boolean[N];
        int components=0;
        for(int i=0;i<N;i++)
        {
            if(!vis[i])
            {
                components++;
                dfs_gcc(i,vis);
            }
        }

        return count;
    }
   
// BFS: used to detect cycle and find the shortest path to reach the given vertex
//No of elements inserted in the queue are = all the edges so-O(E)
   public static voif BFSforCycle(int src,boolean[] vis)
   {
       LinkedList<Integer> que=new LinkedList<>();
       int level=0;
       int cycle=0;
       que.addlast(src);
       while(que.size()!=0)
       {
           int size=que.size();
           System.out.print(level+ "->");

           while(size-->0)
           {
               int rvtx=que.removeFirst();

               System.out.print(rvtx+ ",");

               if(vis[rvtx])
               {
                   cycle++;
                   continue;
               }

               vis[rvtx]=true;
               for(Edge e:graph[rvtx])
               {
                   if(!vis[e.v])
                   {
                       que.addLast(e.v);
                   }
               }
           }
        System.out.println();
           level++;
       }
   }

//without cycle-O(E) where E=V-1 .... Thus O(E)=O(V)
// this is an optimized BFS as it does not travel those edges that form a cycle
   public static void BFS_Opti(int src,boolean[] vis)
   {
       int level=0;
       LinkedList<Integer> que=new LinkedList<>();

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
                   }
               }
           }
       }

       level++;
   }

   class Solution {
    public int[][] updateMatrix(int[][] mat) {
        LinkedList<Integer> que=new LinkedList<>();
       
          int n=mat.length;
        int m=mat[0].length;
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
         boolean[][] vis=new boolean[n][m];
        
      
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==0)//pehle saare 0 utha ke queue mai daal diye
                { 
                    int idx=i*m+j;
                    que.addLast(idx);
                      vis[i][j]=true;
                }
            }
        }
        
        
        while(que.size()!=0)
        {
            int size=que.size();
            while(size-->0)
            {
                int rvtxIDX=que.removeFirst();
                int sr=rvtxIDX/m;
                int sc=rvtxIDX%m;
                
                for(int d=0;d<dir.length;d++)
                {
                    int r=sr+dir[d][0];
                    int c=sc+dir[d][1];
                    
                    if(r>=0 && c>=0 && r<n && c<m && vis[r][c]==false)
                    {
                        que.addLast(r*m+c);
                        mat[r][c]=mat[sr][sc]+1;
                         vis[r][c]=true;
                        
                    }
                }
            }
        }
        return mat;
    }
}

   
     public void isBipartite(int[][] graph, int src, int[] vis) {
        // -1 -> undefine, 0 -> red, 1 -> green.

        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);
        int color = 0;
        boolean isBipartite=true;
        boolean isCycle=false;

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int rvtx = que.removeFirst();
                if (vis[rvtx] != -1) {

                    isCycle=true;

                    if (vis[rvtx] != color) // conflict
                        isBipartite=false;
                        break;

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

        if(isCycle){
            if(isBipartite){
                System.out.println("Is Bipartite with even length cycle");
            }

            else{
                 System.out.println("Is Non- Bipartite with odd length cycle")
            }
        }

        else{
             System.out.println("Is Bipartite")
        }
    }
   

    public static void constructGraph()
    {
        int N=7;
        ArrayList<Edge>[] graph=new ArrayList[N];
        for(int i=0; i<graph.length; i++) {
            graph[i]=new ArrayList<>();
        }

        addEdge(graph, 0, 1, 10);
        addEdge(graph, 1, 2, 10);
        addEdge(graph, 2, 3, 40); 
        addEdge(graph, 3, 0, 10);
        addEdge(graph, 3, 4, 2);
        addEdge(graph, 4, 5, 2);
        addEdge(graph, 5, 6, 3);
        addEdge(graph, 6, 4, 8);

        //display(graph);
        //System.out.println(findEdge(graph,1,9));

        boolean[] vis=new boolean[N];
        //System.out.println(dfs_findPath(graph,0,6,vis));
         System.out.println(printallPaths(graph,0,6,"",0,vis));
    }

    public static void main(String[] args)
    {
       constructGraph();
    }
}