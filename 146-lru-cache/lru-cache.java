class LRUCache {
    private class Node {
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key, int val){
            this.key=key;
            this.val=val;
        }
    }
    int capacity;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.map = new HashMap<>();
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.head.next=this.tail;
        this.tail.prev=this.head;
    }

    private void remove(Node node){
        Node back = node.prev;
        Node front = node.next;
        back.next=front;
        front.prev=back;
    }
    private void add(Node node){
        Node headNext = this.head.next;
        this.head.next=node;
        node.prev=this.head;
        node.next = headNext;
        headNext.prev=node; 
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            add(node);
            return node.val;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            remove(node);
            add(node);

        }else{
            if(capacity==map.size()){
                Node last = this.tail.prev;
                map.remove(last.key);
                remove(last);

            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            add(newNode);
            
        }
        
    }
}
