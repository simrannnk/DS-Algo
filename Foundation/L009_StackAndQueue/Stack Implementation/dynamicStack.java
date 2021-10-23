public class dynamicStack extends stack{

    public dynamicStack(){
        super();
    }

    public dynamicStack(int size){
        super(size);
    }

    public dynamicStack(int[] arr){
    super.initializeVariables(arr.length);
    for(int ele:arr){
        super.push_(ele);
    } 
    }

    @Override
    public void push(int data) throws Exception{
        if(super.capacity==super.elementCount){
            int[] temp=super.arr;//Copy old data 
            super.initializeVariables(2*super.capacity);//Allocate new space for upcoming data
            for(int ele:temp){
                super.push_(ele);//Copy old data in new space
            }
        }
          super.push(data);//Add new data


    }
}

