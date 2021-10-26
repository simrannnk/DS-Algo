import java.util.ArrayList;
public class algo{

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

int[] par;
int[] size;

public static int fidPar(int u)
{
    if(par[u]==u)
    {
        return u;
    }

    return par[u]=findPar(par[u]);
}

public static void union(int p1, int p2)
{
    if(size[p1]<=size[p2])
    {
        par[p1]=p2;
        size[p2]+=size[p1];
    }

    else{
        par[p2]=p1;
        size[p1]=p2;
    }
}


public static void unionFind(int[][] Edge,ArrayList<Edge>[] graph)
{
    int n=Edge.length;
    par=new int[n];
    size=new int[n];

    for(int i=0;i<n;i++)
    {
        par[i]=i;
        size[i]=1;
    }

       for(int[] e:edges)
        {
            int u=e[0];
            int v=e[1];
            int w=e[3];

            int p1=findPar(u);
            int p2=findPar(v);

            if(p1!=p2)
            {
                union(p1,p2);//if global leaders are diff make them the part of same set i.e union call krdo
                addEdge(graph,u,v,w);// only if graph bnana ho then construct ans edge tbi jb parent diff hai 
            }
        }
}

public static void kruskalAlgo(int[][] edges)
{
    Arrays.sort(edges,(a,b)->{
        return a[2]-b[2];
    });

    ArrayList<Edge>[] graph=new ArrayList<>();
    for(int i=0;i<edges.length;i++)
    {
        graph[i]=new ArrayList<>();
    }

    unionFind(edges,graph);

}
