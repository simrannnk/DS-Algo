import java.util.Stack;
import java.util.LinkedList;
import java.util.Arrays;

public class questions {
    // NG : Next Greater
    // NS : Next Smaller
    // OR : on Right
    // OL : on Left
    public static int[] NGOR(int[] arr) {
        int n = arr.length;
        LinkedList<Integer> st = new LinkedList<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i++) {
            while (st.size() != 0 && arr[st.getFirst()] < arr[i]) {
                ans[st.removeFirst()] = arr[i];
            }

            st.addFirst(i);
        }
        return ans;
    }

    public static int[] NGOL(int[] arr) {
        int n = arr.length;
        LinkedList<Integer> st = new LinkedList<>();
        int[] ans = new int[n];
        for (int i = n-1; i >=0 n; i--) {
            while (st.size() != 0 && arr[st.getFirst()] < arr[i]) {
                ans[st.removeFirst()] = arr[i];
            }

            st.addFirst(i);
        }
        return ans;

    }

    public static int[] NSOR(int[] arr) {
        int n = arr.length;
        LinkedList<Integer> st = new LinkedList<>();
        int[] ans = new int[n];
        Arrays.fill(ans,-1);

        for(int i=0;i<n;i++){
            while(st.size()!=0 && arr[st.getFirst() > arr[i]]){
                ans[st.removeFirst()]=arr[i];
            }

            st.addFirst(i);
        }
        return ans;
    }

    public static int[] NSOL(int[] arr) {
        int n = arr.length;
        LinkedList<Integer> st = new LinkedList<>();
        int[] ans = new int[n];
         Arrays.fill(ans,-1);

        for(int i=n-1;i>=0;i--){
            while(st.size!=0 && arr[st.getFirst() > arr[i]]){
                ans[st.removeFirst()]=arr[i];
            }

            st.addFirst(i);
        }
        return ans;

    }

    public static int[] NSOR_(int[] arr) {
        int n = arr.length;
        LinkedList<Integer> st = new LinkedList<>();
        int[] ans = new int[n];
        Arrays.fill(ans,n);

        for(int i=0;i<n;i++){
            while(st.size()!=0 && arr[st.getFirst() > arr[i]]){
                ans[st.removeFirst()]=i;
            }

            st.addFirst(i);
        }
        return ans;
    }

     public static int[] NSOL_(int[] arr) {
        int n = arr.length;
        LinkedList<Integer> st = new LinkedList<>();
        int[] ans = new int[n];
         Arrays.fill(ans,-1);

        for(int i=n-1;i>=0;i--){
            while(st.size!=0 && arr[st.getFirst() > arr[i]]){
                ans[st.removeFirst()]=i;
            }

            st.addFirst(i);
        }
        return ans;

    }


    public static int largestArea(int[] arr){
        int[] NSOL = NSOL_(arr);
        int[] NSOR= NSOR_(arr);

        int n=arr.length;
        int area=0;
       
        for(int i=0;i<n;i++){
            int height=arr[i];
            int width=NSOR_[i]-NSOL_[i]-1;
            area=Math.max(area,(height*width));
        }
        return area;

    }

    public static boolean duplicateBrackets(String str){
         Stack<Character> st = new Stack<>();
         for(int i=0;i<str.length();i++){
             

         }
    }

}