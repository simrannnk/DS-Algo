public class unionFind{

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

static int[] par;//parent array
static int[] size;//size array
//int[][] edges-this is a edge list {{u1,v1,w1},{u2,v2,w2},{u3,v3,w3}.........}

public static int findPar(int u)
{

    if(par[u]==u)
    {
        return u;
    }
    return par[u]=findPar(par[u]);
}

public static void union(int p1,int p2)
{
    if(size[p1]>size[p2])
    {
        par[p2]=p1;
        size[p1]+=size[p2];
    }

    else {
        par[p1]=p2;
        size[p2]+=size[p1];
    }
}

public static void unionFind(int[][] edges){

        int N=7;
        ArrayList<Edge>[] graph=new ArrayList[N];//only when graph implement krna hai 
        for(int i=0; i<graph.length; i++) {
            graph[i]=new ArrayList<>();
        }

        int N=edge.length;
        par=new int[N];
        size=new int[N];

        for(int i=0;i<N;i++)
        {
            par[i]=i;//sbka parent voh khud hai 
            size[i]=1;//sbka size 1 hai 
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

    public static void main(String[] args)
    {

    }
}