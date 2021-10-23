public class dynmaicQueue extends queue{

    public dynamicQueue(){
        super();
    }

    public dynamicQueue(int size){
        super(size);
    }
    
    public dynamicQueue(int[] arr){
        super.initializeVariables(arr.length());
        for(int ele:arr){
            super.add(ele);
        }   
    }

    @Override
    public void add(int data) throws Exception{
        if(super.capacity==super.elementCount)
        {
            int[] temp=super.arr;
            super.initializeVariables(2*super.capacity);
           for(int ele:temp){
                super.add(ele);
            }
        }
        super.add_(data);
    }
}
