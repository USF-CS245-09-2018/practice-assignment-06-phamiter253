public class ArrayStack implements Stack {

    Object[] arr;
    int top;

    public ArrayStack(){
        arr = new Object[10];
        top = -1;
    }

    public void printArr(){
        System.out.println();
        System.out.print("Stack:[");
        for(int i = 0; i < arr.length-1; i++){
            System.out.print(arr[i]+ ",");
        }
        System.out.print(arr[arr.length-1]+ "]");
        System.out.println();
    }

    public void growArray(){
        Object[] newArr = new Object[arr.length * 2];
        int i = 0;
        while(i < arr.length){
            newArr[i++] = arr[i++];
        }
        arr = newArr;
    }

    public void push(Object item){
        ++top;
        if(top == arr.length){
            growArray();
        }
        arr[top] = item;
    }
    public Object pop(){
        Assert.not_false(!empty());
        Object obj = arr[top];
        arr[top--] = null;
        return obj;
    }
    public Object peek(){
        Assert.not_false(!empty());
        return arr[top];
    }
    public boolean empty(){
        return (top == -1);
    }
}
