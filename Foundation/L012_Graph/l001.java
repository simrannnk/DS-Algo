import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;

public class l001{

    public static class Edge{
        int v=0;
        int w=0;

        Edge(int v, int w)
        {
            this.v=v;
            this.w=w;
        }
    }

    public static int N=7;
    public static ArrayList<Edge>[] graph=new ArrayList[N];

    public static void addEdge(ArrayList<Edge>[] graph,int u,int v,int w)
    {
        graph[u].add(new Edge(v,w));
        graph[v].add(new Edge(u,w));
    }

    public static void display(ArrayList<Edge>[] graph)
    {
        int N=graph.length;
            for(int i=0;i<N;i++)
            {
                System.out.print(i +"->");
                for(Edge e:graph[i])
                {
                    System.out.print("(" + e.v +"," + e.w +")");
                }

                System.out.println();
            }
    }

    public static int findEdge(ArrayList<Edge>[] graph, int u,int v)
    {
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


    public static void removeEdge(ArrayList<Edge>[] graph, int u,int v)
    {
        int idx1=findEdge(graph,u,v);
        graph[u].remove(idx1);
        
        int idx2=findEdge(graph,v,u);
        graph[v].remove(idx2);
    }

    public static void removeVtx(ArrayList<Edge>[] graph, int u)
    {
        ArrayList<Edge> list=graph[u];
        while(list.size()!=0)
        {
            int N=list.size();
            Edge e=list.get(N-1);
            removeEdge(graph,u,e.v);
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest,boolean[] vis)
    {
        if(src==dest)
        {
            return true;
        }

        vis[src]=true;
        boolean res=false;
        for(Edge e:graph[src])
        {
            if(!vis[e.v])
            {
               res=res||hasPath(graph,e.v,dest,vis);
            }
        }
        return res;
    }

    public static int printallPaths(ArrayList<Edge>[] graph, int src, int dest,boolean[] vis,String ans){
        if(src==dest)
        {
            System.out.println(ans+dest);
            return 1;
        }

        vis[src]=true;
        int count=0;
        for(Edge e:graph[src])
        {
            if(!vis[e.v])
            {
                count+=printallPaths(graph,e.v,dest,vis,ans+src);
            }
        }

        vis[src]=false;
        return count;
    }

    public static void printPreOrder(ArrayList<Edge>[] graph,int src,boolean[] vis,String ans,int wsf)
    {
        System.out.println(src+"->"+ans+src+"@"+wsf);

        vis[src]=true;
        for(Edge e:graph[src])
        {
            if(!vis[e.v])
            {
                printPreOrder(graph,e.v,vis,ans+src,wsf+e.w);
            }
        }

        vis[src]=false;
    }


    public static void printPostOrder(ArrayList<Edge>[] graph,int src,boolean[] vis,String ans,int wsf)
    {
        
        vis[src]=true;
        for(Edge e:graph[src])
        {
            if(!vis[e.v])
            {
                printPostOrder(graph,e.v,vis,ans+src,wsf+e.w);
            }
        }

        System.out.println(src+"->"+ans+src+"@"+wsf);
        vis[src]=false;
    }

    public static void dfs(int src,boolean[] vis)
    {
        vis[src]=true; //visited mark kra
        for(Edge e:graph[src]) //get neighbours of your src
        {
            if(!vis[e.v])
            {
                dfs(e.v,vis);//calling dfs for unvisited neighbours only
            }
        }
    }

    public static void gcc(int src)
    {
        boolean[] vis=new boolean[N];
        int components=0;
        vis[src]=true;
        for(int i=0;i<N;i++)//graph ek sbhi vertices pr traverse kra
        {
            if(!vis[i])
            {
                components++;//incremeting the no of components at every' dfs' call
                dfs(i,vis);//calling dfs for all unvisited vertices of graph
            }
        }
    }

      public static boolean isGraphConnected() // if components=1 then connected otherwise not 
    {
        boolean[] vis=new boolean[N];
        int components=0;
        for(int i=0;i<N;i++)//graph ek sbhi vertices pr traverse kra
        {
            if(!vis[i])
            {
                components++;//incremeting the no of components at every' dfs' call
                dfs(i,vis);//calling dfs for all unvisited vertices of graph
            }
        }

        return components==1;

    }

    public static void dfs_island(int[][] mat,int i,int j,int[][] dir)
    {
        mat[i][j]=0; //pehle visited mark kra
        for(int d=0;d<dir.length;d++)//Finding neighbours
        {
            int r=i+dir[d][0];
            int c=j+dir[d][1];

            if(r>=0 && c>=0 && r<mat.length && c<mat[0].length && mat[i][j]==1)
            {
                dfs_island(mat,r,c,dir);//calling dfs for unvisited neighbours only
            }
        }
    }

    public static int numberOfIsland(int[][] mat)
    {
        int count=0;
        int[][] dir={
            {1,0},{-1,0},{0,-1},{0,1}
        };
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]==1)
                {
                    count++;//incrementing count at every 'dfs_island' call
                    dfs_island(mat,i,j,dir);
                }            
            }
        }

        return count;
    }

     
    public static void hamiltonian_dfs(int src, int osrc, boolean[] vis, int NoOfEdges, String psf) {
        if (NoOfEdges == N - 1) {
            System.out.print(psf + src);
            int idx = findEdge(graph,src, osrc);
            if (idx != -1)
                System.out.print("*");

            System.out.println();
            return;
        }

        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v])
                hamiltonian_dfs(e.v, osrc, vis, NoOfEdges + 1, psf + src);
        }

        vis[src] = false;
    }

    public static void hamiltonianPath() {
        boolean[] vis = new boolean[N];
        hamiltonian_dfs(0, 0, vis, 0, "");
    }

    //Journey To Moon -https://www.hackerrank.com/challenges/journey-to-the-moon/problem
    public static int moon_dfs(ArrayList<Integer>[] graph,int src,boolean[] vis)
    {
        int size=0;
        vis[src]=true;
        for(Integer e:graph[src])
        {
            if(!vis[e])
            {
                size+=moon_dfs(graph,e,vis);
            }
        }

        return size+1;
    }

    public static long journeyToMoon(int n,int[][] astronaut)
    {
        ArrayList<Integer>[] graph=new ArrayList[n];
        boolean[] vis=new boolean[n];

        for(int i=0;i<n;i++)
        {
            graph[i]=new ArrayList<>();
        }

        for(int[] a :astronaut)
        {
            graph[a[0]].add(a[1]);
            graph[a[1]].add(a[0]);
        }

         ArrayList<Integer> sizeArray=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                sizeArray.add(moon_dfs(graph,i,vis));
            }
        }

        long res=0;
        long ssf=0;//Sum so far
        for(int ele:sizeArray)
        {
            res+=ele*ssf;
            ssf+=ssf+ele;
        }

        return res;
    }

// if we need to perform work releated to cycle then use this bfs
    public static void bfs(int src,boolean[] vis)
    {
        LinkedList<Integer> que=new LinkedList<>();
        int level=0;// level denotes the no of edges required to reach that vertex
        int cycleCount=0;

        que.addLast(src);//insert the source to the queue
        while(que.size()!=0)
        {
            int size=que.size();
            System.out.print(level+"->");

            while(size-->0)
            {
                int rvtx=que.removeFirst();//until size of queue is 0 remove elements
               
                if(vis[rvtx])// agr visited vertex repeat hora h it means there is a cycle
                {
                    cycleCount++;
                    continue;
                }
                 System.out.print(rvtx+"");

                vis[rvtx]=true;//remove krne ke baad mark krege 
                for(Edge e:graph[rvtx])
                {
                    if(!vis[e.v])
                    {
                        que.addLast(e.v);// add all the neighbours pf the vertex that you are removing
                    }
                }
            }

            level++;
            System.out.println(); 
        }

    }

// always use this bfs agr cycle se related work ni h as in this bfs vertex repeat ni hore 

public static void bfs_02(int src, boolean[] vis)
{
    LinkedList<Integer> que=new LinkedList<>();
        int level=0;
        

        que.addLast(src);//insert the source to the queue
        vis[src]=true;// jaise hi insert kra in the queue mark it true
        
        while(que.size()!=0)
        {
            int size=que.size();
            System.out.print(level+"->");

            while(size-->0)
            {
                int rvtx=que.removeFirst();//until size of queue is 0 remove elements
               
                 System.out.print(rvtx+"");

                for(Edge e:graph[rvtx])
                {
                    if(!vis[e.v])
                    {
                        que.addLast(e.v);// add all the neighbours pf the vertex that you are removing
                        vis[e.v]=true;//insert krte time hi mark krege 
                    }
                }
            }

            level++;
            System.out.println(); 
        }
}

public static boolean isTree()
{
    //No cycle and gcc=1;
    return true;
}

public static boolean isForest()
{
    //No cycle and gcc more than 1
    return true;
}

public static boolean isBipartite(int src)
{
    LinkedList<Integer> que=new LinkedList<>();
    int[] vis=new int[N];
    Arrays.fill(vis,-1);

    int color=0;

    que.addLast(src);
    while(que.size()!=0)
    {
        int size=que.size();
        while(size-->0)
        {
            int rvtx=que.removeFirst();

            if(vis[rvtx]!=-1)
            {
                if(vis[rvtx]!=color)
                {
                    return false;
                }

                continue;
            }

            for(Edge e:graph[rvtx])
            {
                if(vis[e.v]==-1)
                {
                    que.addLast(e.v);
                }
            }
        }

        color=(color+1)%2;
    }

    return true;
}

  
public static void constructGraph()
    {
        // int N=7;
        // ArrayList<Edge>[] graph=new ArrayList[N];

        for(int i=0;i<N;i++)
        {
            graph[i]=new ArrayList<>();
        }

        addEdge(graph, 0, 1, 10);
        addEdge(graph, 0, 3, 40);
        addEdge(graph, 1, 2, 10); 
        addEdge(graph, 2, 3, 10);
        addEdge(graph, 3, 4, 2);
        addEdge(graph, 4, 5, 3);
        addEdge(graph, 4, 6, 8);
        addEdge(graph, 5, 6, 3);

       // display(graph);
        boolean[] vis=new boolean[N];
        //System.out.println(hasPath(graph,0,6,vis));
        //printPreOrder(graph,0,vis,"",0);
        //printPostOrder(graph,0,vis,"",0);
        //hamiltonianPath();
        bfs(0,vis);

    }
    public static void main(String[] args)
    {
        constructGraph();

    }
}