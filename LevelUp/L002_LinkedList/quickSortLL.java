import java.util.Random;
public class QuickSort{

public class ListNode{
    ListNode next=null;
    int val=0;

    ListNode(int val)
    {
        this.val=val;
    }
}

 Random rand=new Random();

public static int length(ListNode head)
{
    if(head==null)
    {
        return 0;
    }

    ListNode curr=head;
    int len=0;
    while(curr!=null)
    {
        len++;
        curr=curr.next;
    }

    return len;
}

public ListNode[] segregate(ListNode head,int pivotIdx)//returns an array oh head1, pivotNode and head2
{
    ListNode pivotNode=head;
    ListNode large=new Listnode(-1);
    ListNode small=new Listnode(-1);

    Listnode curr=head;
    ListNode sp=small,lp=large;

    while(pivotIdx-->0)
    {
        pivotNode=pivotNode.next;
    }

    while(curr!=null)
    {
        if(curr!=pivotNode && cur.val<=pivotNode.val)
        {
            sp.next=curr;
            sp=curr;
            curr=curr.next;
        }

        else if(curr!=pivotNode && curr.val>pivotNode.val)
        {
            lp.next=curr;
            lp=curr;
            curr=curr.next;
        }

        else{
            curr=curr.next;
        }
    }
    pivotNode.next=null;
    sp.next=null;
    lp.next=null;

    return new ListNode[]{small.next,pivotNode,large.next};
}

public static void mergeElements(ListNode[] left,ListNode[] right,Listnode pivotNode)//returns an array of head and tail
{
    ListNode head=null;
    ListNode tail=null;

    if(left[0]!=null && right[0]!=null)
    {
        head=left[0];
        tail=right[1];
        left[1].next=pivotNode;
        pivotNode.next=right[0];
    }

    else if(left[0]!=null)
    {
        head=left[0];
        tail=pivotNode;
        left[1].next=pivotNode;
    }

    else if(right[0]!=null)
    {
        head=pivotNode;
        tail=right[1];
        pivotNode.next=right[0];
    }

    else{
        head=pivotNode;
        tail=pivotNode;
    }

    return new ListNode[]{head,tail};
}

public ListNode[] quickSort(ListNode head)//returns an array of head and tail //T(N)=2N+2T(N/2)
{
    if(head==null || head.next==null)//O(1)
    {
        return new ListNode[]{head,head};
    }

    int len=length(head);//O(N)
    int pivotIdx=rand.nextInt(len);//O(1)
    
    ListNode[] segregatedElements=segregate(head,pivotIdx);//segreagatedElements is an array of head1, pivotNode and head2 //O(N)

     ListNode pivotNode=segregatedElements[1];
     ListNode[] left=quickSort(segregatedElements[0]);//O(N/2)
     ListNode[] right=quickSort(segregatedElements[2]);//O(N/2)

    return mergeElements(left,right,pivotNode);
     
}

public ListNode sortList(ListNode head) {
    ListNode[] ans=new ListNode[2];
    ans=quickSort(head);
    return ans[0];
        
    }

}