import java.util.ArrayList;
import java.util.Arrays;
public class l002directedGraph{
    public static class Edge{
        int v=0;
        int w=0;

        Edge(int v,int w)
        {
            this.v=v;
            this.w=w;
        }
    }
    
    public static void addEdge(ArrayList<Edge>[] graph,int u,int v)
    {
        graph[u].add(new Edge(v,w));
    }

      // O(2E)
    public static void display(ArrayList<Edge>[] graph) {
        int N = graph.length;
        for (int i = 0; i < N; i++) {
            System.out.print(i + " -> ");
            for (Edge e : graph[i]) {
                System.out.print("(" + e.v + ", " + e.w + ") ");
            }
            System.out.println();
        }
    }

    public staic voif dfs_topo(ArrayList<Edge>[] graph,int src,boolean[] vis,ArrayList<Integer> st)
    {
        vis[src]=true;
        for(Edge e:graph[src])
        {
            if(!vis[e.v])
            {
                dfs_topo(graph,e.v,vis);
            }
        }

        ans.add(src);// complete backtrack krte time we will add the vertices to the arrayList
    }

    public static void TopologicalOrder(ArrayList<Edge>[] graph)
    {
        int N=graph.length;
        boolean[] vis=new boolean[N];
        ArrayList<Integer> st=new ArrayList<>();
        for(int i=0;i<N ;i++)
        {
            if(!vis[i])
            {
                dfs_topo(graph,i,vis,st);
            }
        }
    }

    public static void KahnsAlgo(ArrayList<Edge>[] graph)
    {
        int n=graph.length;
        LinkedList<Integer> que=new LinkedList<>();
        int[] indegree=new int[n];
        ArrayList<Integer>=new ArrayList<>();

        //O(E)
        for(int i=0;i<n;i++)
        {
            for(Edge e:graph[i])
            {
                indegree[e.v]++;
            }
        }

        //O(V)
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0)
            {
                que.addLast(i);
            }
        }
    //O(E+V)=O(N)
        while(que.size()!=0)
        {
            int rvtx=que.removeFirst();
            ans.add(rvtx);
            for(Edge e:graph[rvtx])
            {
                if(--indegree[e.v]==0)
                {
                    que.addLast(e.v);
                }
            }
        }

        if(ans.size()==n)
        {
            return ans;
        }

        else{
            ans.clear();
        }
    }
// 207 Leetcode
 public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph=new ArrayList[numCourses];
        
        for(int i=0;i<numCourses;i++){
            graph[i]=new ArrayList<>();
        }
        
        for(int[] a:prerequisites)
        {
            graph[a[0]].add(a[1]);
        }
        
        LinkedList<Integer> que=new LinkedList<>();
        int[] indegree =new int[numCourses];
        ArrayList<Integer> ans=new ArrayList<>();
        
        for(int i=0;i<numCourses;i++)
        {
            for(Integer e:graph[i])
            {
                indegree[e]++;
            }
        }
        
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                que.addLast(i);
            }
        }
        
        while(que.size()!=0)
        {
            int rvtx=que.removeFirst();
            ans.add(rvtx);
            
            for(Integer e:graph[rvtx])
            {
                if(--indegree[e]==0)
                {
                    que.addLast(e);
                }
            }
        }
        
        if(ans.size()!=numCourses)
        {
            return false;
        }
        else{
            return true;
        }
        
    }
    
//210 Leetcode
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        ArrayList<Integer>[] graph=new ArrayList[numCourses];
        
        for(int i=0;i<numCourses;i++){
            graph[i]=new ArrayList<>();
        }
        
        for(int[] a:prerequisites)
        {
            graph[a[1]].add(a[0]);
        }
        
        LinkedList<Integer> que=new LinkedList<>();
        int[] indegree =new int[numCourses];
        int[] ans=new int[numCourses];
        
        for(int i=0;i<numCourses;i++)
        {
            for(Integer e:graph[i])
            {
                indegree[e]++;
            }
        }
        
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                que.addLast(i);
            }
        }
        
        int idx=0;
        while(que.size()!=0)
        {
            int rvtx=que.removeFirst();      
                ans[idx++]=rvtx;
            
            for(Integer e:graph[rvtx])
            {
                if(--indegree[e]==0)
                {
                    que.addLast(e);
                }
            }
        }
        
        if(idx!=numCourses)
        {
            ans=new int[0];
        }
            return ans;       
    }

    public static boolean dfs_TopoIsCycle(ArrayList<Integer>[] graph,int src,int[] vis,ArrayList<Integer> ans)
    {
        vis[src]=0;
        boolean res=false;
        for(Edge e:graph[src])
        {
            if(vis[e.v]==-1)
            {
                res=res || dfs_TopoIsCycle(graph,e.v,vis);
            }

            if(vis[e.v]==0)
            {
                return true;
            }
        }

        vis[src]=1;
        ans.add(src);
        return res;
    }

    public static boolean Topo_IsCycle(ArrayList<Integer>[] graph)
    {
        int[] vis=new int[N];
        ArrayList<Integer> ans=new ArrayList<>();

        Arrays.fill(vis,-1);
        boolean cycle=false;
        for(int i=0;i<N;i++)
        {
            if(vis[i]==-1)
            {
                cycle=cycle || dfs_TopoIsCycle(graph);
            }
        }

        if(cycle)
        {
            ans.clear();
        }
        return ans;
    }

    public static void constructGraph() {
        int N = 7;
        ArrayList<Edge>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++)
            graph[i] = new ArrayList<>();

        addEdge(graph, 0, 1, 10);
        addEdge(graph, 1, 2, 10);
        addEdge(graph, 2, 3, 40);
        addEdge(graph, 3, 0, 10);
        addEdge(graph, 3, 4, 2);
        addEdge(graph, 4, 5, 2);
        addEdge(graph, 5, 6, 3);
        addEdge(graph, 6, 4, 8);

        display(graph);
    }

    public static void main(String[] args) {
        constructGraph();
    }
}