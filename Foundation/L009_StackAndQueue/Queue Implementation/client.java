public class client{
    public static void main(String[] args) throws Exception{
        queue que=new queue(6);
        for(int i=1;i<4;i++)
        {
            que.add(i*10);
        }

        while(que.size()!=0){
           System.out.println(que.remove());

        }
        System.out.println(que);
    }
}