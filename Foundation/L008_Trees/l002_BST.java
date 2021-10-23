public class l002BST{

    public class Node{
        Node left=null;
        Node right=null;
        int data=0;
    }

    Node(int data)
    {
        this.data=data;
    }

//Inorder tarversal of BST is sorted in increasing order.
    public static constructTree(int[] arr,int si,int ei)//Array must be sorted 
    {
        int mid=(si+ei)/2;
        Node root=new Node(arr[mid]);
        root.left=constructTree(arr,si,mid-1);
        root.right=constructTree(arr,mid+1,ei);

        return node;
    }

    public static Node constructTree(int[] arr) {
        return constructTree(arr, 0, arr.length - 1);
    }

    public static int size(Node node)
{
    if(node==null)
    {
        return 0;
    }
    return size(node.left)+size(node.right)+1;
}

    public static int height(Node node)
    {
        if(node==null)
        {
            return -1;
        }
        return Math.max(node.left,node.right)+1;
    }

    public static int maximum(Node node){
        if(node==null)
        {
            return -(int)1e9;
        }

        Node curr=node;
        while(curr.right!=null)
        {
            curr=curr.right;
        }

        return curr.data;
    }

    public static int maximumRec(Node node){
        if(node.right==null)
        {
            return node.data;
        }

        return maximumRec(node.right);
    }

    public static int minimum(Node node){
        if(node==null)
        {
            return (int)1e9;
        }
        Node curr = node;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr.data;
    }

    public static int minimumRec(Node node){
           if(node.left==null)
        {
            return node.data;
        }
        return minimumRec(node.left);
    }

    public static boolean findData(Node node,int data){
        Node curr=node;
        if(curr.data==data)
        {
            return true;
        }

        else if(data>curr.data){
            curr=curr.right;
        }

        else{
            curr=curr.left;
        }
        return false;
    }

    public static Node addData(Node node,int data){
        if(node==null){
            Node base =new Node(data);
        }

        if(data>node.data){
            node.right=addData(node.right,data);
        }

        else{
            node.left=addData(node.left,data);
        }

        return node;
    }

     public static Node addData_Itr(Node node, int data) {
        if (node == null)
            return new Node(data);

        Node curr = node;
        Node dNode = new Node(data);
        while (true) {
            if (curr.data == data)
                break;
            else if (curr.data < data) {
                if (curr.right != null)
                    curr = curr.right;
                else {
                    curr.right = dNode;
                    break;
                }
            } else {
                if (curr.left != null)
                    curr = curr.left;
                else {
                    curr.left = dNode;
                    break;
                }
            }
        }
        return node;
     }
//Lowest Common Ancestor Leetcode-235
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if( p.val>root.val && q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        
        else if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        
        else{
            return root;
        }    
    }

    public static void inOrder(Node node, ArrayList<Integer> list) {
        if (node == null)
            return;

        inOrder(node.left, list);
        list.add(node.data);
        inOrder(node.right, list);
    } 

    public static void TargetSum(Node node,int tar){

        ArrayList<Integer> list=new ArrayList<>();
        inOrder(node,list);
        int i=0;
        int j=list.size()-1;

        while(i<j)
        {
            if(list.get(i)+list.get(j)>tar){ 
                j--;
            }

            else if(list.get(i)+list.get(j)<tar){
                i++;
            }

            else{
                System.out.println(list.get(i)+" "+list.get(j));
                i++;
                j--;
            }
        }
    }

      public static int maximum(Node node)
  { 
      if(node.right!=null)
      {
          return maximum(node.right);
      }
      
      else{
          return node.data;
      }
  }

  public static Node remove(Node node, int data) {
    // write your code here
    
    if(node==null)
    {
        return null;
    }
    
    if(data>node.data)
    {
        node.right=remove(node.right,data);
    }
    
    else if(data<node.data){
        node.left=remove(node.left,data);
    }
    
    else{
        if(node.left!=null && node.right!=null)
        {
            int lmax=maximum(node.left);
            node.data=lmax;
            
            node.left=remove(node.left,lmax);
            
        }
        else if(node.left!=null){
            return node.left;
        }
        else if(node.right!=null){
            return node.right;
        }
        else{
            return null;
        }
    }
    
    return node;
  }



    public static void main(String[] args)
    {

    }
}