public class queue{
    protected int[] arr=null;
    protected int elementCount=0;
    protected int front=0;
    protected int back=0;
    protected int capacity=0;

    protected void initializeVariables(int capacity){
        this.capacity=capacity;
        this.arr = new int[capacity];
        this.elementCount=0;
        this.front=0;
        this.back=0;
    }

    //Constructor-----------------------------------
    public queue(){
        initializeVariables(10);
    }

    public queue(int size){
        initializeVariables(size);
    }

    //Basic Functions------------------------------------
    public int size(){
        return elementCount;
    }

    public boolean isEmpty(){
        return elementCount==0;
    }

    //Exceptions----------------------------------------
    private void OverFlowException() throws Exception{
        if(this.elementCount==this.capacity){
            throw new Exception("QueueIsFull");
        }
    }

    private void UnderFlowException() throws Exception{
        if(this.elementCount==0){
            throw new Exception("QueueIsEmpty");
        }
    }

    //Queue Functions----------------------------------
    protected void add_(int data){
        this.arr[this.back]=data;
        this.elementCount++;
        this.back=(this.back+1)%this.capacity;
    }

    public void add(int data) throws Exception{
        OverFlowException();
        add_(data);
    }

    public int peek() throws Exception{
        UnderFlowException();
        return this.arr[this.front];
    }

    protected int remove_(){
        int rv=this.arr[this.front];
        this.arr[this.front]=0;
        this.elementCount--;
        this.front=(this.front+1)%this.capacity;
        return rv;
        }


    public int remove() throws Exception{
        UnderFlowException();
        return remove_();
    }
}

