public class l002_BST{
    public class TreeNode{
        int val=0;
        TreeNode left=null;
        TreeNode right=null;

        TreeNode(int val)
        {
            this.val=val;
        }
    }

     public static int size(TreeNode root) {
        return root == null ? 0 : size(root.left) + size(root.right) + 1;
    }

    public static int height(TreeNode root)
    {
        return root==null?-1:(Math.max(height(root.left),height(root.right))+1;
    }

    public static int maximum(TreeNode root)
    {
        TreeNode curr = root;
        while (curr.right != null) // rightMost Node of the tree
            curr = curr.right;

        return curr.val;
    
    }

    public static int minimum(TreeNode root)
    {
        TreeNode curr=root;
        while(curr.left!=null)
        {
            curr=curr.left;
        }

        return curr.val;//leftmost node of the tree is minimum in BST
    }

    public static boolean findData(TreeNode root,int data)
    {
        TreeNode curr=root;
        while(curr!=null)
        {
            if(curr.data==data)
            {
                return true;
            }

            else if(curr.data>data)
            {
                curr=curr.left;
            }
            else{
                curr=curr.right;
            }
        }
        return false;
    }

    public static ArrayList<Integer> NodeToRootPath(TreeNode root,int data)
    {
        ArrayList<Integer> ans=new ArrayList<>();
        TreeNode curr=root;
        boolean flag=false;
        while(curr!=null)
        {
            ans.add(curr.data);
            if(curr.data==data)
            {
                flag=true;
                break;
            }

            else if(curr.data>data)
            {
                curr=curr.left;
            }

            else{
                curr=curr.right;
            }
        }

        if(!flag)
        {
            ans.clear();
        }

        return ans;

    }

    public static TreeNode lowestCommonAncestor(TreeNode root,int p,int q)
    {
        TreeNode curr=root;
        while(curr!=null)
        {
            if(curr.val<p && curr.val<q)
            {
                curr=curr.right;
            }

            else if(curr.val>p && curr.val>q)
            {
                curr=curr.left;
            }

            else{
                return curr;
            }
        }

        return null;
    }

   class BSTIterator {

    private ArrayDeque<TreeNode> st=new ArrayDeque<>();//addFirst,RemoveFirst
    public BSTIterator(TreeNode root) {
        addLeft(root);
    }

    public void addLeft(TreeNode root)
    {
        while(root!=null)
        {
            this.st.addFirst(root);
            root=root.left;
        }
    }
    
    public int next() {
        TreeNode rNode=this.st.RemoveFirst();
        addLeft(rNode.right);

        return rNode.val;
    }
    
    public boolean hasNext() {
        return this.st.size()!=0;
    }
}


    public static void main(String[] args)
    {

    }
}