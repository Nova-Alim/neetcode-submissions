class LRUCache {
    
    HashMap<Integer,Node> map;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity=capacity;

        head= new Node(0,0);
         tail= new Node(0,0);

        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);

        remove(node);
        addToFront(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
          
        Node node = map.get(key);
        node.val=value;

        remove(node);
        addToFront(node);
         return;
        }

        Node newNode = new Node(key,value);
        map.put(key,newNode);
        addToFront(newNode);

        if(map.size()>capacity){
            Node oldest= tail.prev;
            remove(oldest);
            map.remove(oldest.key);
        }

     

       
    }

    private void addToFront(Node node){
        node.next=head.next;
        node.prev=head;

        head.next.prev=node;
        head.next=node;
    }

    private void remove(Node node){
        Node before = node.prev;
        Node after= node.next;

        before.next=after;
        after.prev=before;
    }
}

class Node{
    int val;
    int key;
    Node next;
    Node prev;

    

    Node (int key,int val){
        this.val=val;
        this.key=key;
        this.next=null;
        this.prev=null;

    }

}
