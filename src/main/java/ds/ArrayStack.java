package ds;

public class ArrayStack {
    int top;
    int maxSize;
    Object[] array;

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        this.top = -1;
        this.array = new Object[maxSize];
    }

    public boolean empty(){
        return (top == -1);
    }

    public Object peek() {
        if(top == -1) return -1;
        return array[top];
    }

    public void push(Object item){
        array[++top] = item;
    }

    public Object pop(){
        if(top == -1) return -1;
        return array[top--];
    }
}
