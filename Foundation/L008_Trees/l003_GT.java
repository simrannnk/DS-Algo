public class l003GT{
    public static class Node{
        int data=0;
        ArrayList<Node> childs=new ArrayList<>();

    Node(int data){
        this.data=data;
     }
    }

    public static int size(Node node){

        int sz=0;
        for(Node child:node.childs)
        {
            sz+=size(child);
        }

        return sz+1;
    }

    public static int height(Node node){

        int h=0;
        for(Node child:node.childs){
            h=Math.max(h,height(child));
        }
        return h+1;
    }

    public static int maximum(Node node){    
    int m=-(int)1e9;
    for(Node child:node.children){
        m=Math.max(m,maximum(child));
    }
    
    return Math.max(node.data,m);      
    }

    public static int minimum(Node node){
    int m=-(int)1e9;
    for(Node child:node.children){
        m=Math.min(m,minimum(child));
    }
    
    return Math.min(node.data,m);      
  
   public static boolean findData(Node node,int data)
   {
       boolean res=node.data==data;

       for(Node child:childs){
           res=res||findData(child,data);
       }

       return res;
   }

   public static boolean NodeToRootPath(Node node,int data,ArrayList<Node>list){
       boolean res=node.data==data;

       for(Node child:childs){
           res=res||findData(child,data);
       }

       if(res){
           list.add(node);
       }
       return res;
   }

   public static Node lowestCommonAncestor(Node node,Node p,Node q){
       ArrayList<Node> path1=new ArrayList<>();
       ArrayList<Node> path2=new ArrayList<>();

        NodeToRootPath(root,p.val,path1);
        NodeToRootPath(root,q.val,path2);

       int i=path1.size()-1;
       int j=path2.size()-1;

       Node lca=null;
       while(i>=0 && j>=0)
       {
           if(path1.get(i)!=path2.get(j))
           {
               break;
           }

           lca=path1.get(i);
           i--;
           j--;
       }
       return lca;
   }

   public static int minNodeDistance(Node node,Node p,Node q){
       ArrayList<Node> path1=new ArrayList<>();
       ArrayList<Node> path2=new ArrayList<>();

        NodeToRootPath(root,p.val,path1);
        NodeToRootPath(root,q.val,path2);

       int i=path1.size()-1;
       int j=path2.size()-1;

       Node lca=null;
       int lcaDistance=0;
       while(i>=0 && j>=0)
       {
           if(path1.get(i)!=path2.get(j))
           {
               break;
           }

           lca=path1.get(i);
           lcaDistance++;
           i--;
           j--;
       }
       return path1.size()+path2.size()-2*lcaDistance+1;//distance in terms of Nodes

       //return path1.size()+path2.size()-2*lcaDistance+1-1;//n terms of edges
   }

   public static void linearize(Node node){
       for(Node child:node.childs)
       {
           linearize(child);
       }

       for(int i=node.childs.size()-2;i>=0;i--)
       {
           Node tail=getTail(node.childs.get(i));
           tail.childs.add(node.childs.get(i+));

           node.childs.remove(i+1);
       }
   }

   public static Node getTail(Node node){
       Node curr=node;

       while(node.childs.size()!=0)
       {
           curr=curr.childs.get(0);
       }
       return curr;
   }
   
   public static void CeilAndFloor(Node node,int data){

       if(node.data>data){
           ceil=Math.min(ceil,node.data);
       }

       if(node.data<data){
           floor=Math.max(floor,node.data);
       }

       for(Node child:node.childs){
           CeilAndFloor(child,data);
       }
   }

   public static int kLargest(Node node,int bound)
   {
       int maxLessThanBound=-(int)1e9;
       for(Node child:node.childs){
           int recAns=kLargest(child,bound);
           maxLessThanBound=Math.max(maxLessThanBound,recAns);
       }

       if(node.data<bound)
       {
           maxLessThanBound=Math.max(node.data,maxLessThanBound);
       }

       return maxLessThanBound;
   }

   public static int KLargest(Node node,int k)
   {
       int bound=(int)1e9;
       while(k-->0)
       {
           bound= kLargest(node,bound);
       }
      
      return bound;
   }

   public static boolean areSimilar(Node n1,Node n2)
   {
       if(n1.children.size()!=n2.children.size())
       {
           return false;
       }

       for(int i=0;i<n1.childs.size();i++)
       {
           Node c1=n1.childs.get(i);
           Node c2=n2.childs.get(i);

           if(!areSimilar(c1,c2)){
               return false;
           }
       }
       return true;
   }

   public static boolean areMirror(Node n1,Node n2){
       if(n1.children.size()!n2.children.size())
       {
           return false;
       }

       int n=n1.children.size();
       for(int i=0,j=n-1;i<n;i++,j--)
       {
           Node c1=n1.children.get(i);
           Node c2=n2.children.get(j);

           if(!areMirror(c1,c2))
           {
               return false;
           }
       }

       return true;
   }

   public static boolean areMirror_Value(Node n1,Node n2){
         if(n1.children.size()!n2.children.size() || n1.data!=n2.data)
       {
           return false;
       }

       int n=n1.children.size();
       for(int i=0,j=n-1;i<n;i++,j--)
       {
           Node c1=n1.children.get(i);
           Node c2=n2.children.get(j);

           if(!areMirror(c1,c2))
           {
               return false;
           }
       }

       return true;
   }

   public static boolean isSymmetric_(Node n1,Node n2)
   {
       if(n1.children.size()!=n2.children.size())
       {
           return false;
       }
       int n=n1.children.size();
       for(int i=0,j=n-1;i<n;i++,j--)
       {
           Node c1=n1.children.get(i);
           Node c2=n2.children.get(j);

           if(!isSymmetric_(c1,c2))
           {
               return false;
           }
       }

       return true;
   }
public static isSymmetric(Node node)
{
    return isSymmetric_(node,node);
}

public static void removeLeaves(Node node)
{
    //Preorder work
    for(int i=node.children.size()-1;i>=0;i--)//start travering from the end otherwise there will be a shifting of indices
    {
        Node child=node.children.get(i);
        if(child.children.size()==0)
        {
            node.children.remove(child);
        }
    }

    for(Node child:node.children)
    {
        removeLeaves(child);
    }
}

    public static void main(String[] args){

    }
}