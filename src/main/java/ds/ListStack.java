package ds;

public class ListStack {
    Node top;

    private class Node{
        private Node nextNode;
        private Object data;

        public Node(Object data){
            this.nextNode = null;
            this.data = data;
        }
    }

    public ListStack(){
        this.top = null;
    }

    public Object peek(){
        if(top == null) return -1;
        return top.data;
    }

    public boolean empty(){
        return (top == null);
    }

    public void push(Object item){
        Node node = new Node(item);
        node.nextNode = top;
        top = node;
    }

    public Object pop(){
        if(top == null) return -1;
        Object item = peek();
        top = top.nextNode;
        return item;
    }
}
