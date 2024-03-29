//linkedlist levelUp
public class questions{

    public static class ListNode{
        int val=0;
        LostNode next=null;

        ListNode(int val){
            this.val=val;
        }
    }

    public static ListNode midNode2(ListNode head){
        if(head==nul ||head.next==null){
            return head;
        }

        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return  slow;
    }

    public static ListNode midNode(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    
    public static ListNode reverseLL(ListNode head){

        if(head==null || head.next==null){
            return head;
        }

        ListNode prev=null;
        ListNode curr=head;

        while(curr!=null){
            ListNode forw=curr.next;

            curr.next=prev;
            prev=curr;
            curr=forw;
        }

        return prev;
    }

    public static boolean isPalindrome(ListNode head){
        if(head==null || head.next==null)
        {
            return true;
        }

        ListNode mid=midNode(head);
        ListNode nHead=mid.next;
        mid.next=null;
        nHead=reverseLL(nHead);

        ListNode c1=head;
        ListNode c2=nHead;

        boolean res=true;
        while(c2!=null)
        {
            if(c1.val==c2.val){
                c1=c1.next;
                c2=c2.next;
            }

            else{
                res=false;
                break;
            }
        }

        nHead=reverseLL(nHead);
        mid.next=nHead;
        return res;
    }

    public static void fold(ListNode head)
    {

        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode mid=midNode(head);
        ListNode nHead=mid.next;

        mid.next=null;

        nHead=reverseLL(nHead);

        ListNode c1=head;
        ListNode c2=nHead;

        while(c2!=null)
        {
            ListNode f1=c1.next;
            ListNode f2=c2.next;

            c1.next=c2;
            c2.next=f1;

            c1=f1;
            c2=f2;
        }
    }

public static void unfold(ListNode head){
    f(head==null || head.next==null)
    {
        return;
    }

    ListNode l1=new ListNode(-1);
    ListNode l2=new ListNode(-1);

    ListNode p1=l1;
    ListNode p2=l2;

    ListNode c1=head;
    ListNode c2=c1.next;

    while(c1!=null && c2!=null)
    {
        p1.next=c1;
        p2.next=c2;

        p1=p1.next;
        p2=p2.next;

        if(c2!=null)// for odd Len
        {
            c1=c2.next;
        }

        if(c1!=null)// for even Len
        {
            c2=c1.next;
        }
    }

    p1.next=null;
    l2.next=reverseLL(l2.next);
    p1.next=l2.next;
}

    public static ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 != null ? l1 : l2;

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy, c1 = l1, c2 = l2;

        while (c1 != null && c2 != null) {
            if (c1.val <= c2.val) {
                prev.next = c1;
                prev=c1;
                c1 = c1.next;
            } else {
                prev.next = c2;
                prev=c2;
                c2 = c2.next;
            }
        }
        prev.next = c1 != null ? c1 : c2;
        return dummy.next;
    }

    public static ListNode mergeKSortedLists(ListNode[] lists){

        if(lists.length==0){
            return null;
        }
        ListNode head=null;

        for(ListNode node:lists){
            mergeTwoSortedLists(head,node);
        }

        return head;
    }

//optimized approach--------------------------------------------
//T : O(NlogkK), S : O(logK) -> N = k times of (avg length Of Linkedlist),where k is length of lists.
    public static ListNode mergeKLists(ListNode[] lists,int si,int ei){

        if(si>=ei)
        {
            return lists[si];
        }

        int mid=(si+ei)/2;
        ListNode leftMergedList=mergeKLists(lists,si,mid);
        ListNode rightMergedList=mergeKLists(lists,mid+1,ei);
        
        ListNode ans=mergeTwoSortedLists(leftMergedList,rightMergedList);
        return ans;
    }

    public static ListNode mergeKSortedLists(ListNode[] lists)
    {
        if(lists.length==0){
            return null;
        }

        mergeKLists(lists,0,lists.length-1);
    }

    public static ListNode mergeSort(ListNode head){
        if(head==null || head.next==null){
            return head;
        }

        ListNode mid=midNode(head);
        ListNode nhead=mid.next;
        mid.next=null;

        ListNode list1=mergeSort(head);
        ListNode list2=mergeSort(nhead);

        return mergeTwoSortedLists(list1,list2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head==null || n<=0)
        {
            return head;
        }
        ListNode fast=head;
        ListNode slow=head;

        while(n-->0){
            fast=fast.next;
            if(fast==null && n>0)
            {
                return head;
            }
        }

        if(fast==null)
        {
            ListNode rNode=head;
            head=rNode.next;
            rNode.next=null;
            return head;
        }

        while(fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }

        ListNode rNode=slow.next;
        slow.next=rNode.next;
        rNode.next=null;

        return head;
    }

    public static ListNode segregateEvenOdd(ListNode head){

        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode even=new ListNode(-1);
        ListNode odd=new ListNode(-1);

        ListNode ep=even;
        ListNode op=odd;

        ListNode curr=head;

        while(curr!=null)
        {
            if(curr%2==0){
                ep.next=curr;
                ep=curr;
                curr=curr.next;
            }
            
            else{
                op.next=curr;
                op=curr;
                curr=curr.next;
            }
        }
        op.next=null;
        ep.next=odd.next;

        return even.next;

    }

    public static ListNode segregate01(ListNode head){

        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode curr=head;
        ListNode one=new ListNode(-1);
        ListNode zero=new ListNode(-1);

        ListNode op=one;
        ListNode zp=zero;

        while(curr!=null)
        {
            if(curr==0)
            {
                zp.next=curr;
                zp=curr;
                curr=curr.next;
            }

            else{
                op.next=curr;
                op=curr;
                curr=curr.next;
            }
        }

        op.next=null;
        zp.next=one.next;
        head=zero.next;

        return head;
    }

    public static ListNode segregate012(Node head)
    {
        if(head==null || head.next==null){
            return head;
        }
        ListNode zero =new Node(-1);
        ListNode one=new Node(-1);
        ListNode two=new Node(-1);
        
        ListNode zp=zero;
        ListNode op=one;
        ListNode tp=two;
        
        ListNode curr=head;
        
        while(curr!=null)
        {
            if(curr.val==0)
            {
                zp.next=curr;
                zp=curr;
            }
            
            else if(curr.val==1)
            {
                op.next=curr;
                op=curr;
               
            }
            
            else{
                tp.next=curr;
                tp=curr;
            }
            
             curr=curr.next;
        }
        
        tp.next=null;
         op.next=two.next;
        zp.next=one.next;
     
        return zero.next;
}

public static ListNode segregateOnLastIndex(ListNode head) {
    ListNode curr=head;
    ListNode small=new ListNode(-1);
    ListNode large=new ListNode(-1);

    ListNode lp=large;
    ListNode sp=small;

    ListNode pivotNode=head;
    while(pivotNode.next!=null)
    {
        pivotNode=pivotNode.next;
    }

    while(curr!=null){
        if(curr.val<=pivotNode.val){
            sp.next=curr;
            sp=curr;
            curr=curr.next;
        }

        else {
            lp.next=curr;
            lp=curr;
            curr=curr.next;
        }
    }

    lp.next=null;
    sp.next=large.next;

    return sp;
}

 public static ListNode segregate(ListNode head, int pivotIdx) {

     if(head==null || head.next==null){
         return head;
     }

    ListNode small=new ListNode(-1);
    ListNode large=new ListNode(-1);

     ListNode sp=small;
     ListNode lp=large;
     ListNode curr=head;
     ListNode pivotNode=head;
     while(pivotIdx-->0)
     {
         pivotNode=pivotNode.next;
     }

     while(curr!=null){
         if(curr!=pivotNode && pivotNode.val>curr.val)
         {
             sp.next=curr;
             sp=curr;
             curr=curr.next;
         }

         else if(curr!=pivotNode  && pivotNode.val<curr.val){
             lp.next=curr;
             lp=curr;
             curr=curr.next;
         }

         else{
             curr=curr.next;
         }
     }

    sp.next=pivotNode;
    pivotNode.next=large.next;
    lp.next=null;

    return small.next;
  }


//     public static ListNode reverse(ListNode head){

//         if(head==null || head.next==null){
//             return head;
//         }

//         ListNode prev=null;
//         ListNode curr=head;

//         while(curr!=null){
//             ListNode forw=curr.next;

//             curr.next=prev;
//             prev=curr;
//             curr=forw;
//         }

//         return prev;
//     }

//     public static ListNode addTwoLL(ListNode l1,ListNode l1){
//         l1=reverse(l1);
//         l2=reverse(l2);

//         ListNode dummy=new ListNode(-1);
//         ListNode c1=l1,c2=l2,prev=dummy;

//         int carry=0;
//         while(c1!=null || c2!=null || carry!=0){
//             int ans=carry=(c1!=null ? c1.val : 0)+(c2!=null ? c2.val:0);
//             int sum=ans%10;
//             carry=ans/10;
        
//         prev.next=new ListNode(sum);
//         prev=prev.next;
//     }

//     ListNode head=dummy.next;
//     head=reverse(head);

//     l1=reverse(l1);
//     l2=reverse(l2);

//     return head;

// }

// public static ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
//         l1 = reverse(l1);
//         l2 = reverse(l2);

//         ListNode dummy = new ListNode(-1);
//         ListNode c1 = l1, c2 = l2, prev = dummy;
//         int borrow = 0;
//         while (c1 != null || c2 != null) {
//             int diff = borrow + (c1 != null ? c1.val : 0) - (c2 != null ? c2.val : 0);
//             if (diff < 0) {
//                 diff += 10;
//                 borrow = -1;
//             } else
//                 borrow = 0;

//             prev.next = new ListNode(diff);
//             prev = prev.next;

//             if (c1 != null)
//                 c1 = c1.next;
//             if (c2 != null)
//                 c2 = c2.next;
//         }

//         ListNode head = dummy.next;
//         head = reverse(head);

//         while (head != null && head.val == 0) // 1000000000 - 99999999 = 1, 999 - 999 = 0
//             head = head.next;

//         l1 = reverse(l1);
//         l2 = reverse(l2);

//         return head;
//     }

//      public static boolean isCyclePresentInLL(ListNode head) {
//         if (head == null || head.next == null)
//             return false;

//         ListNode slow = head;
//         ListNode fast = head;

//         while (fast != null && fast.next != null) {
//             fast = fast.next.next;
//             slow = slow.next;

//             if (fast == slow)
//                 return true;

//         }

//         return false;
//     }
    
//     public static ListNode CycleNode(ListNode head) {
//         if (head == null || head.next == null)
//             return null;

//         ListNode slow = head;
//         ListNode fast = head;

//         while (fast != null && fast.next != null) {
//             fast = fast.next.next;
//             slow = slow.next;

//             if (fast == slow)
//                 break;
//         }

//         if (fast != slow)
//             return null;

//         slow = head;
//         while (slow != fast) {
//             slow = slow.next;
//             fast = fast.next;
//         }

//         return slow;
//     }

//     public static ListNode CycleNode2(ListNode head) {
//         if (head == null || head.next == null)
//             return null;

//         ListNode slow = head;
//         ListNode fast = head;

//         while (fast != null && fast.next != null) {
//             fast = fast.next.next;
//             slow = slow.next;

//             if (fast == slow)
//                 break;
//         }

//         if (fast != slow)
//             return null;

//         ListNode meetingNode = fast;
//         int a = 0, b = 0, c = 0, bc = 0, nDash = 0, n = 0; // bc is (b + c)F

//         slow = head;
//         while (slow != fast) {
//             slow = slow.next;
//             fast = fast.next;

//             if (fast == meetingNode)
//                 nDash++;
//             a++;
//         }   

//         fast = meetingNode;
//         fast = fast.next;

//         bc = 1;
//         while (fast != meetingNode) {
//             fast = fast.next;
//             bc++;
//         }

//         n = nDash + 1;
//         c = a - bc * nDash;
//         b = bc - c;

//         System.out.println("Length Of Tail is:" + a);
//         System.out.println("Length Of b is:" + b);
//         System.out.println("Length Of c is:" + c);
//         System.out.println("No Of rotation by fast pointer before meeting poiny:" + n);
//         System.out.println("No Of rotation by fast pointer after meeting poiny:" + nDash);

//         return slow;
//     }
