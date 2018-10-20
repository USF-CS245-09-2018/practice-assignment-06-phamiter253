public class ArrayQueue implements Queue {

    Object arr[];
    int head;
    int tail;

    public ArrayQueue(){
        arr = new Object[10];
        head = 0;
        tail = 0;
    }

    public void printArr(){
        System.out.println();
        System.out.print("Queue:[");
        for(int i = 0; i < arr.length-1; i++){
            System.out.print(arr[i]+",");
        }
        System.out.print(arr[arr.length-1]+"]");
        System.out.println();
    }

    public void growArray(){
        Object[] newArr = new Object[arr.length * 2];
        int index = head;
        int i = 0;
        if(head < tail){
            while(index <= tail){
                newArr[i++] = arr[index++];
            }
        }else{
            while(index < arr.length){
                newArr[i++] = arr[index++];
            }
        }
        index = 0;
        while(index < head){
            newArr[i++] = arr[index++];
        }
        tail = i-1;
        head = 0;
        arr = newArr;
    }

    public Object dequeue(){
        Assert.not_false(!empty());
        Object obj = arr[head];
        arr[head++] = null;
        head = head % arr.length;
        return obj;
    }

    public void enqueue(Object item){
        if((tail+1)%arr.length == head){
            growArray();
        }
        arr[tail++] = item;
        tail = tail%arr.length;
    }
    public boolean empty(){
        return (head == tail);
    }

}
