public class l001{

    public static class TreeNode{
        int val=0;
        TreeNode left=null;
        TreeNode right=null;

        TreeNode(int val)
        {
            this.val=val;
        }
    }

    public static int size(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }

        return size(root.left)+size(root.right)+1;
    }

    public static int height(TreeNode root)
    {
        if(root==null)
        {
            return -1;
        }

        return Math.max(height(root.left),height(root.right)+1);
    }

    public static boolean find(TreeNode root,int data)
    {
        if(root==null)
        {
            return false;
        }

        boolean sol=root.val==data;

        sol=sol||find(root.left,data)||find(root.right,data);

        return sol;
    }

    public static int maximum(TreeNode root )
    {
        if(root==null)
        {
            return -(int)1e9;
        }

        int lmax=maximum(root.left);
        int rmax=maximum(root.right);

        return Math.max(Math.max(lmax,rmax),root.val);
    }

    public static int minimum(TreeNode root)
    {
        if(root==null)
        {
            return (int)1e9;
        }

        int lm=minimum(root.left);
        int rm=minimum(root.right);
        return Math.min(Math.min(lmin,rmin),root.val);
    }

    public static ArrayList<Integer> NodeToRootPath(TreeNode root,int data)
    {
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null)
        {
            return new ArrayList<>();
        }

        if(root.val==data)
        {
            ArrayList<Integer> base=new ArrayList<>();
            base.add(root.val);
            return base;
        }

        ArrayList<Integer> left=NodeToRootPath(root.left,data);
        if(left.size()!=0)
        {
            left.add(root.val);
            return left;
        }

        ArrayList<Integer> right=NodeToRootPath(root.right,data);
        if(right.size()!=0)
        {
            right.add(root.val);
            return right;
        }

        return right;
    }

    public static boolean NodeToRootPath(TreeNode root,int data,ArrayList<Integer>)
    {
        if(root==null)
        {
            return false;
        }
       if(root.val==data)
       {
           ans.add(root.val);
           return true;
       }
       boolean res=NodeToRootPath(root.left,data,ans)||NodeToRootPath(root.right,data,ans);
       if(res)
       {
           ans.add(root);
       }
       return res;
    }

    public static void rootToLeafPath(TreeNode root,ArrayList<Integer> smallAns,ArrayList<ArrayList<Integer>> ans)
  {
      if(root==null)
      {
          return;
      }
      
      if(root.left==null && root.right==null)
      {
          ArrayList<Integer> base=new ArrayList<>(smallAns);
          base.add(root.val);
          ans.add(base);
          return;
      }
      
      smallAns.add(root.val);
      
      rootToLeafPath(root.left,smallAns,ans);
      rootToLeafPath(root.right,smallAns,ans);
      
      smallAns.remove(smallAns.size()-1);
  }

  public static ArrayList<ArrayList<Integer>> rootToAllLeafPath(TreeNode root) {
    // write your code.
    ArrayList<Integer> smallAns=new ArrayList<>();
    ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
    rootToLeafPath(root,smallAns,ans);
    return ans;  
  }

  public static void singleChildNodes(Node node,ArrayList<Integer> ans)
  {
      if(node==null ||(node.left==null && node.right==null))
      {
          return;
      }

      if(node.left==null || node.right==null)
      {
           ans.add(node.val);
      }

      singleChildNodes(node.left,ans);
      singleChildNodes(node.right,ans);
  }

public static int count=0;
  public static int countSingleChildNode(Node node)
  {
       if(node==null || (node.left==null && node.right==null))
      {
          return 0;
      }

      if(node.left==null || node.right==null)
      {
          count++;
      }

      countSingleChildNode(node.left);
      countSingleChildNode(node.right);

      return count;

  }

  public static int countSingleChildNode(Node node)
  {

      if(node==null || (node.left==null && node.right==null))
      {
          return 0;
      }
      int leftNodes=countSingleChildNode(node.left);
      int rightNodes=countSingleChildNode(node.right);

      int ans=leftNodes+rightNodes;

      if(node.left==null || node.right==null)
      {
         ans++;
      }

      return ans;
  }

  public static void kLevelDown(Node node,int k,ArrayList<Integer> ans)
  {
      if(node==null)
      {
          return;
      }

      if(k<=0){
          if(k==0)
          {
              ans.add(node.val);
              return;
          }

          else{
              return;
          }
      }

      kLevelDown(node.left,k-1,ans);
      kLevelDown(node.right,k-1,ans);
  }

    public static void kLevelDown(Node node,Node blockNode,int k,ArrayList<Integer> ans)
  {
      if(node==null || node==blockNode)
      {
          return;
      }

      if(k<=0){
          if(k==0)
          {
              ans.add(node.val);
              return;
          }

          else{
              return;
          }
      }

      kLevelDown(node.left,blockNode,k,ans);
      kLevelDown(node.right,blockNode,k,ans);
  }

  public static ArrayList<Integer> kdistance(Node node ,int k,int data)
  {
      ArrayList<Integer> ans=new ArrayList<>();
      ArrayList<Integer> path=new ArrayList<>();
      NodeToRootPath(node,data,path);
      Noe blockNode=null;
      for(int i=0;i<path.size();i++)
      {
          kLevelDown(node,blockNode,k-i,ans);
          blockNode=path.get(i-1);
      }
      return ans;
  }

  public static int kdistance_01(Node node,int data,int k)
  {
      ArrayList<Integer> ans=new ArrayList<>();
      if(root==null)
      {
          return -1;
      }

      if(node.data==data)
      {
          kLevelDown(node,null,k,ans);
          return 1;
      }

      int ld=kdistance_01(node.left,data,k);
          if(ld!=-1)
          {
              kLevelDown(node,node.left,k-ld,ans);
              return ld+1;
          }
      

      int rd=kdistance_01(node,data,k);
      if(rd!=-1)
      {
          kLevelDown(node,node.right,k-rd,ans);
          return rd+1;
      }

      return -1;
  }

  public static void kLevel(TreeNode root,int time,TreeNode blockNode,ArrayList<ArrayList<Integer>> ans)
  {
      if(root==null || root==blockNode)
      {
          return;
      }

      if(time==ans.size())
      {
          ans.add(new ArrayList<>());
      }

      ans.get(time).add(root.val);
      kLevel(root.left,time+1,blockNode,ans);
      kLevel(root.right,time+1,blockNode,ans);
  }

  public static int burningTree(TreeNode root,int target,ArrayList<ArrayList<Integer>> ans)
  {
    if(root==null)
    {
        return -1;
    }

    if(root.data==target)
    {
        kLevel(root,time,null,ans);
        return 1;
    }

    int ld=burningTree(root.left,target,ans);
    if(ld!=-1)
    {
        kLevel(root,ld,root.left,ans);
        return ld+1;
    }

    int rd=burningTree(root.right,target,ans);
    if(rd!=-1)
    {
        kLevel(root,rd,root.right,ans);
        return rd+1;
    }

    return -1;
  }

  public static void burningTree(TreeNode root,int target)
  {
      ArrayList<ArrayList<Integer>>=new ArrayList<>();
      burningTree(root,target,ans);
  }

  //Burning Tree with Water

  public static void kLevelDown_Water(TreeNode root,int time,TreeNode blockNode,ArrayList<ArrayList<Integer>> ans,HashSet<Integer> water)
  {
      if(root==null || root==blockNode || water.contains(root.val))
      {
          return;
      }

      if(ans.size()==time)
      {
          ans.add(new ArrayList<Integer>());
      }
      ans.get(i).add(root.val);

      kLevelDown_Water(root.left,time+1,blockNode,ans);
      kLevelDown_Water(root.right,time+1,blockNode,ans);
  } 

   // -1 : did we gett the target node, -2 : fire will not reach that node, 
   //t > 0 :fire will reach with time t.
  public static burningTree_withWater(TreeNode root,int target)
  {

      ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
      if(root==null)
      {
          return -1;//to check if data mila ki nhi
      }

      if(root.val==target)
      {
          if(!water.contains(root.val))
          {
            kLevelDown_Water(root,0,null,ans);
            return 1;//data is found and has water
          }
          else{ 
            return -2;//data is found but has water 
          }

           int ld = burningTreeWithWater(root.left, target, ans, water);
        if (ld > 0) {
            if (!water.contains(root.val)) {
                kdown(root, ld, root.left, ans);
                return ld + 1;
            }
            return -2;
        }
        if (ld == -2)
            return -2;

        int rd = burningTreeWithWater(root.right, target, ans, water);
        if (rd > 0) {
            if (!water.contains(root.val)) {
                kdown(root, rd, root.right, ans);
                return rd + 1;
            }
            return -2;
        }
        if (rd == -2)
            return -2;

        return -1; 
      }

public static TreeNode lca=null;
public static boolean lowestCommonAncestor(TreeNode root,int p,int q){
    if(root==null)
    {
        return false;
    }

    boolean self=false;
    if(root.val==p || root.val==q)
    {
        self=true;
    }

    boolean left=lowestCommonAncestor(root.left,p,q);
     boolean right=lowestCommonAncestor(root.right,p,q);

    if((self && left) || (self && right) || (left && right))
    {
        lca=root;
    }

    return left || right || self;
}
                          // OR 

public static boolean lowestCommonAncestor_(TreeNode root,int p,int q,TreeNode lca){//using lca as an argument
    if(root==null)
    {
        return false;
    }

    boolean self=false;
    if(root.val==p || root.val==q)
    {
        self=true;
    }

    boolean left=lowestCommonAncestor_(root.left,p,q,lca);
     boolean right=lowestCommonAncestor_(root.right,p,q,lca);

    if((self && left) || (self && right) || (left && right))
    {
        lca.left=root;//lca ke andr jaake changes krege bcoz otherwise voh recursion ke hr step mai reflect nhi hoge
    }

    return left || right || self;
}

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca=new TreeNode();//creating a treenode using new
        lowestCommonAncestor_(root,p.val,q.val,lca);
        return lca.left;
    }

//LEVEL ORDER TRAVERSAL OF A BINARY TREE
public static void levelOrder(TreeNode root){
    LinkedList<TreeNode> que=new LinkedList<>();

    ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
    que.addLast(root);
    int level=0;
    while(que.size()!=0){

        int size=que.size();
        ArrayList<Integer> smallAns=new ArrayList<>();
        while(size-->0){
            TreeNode rNode=que.removeFirst();
            smallAns.add(rNode.val);

            if(rNode.left !=null){
                que.addLast(rNode.left);
            }

            if(rNode.right!=null){
                que.addLast(rNode.right);
            }
        }

        ans.add(smallAns);
        level++;
    }

    for(var list:ans){
        System.out.println(count++ +"->" + list);
    }
}

//VIEW CATEGORY

//O(N)
public static List<Integer> leftView(TreeNode root){
    LinkedList<TreeNode> que=new LinkedList<>();
    que.addLast(root.val);

    List<Integer> ans=new ArrayList<>();
    while(que.size()!=0){
        ans.add(que.getFirst().val);
        int size=que.size();
        while(size-->0){

            TreeNode rNode=que.removeFirst();

            if(rNode.left!=null)
            {
                que.addLast(rNode.left);
            }

            if(rNode.right!=null)
            {
                que.addLast(rNode.right);
            }
        }
    }
    return ans;
}

//O(N)
public static List<Integer> rightView(TreeNode root){
    LinkedList<TreeNode> que=new LinkedList<>();
    que.addLast(root.val);

    List<Integer> ans=new ArrayList<>();
    while(que.size()!=0){
        ans.add(que.getFirst().val);
        int size=que.size();
        while(size-->0){

            TreeNode rNode=que.removeFirst();

             if(rNode.right!=null)
            {
                que.addLast(rNode.right);
            }

            if(rNode.left!=null)
            {
                que.addLast(rNode.left);
            }
        }
    }
    return ans;
}

public static void widthOfShadow(TreeNode root,int vLevel,int[] minMax){
    if(root==null)
    {
        return;
    }

    minMax[0]=Math.min(minMax[0],vLevel);
    minMax[1]=Math.max(minMax[1],vLevel);

    widthOfShadow(root.left,vLevel-1,minMax);
    widthOfShadow(root.right,vLevel+1,minMax);
}

public static class vPair{
    TreeNode node=null;
    int vl=0;

    vPair(TreeNode node,int vl){
        this.node=node;
        this.vl=vl;
    }
}

public static ArrayList<ArrayList<TreeNode>> verticalOrder(TreeNode root){
    int[] minMax=new int[2];
    widthOfShadow(root,0,minMax);
    int len=minMax[1]-minMax[0]+1;

  
    LinkedList<vPair> que=new LinkedList<>();
    que.addLast(new vPair(root,Math.abs(minMax[0])));

    ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
    for(int i=0;i<len;i++)
    {
        ans.add(new ArrayList<>());
    }

    while(que.size()!=0)
    {
        int size=que.size();

        while(size-->0)
        {
            vPair rPair=que.removeFirst();
            TreeNode node=rPair.node;
            int vl=rPair.vl;

            ans.get(vl).add(node.val);
 
            if(node.left!=null)
            {
                que.addLast(new vPair(node.left,vl-1));
            }

            if(node.right!=null){
                que.addLast(new vPair(node.right,vl+1));
            }
            
        }
    }

    return ans;
}

public static ArrayList<Integer> bottomView(TreeNode root)
{
     int[] minMax=new int[2];
    widthOfShadow(root,0,minMax);
    int len=minMax[1]-minMax[0]+1;

  
    LinkedList<vPair> que=new LinkedList<>();
     ArrayList<Integer> ans=new ArrayList<>();
     for(int i=0;i<len;i++)
     {
         ans.add(null);
     }

     que.addLast(new vPair(root,Math.abs(minMax[0])));

     while(que.size()!=0)
     {
         int size=que.size();
         while(size-->0)
         {
             vPair rPair=que.removeFirst();
             TreeNode node=rPair.node;
             int vl=rPair.vl;

             ans.set(vl,node.val);

             if(node.left!=null){
                 que.addLast(new vPair(node.left,vl-1));
             }

              if(node.right!=null){
                 que.addLast(new vPair(node.right,vl+1));
             }
         }
     }
     return ans;
}

public static ArrayList<Integer> topView(TreeNode root)
{
    int[] minMax=new int[2];
    widthOfShadow(root,0,minMax);
    int len=minMax[1]-minMax[0]+1;
  
    LinkedList<Integer> que=new LinkedList<>();
     ArrayList<Integer> ans=new ArrayList<>();
     for(int i=0;i<len;i++)
     {
         ans.add(null);
     }

     que.addLast(new vPair(root,Math.abs(minMax[0])));

     while(que.size()!=0)
     {
         int size=que.size();
         while(size-->0)
         {
             vPair rPair=que.removeFirst();
             TreeNode node=rPair.node;
             int vl=rPair.vl;

             if(ans.get(vl)==null)
             {
                 ans.set(vl,node.val);
             }
    
             if(node.left!=null){
                 que.addLast(new vPair(node.left,vl-1));
             }

              if(node.right!=null){
                 que.addLast(new vPair(node.right,vl+1));
             }
         }
     }
     return ans;
}

public static void diagonalOrder(TreeNode root)
{
    ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
    LinkedList<TreeNode> que=new LinkedList<>();

    while(que.size()!=0)
    {
        int size=que.size();
        ArrayList<Integer> smallAns=new ArrayList<>();
        que.addLast(root.val);
        while(size-->0)//diagonal loop
        {
            TreeNode rNode=que.removeFirst();
            while(rNode!=null){//cluster of diagonals loop 
                smallAns.add(rNode);
                if(rNode.left!=null)
                {
                     que.addLast(rNode.left);
                }
                rNode=rNode.right;
            }
        }
        ans.add(smallAns);
    }
    return ans;
}

public static void antiDiagonal(TreeNode root){
    
    ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
    LinkedList<TreeNode> que=new LinkedList<>();
    que.addLast(root);

    while(que.size()!=0)
    {
        int size=que.size();
        ArrayList<Integer> smallAns =new ArrayList<>();
        while(size-->0)
        {
            TreeNode rNode=que.removeFirst();
            while(rNode!=null)
            {   
                smallAns.add(rNode.val);
            if(rNode.right!=null)
            {
                que.addLast(rNode.right);
            }
            rNode=rNode.left;
            }
        }
        ans.add(smallAns);
    }
}

public static ArrayList<Integer> verticalOrderSum(TreeNode root)
{
    int[] minMax=new int[2];
    widthOfShadow(root,0,minMax);
    int len=minMax[1]-minMax[0]+1;

    ArrayList<Integer> ans=new ArrayList<>();
    for(int i=0;i<len;i++)
    {
        ans.add(null);
    }

    LinkedList<vPair> que=new LinkedList<>();
    que.addLast(new vPair(root,Math.abs(minMax[0])));
    while(que.size()!=0)
    {
        int size=que.size();
        while(size-->0)
        {
            vPair rPair=que.removeFirst();
            TreeNode node=rPair.node;
            int vl=rPair.vl;

            ans.set(vl,ans.get(vl)+root.val);

            if(node.left!=null)
            {
                que.addLast(new vPair(node.left,vl-1));
            }
            
            if(node.right!=null)
            {
                que.addLast(new vPair(node.right,vl+1));
            }
        }
    }
    return ans;
}

public static ArrayList<Integer> diagonalOrderSum(TreeNode root)
{
      ArrayList<Integer> ans=new ArrayList<>();
      LinkedList<TreeNode> que=new LinkedList<>();
      que.addLast(root);

      
      while(que.size()!=0)
      {
          int sum=0;
          int size=que.size();
          while(size-->0)
          {
              TreeNode rNode=que.removeFirst();
              while(rNode!=null)
              {
                  sum=sum+rNode.val;
                  if(rNode.left!=null)
                  {
                      que.addLast(rNode.left);
                  }
                  rNode=rNode.right;
              }
          }
          ans.add(sum);
      }
      return ans;
}

  }
    public static void main(String[] args)
    {

    }
}
