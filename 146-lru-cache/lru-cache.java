class Node {
    int key;int val;
    Node prev; Node next;
    Node(int key, int val){
        this.key=key;
        this.val=val;
    }
}


class LRUCache {
    Node head;
    Node tail;
    int capacity;
    HashMap<Integer, Node > map;

    public LRUCache(int capacity) {
        this.head=new Node(-1, -1);
        this.tail=new Node(-1, -1);
        this.capacity=capacity;
        this.head.next=this.tail;
        this.tail.prev=this.head;
        map=new HashMap<>();
        
    }
    public void remove(Node node){
        Node nxt = node.next;
        Node prv = node.prev;

        prv.next=nxt;
        nxt.prev=prv;
    }
    public void add(Node node){
        Node nxtHead= this.head.next;
        this.head.next=node;
        node.prev=this.head;
        node.next=nxtHead;
        nxtHead.prev=node;
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
            return;

        }else{
            if(this.capacity == map.size()){
                Node last = this.tail.prev;
                map.remove(last.key);
                remove(last);
            }
            Node node =new Node(key, value);
            map.put(key, node);
            add(node);

        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */