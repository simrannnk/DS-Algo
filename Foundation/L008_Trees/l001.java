public class l001 {
    public static class Node
    {
        int data=0;
        Node left=null;
        Node right=null;

        Node(int data)
        {
            this.data=data;
        }
    }

// Traversals Of Tree
public static void preOrderTraversal(Node root,ArrayList<Integer> ans)
{
    if(root==null)
    {
        return;
    }
    ans.add(root.data);
    preOrderTraversal(root.left,ans);
    preOrderTraversal(root.right,ans);

}

public static void inOrderTraversal(Node root,ArrayList<Integer> ans)
{
    if(root==null)
    {
        return;
    }
    inOrderTraveral(root.left,ans);
    ans.add(root.data);
    inOrderTraversal(root.right,ans);
}

public static void postOrderTraversal(Node root,ArrayList<Integer> ans)
{
    if(root==null)
    {
        return;
    }
    postOrderTraversal(root.left,ans);
    postOrderTraversal(root.right,ans);
    ans.add(root.data);
}

public static void traversal(Node root)
{
    ArrayList<Integer> ans=new ArrayList<>();
    preOrderTraversal(Node root,ans);
    inOrderTraversal(Node root,ans);
    postOrderTraversal(Node root,ans);
}

//Basic Tree Functions

public static int size(Node root)
{
    if(root==null)
    {
        return 0;
    }
    return size(root.left)+size(root.right)+1;
}

//By Default in terms of edge
public static int height(Node root)
{
    if(root==null)
    {
        return -1;
    }
    int lh=height(root.left);
    int rh=height(root.right);
    return Math.max(lh,rh)+1;
}

public static int heightTermsOfNode(Node root)
{
    if(root==null)
    {
        return 0;
    }
    int lh=heightTermsOfNode(root.left);
    int rh=heightTermsOfNode(root.right);
    return Math.max(lh+rh)+1;
}

public static int maximum(Node root)
{
    if(root==null)
    {
        return -(int)1e8;
    }
    int lm =maximum(root.left);
    int rm = maximum(root.right);
    return Math.max(Math.max(lm,rm),root.data);
}

public static int minimum(Node root)
{
    if(root==null)
    {
        return (int)1e8;
    }
    int lm =minimum(root.left);
    int rm=minimum(root.right);
    return Math.min(Math.min(lm,rm),root.data);
}

public static int sum(Node root)
{
    if(root==null){
        return 0;
    }

    int ls=sum(root.left);
    int rs=sum(root.right);
    return ls+rs+root.data;
}

public static boolean findData(Node root,int data)
{
    if(root==null)
    {
        return false;
    }

    boolean res=root.data==data;
    return res||findData(root.left,data)||findData(root.right,data);
}

public static boolean NodeToRootPath(Node root,int data,ArrayList<Node> ans)
{
    if(root==null)
    {
        return false;
    }
    boolean sol=root.data==data||NodeToRootPath(root.left,data,ans)||NodeToRootPath(root.right,data,ans);
    if(sol)
    {
        ans.add(root);
    }
    return sol;
}

public static void printKLevelDown(Node root,int k,ArrayList<Integer> ans)
{
    if(root==null || k<0)
    {
        return;
    }

    if(k==0)
    {
        ans.add(root.data);
        return;
    }
    printKLevelDown(root.left,data,k-1,ans);
    printKLevelDown(root.right,data,k-1,ans);
}

public static void printKLevelDown_(Node root,Node block,int k,ArrayList<Integer> ans)
{
    if(root==null || k<0 || root==block)
    {
        return;
    }

    if(k==0)
    {
        ans.add(root.data);
        return;
    }
    printKLevelDown_(root.left,block,k-1,ans);
    printKLevelDown_(root.right,block,k-1,ans);
}

public static ArrayList<Integer> distanceK(Node root,Node target,int k) 
{
    ArrayList<Integer> path=new ArrayList<>();
    NodeToRootPath(root,target.data,path);
    Node block=null;
    ArrayList<Integer> ans=new ArrayList<>();
    for(int i=0;i<path.size();i++){
        printKLevelDown_(path.get(i),block,k-i,ans);
        block=path.get(i); 
    }
    return ans;

}

public static void singleChildNodes(Node node,Node parent){
    if(node==null){
        return;
    }
    if(parent!=null&&(parent.left==null||parent.right==null))
    {
            System.out.println(node.data)
    }
    singleChildNodes(node.left,node);
    singleChildNodes(node.right,node);
}

public static Node removeLeaves(Node node){
    if(node==null){
        return null;
    }

    if(node.left==null && node.right==null){
        return null;
    }
    node.left=removeLeaves(node.left);
    node.right=removeLeaves(node.right);
    return node;
}

public static void removeLeaves2(Node node,Node parent){
    if(node==null){
        return;
    }

    if(node.left==null&&node.right==null){
        if(parent.left==node){
            parent.left=null;
        }
        else{
            parent.right=null;
        }
        return;
    }
}

//If root is the leaf node
public static Node removeLeaves_(Node node)
{
    if(node.left==null && node.right==null){
        return null;
    }

    removeLeaves2(node,null);
    return node;
}

public static Node prev=null;
public static boolean isBST(Node node){
    if(node==null){
        return true;
    }
    boolean leftBST=isBST(node.left);
    if(!leftBST){
        return false;
    }
    if(prev!=null&&prev.data>node.data){
        return false;
    }
    prev=node;
    boolean rightBST(node.right);
    if(!rigthBST){
        return false;
    }

    return true;
}

public class isBSTSolPair{
    int maxEle=-(int)1e8;
    int minEle=(int)1e8;
    booelan isBST=true;


isBSTSolPair()//Default constructor
{

}

isBSTSolPair(int maxEle,int minEle,boolean isBST)//Parameterized constructor
{
    this.maxEle=maxEle;
    this.minEle=minEle;
    this.isBST=isBST;
}
}

public static isBSTSolPair isBST_(Node root)
{
    if(root==null)
    {
        isBSTSolPair baseRes=new isBSTSolPair();
        baseRes.isBST=true;
        return baseRes;
    }

    isBSTSolPair left=isBST_(root.left);
    isBSTSolPair right=isBST_(root.right);

    isBSTSolPair myRes=new isBSTSolPair();
    myRes.isBST=false;
    if(left.isBST && right.isBST && left.maxEle<root.data && right.minEle>root.data)
    {
        myRes.isBST=true;
        myRes.maxEle=Math.max(root.data,right.maxEle);
        myRes.minEle=Math.min(root.data,left.minEle);
    }

    return myRes;
}

public class isBalSolPair{
    boolean isBal=true;
    height=-1;
}

public static isBalSolPair isBalanced(Node node)
{
    if(node==null)
    {
        isBalSolPair base=new isBalSolPair();
            return base;
    }

    isBalSolPair left=isBalanced(node.left);
    if(!left.isBal)
    {
        return left;
    }
     
    isBalSolPair right=isBalanced(node.left);
    if(!right.isBal)
    {
        return right;
    }

    isBalSolPair myAns=new isBalSolPair();
    myAns.isBal=false;
     
    if(left.isBal && right.isBal && Math.abs(left.height-right.height)<=1)
        {
            myAns.isBal=true;
            myAns.height=Math.max(left.height,right.height)+1;
        }
        return myAns;
}
 
public static boolean isBalanced(Node root)
    {
	// Your code here
	isBalPair res=isBal(root);
	return res.isBalance;
    }

//leetcode -  236
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        ArrayList<TreeNode> path1=new ArrayList<>();
         ArrayList<TreeNode> path2=new ArrayList<>();
        NodeToRootPath(root,p.val,path1);
        NodeToRootPath(root,q.val,path2);
        
        int i=path1.size()-1;
        int j=path2.size()-1;
        
        TreeNode lca=null;
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

public static void main(String[] args)
{
}