package ds;

public class LinkedList {
    // 첫번째 노드를 가리키는 필드
    private Node head;
    private Node tail;
    private int size = 0;

    private class Node {
        // 데이터가 저장될 필드
        private Object data;
        // 다음 노드를 가리키는 필드
        private Node next;

        // Node의 data가 input 이라는 생성자의 매개변수로 전달
        public Node(Object input) {
            this.data = input;
            this.next = null;
        }
    }

    // 노드의 내용을 쉽게 출력해서 확인해볼 수 있는 기능
    public String toString() {
        if (head == null) {
            return "[]";
        }

        Node temp = head;
        String str = "[";
        while (temp.next != null) {
            str += temp.data + ", ";
            temp = temp.next;
        }
        str += temp.data;
        return str + "]";
    }

    public void addFirst(Object input) {
        Node newNode = new Node(input);
        // head를 경유해 원래 first Node를 알아내고 newNode의 다음 Node로 지정
        newNode.next = head;
        // 새로운 head는 newNode
        head = newNode;
        // element 개수 1 증가
        size++;
        if (head.next == null) {
            tail = head;
        }
    }

    public void addLast(Object input) {
        Node newNode = new Node(input);
        // 리스트의 Node가 없다면 addFirst 메서드 사용
        if (size == 0) {
            addFirst(input);
        } else {
            // 마지막 노드의 다음 노드로 newNode를 지정
            tail.next = newNode;
            // 마지막 노드 갱신
            tail = newNode;
            // element 개수 1 증가
            size++;
        }
    }

    Node node(int index) {
        Node x = head;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }

    public void add(int k, Object input) {
        // 넣고자 하는 위치가 0이라면 addFirst() 사용
        if (k == 0) {
            addFirst(input);
        } else {
            Node temp1 = node(k - 1);
            // k번째 Node를 temp2로 지정
            Node temp2 = temp1.next;
            Node newNode = new Node(input);
            // temp1의 다음 Node로 newNode 지정
            temp1.next = newNode;
            // newNode의 다음 Node로 temp2 지정
            newNode.next = temp2;
            size++;
            if (newNode.next == null) {
                tail = newNode;
            }
        }
    }

    public Object removeFirst() {
        Node temp = head;
        head = temp.next;
        Object returnData = temp.data;
        temp = null;
        size--;
        return returnData;
    }

    public Object remove(int k) {
        if (k == 0)
            removeFirst();
        Node temp = node(k - 1);
        Node todoDelete = temp.next;
        temp.next = temp.next.next;
        Object returnData = todoDelete.data;
        if (todoDelete == tail) {
            tail = temp;
        }

        todoDelete = null;
        size--;
        return returnData;
    }

    public int size(){
        return size;
    }

    public Object get(int k){
        Node temp = node(k);
        return temp.data;
    }
}
