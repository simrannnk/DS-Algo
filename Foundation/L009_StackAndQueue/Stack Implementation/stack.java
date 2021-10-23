public class stack{

    protected int[] arr = null;
    protected int tos=-1;
    protected int capacity=0;
    protected int elementCount=0;

    protected void initializeVariables(int capacity){
        this.capacity=capacity;
        this.tos=-1;
        this.elementCount=0;
        this.arr=new int[this.capacity];
    }

    //Constructor---------------------------------------
    public stack()
    {
      initializeVariables(10);

    }

    public stack(int size)
    {
     initializeVariables(size);
       
    }

    //Basic Functions-----------------------------------
    public int size(){
        return elementCount;

    }

    public boolean isEmpty(){
        return elementCount==0;

    }

    //Exceptions---------------------------------------
    private void UnderFlowException() throws Exception{
        if(this.capacity==0){
            throw new Exception("StackIsEmpty");
        }
    }

    private void OverFlowException() throws Exception{
        if(this.capacity==this.elementCount){
            throw new Exception("StackIsFull");
        }
    }

    //Stack Functions-----------------------------------
    protected void push_(int data){
        this.arr[++this.tos]=data;
        this.elementCount++;
    }

    public void push(int data) throws Exception{
        OverFlowException();
        push_(data);
    }

    public int peek() throws Exception{
        UnderFlowException();
        return this.arr[this.tos];

    }

    protected int pop_(){
        int rv=this.arr[this.tos];
        this.arr[this.tos--]=0;
        this.elementCount--;
        return rv;
    }

    public int pop() throws Exception{
        UnderFlowException();
        return pop_();

    }
}