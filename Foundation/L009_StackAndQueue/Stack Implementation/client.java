public class client{
    public static void main(String[] args) throws Exception
    {
        /*stack st=new stack(5);
        for(int i=1;i<5;i++){
            st.push(i*10);
        }*/

        //int[] arr={10,20,30,40,50,60};
        dynamicStack st=new dynamicStack(15);
        for(int i=1;i<20;i++){
            st.push(i*3);
        }
    
        while(st.size()!=0){
            System.out.println(st.pop());
        }

    }
}