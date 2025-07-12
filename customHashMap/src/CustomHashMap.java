import java.util.LinkedList;

public class CustomHashMap <K,V>{

    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private Node<K,V> nodes[];
    public CustomHashMap() {
        nodes = new Node[DEFAULT_CAPACITY];
    }
    public CustomHashMap(int defaultCapacity) {
        nodes = new Node[defaultCapacity];
    }

    private static class Node<K,V>{
        private K key;
        private V value;
        private Node<K,V> next;

        public Node(K key,V value){
            this.key = key;
            this.value = value;
            next=null;
        }
    }

    public V get(K key){
        int hashValue = key.hashCode() % nodes.length;
        System.out.println("hash code of key"+key+": "+hashValue);

        Node<K,V> currNode = nodes[hashValue];
        while(currNode.next!=null && currNode.key!=key){
            currNode=currNode.next;
        }
        if(currNode==null){
            return null;
        }
        return currNode.value;
    }

    public void put(K key,V value){
        int hashValue = key.hashCode() % nodes.length;
        if(nodes[hashValue]==null)
            nodes[hashValue] = new Node(key,value);
        else{
            Node<K,V> currNode = nodes[hashValue];
            while(currNode!=null){
                if(currNode.key==key){
                    currNode.value=value;
                    return;
                }
                if(currNode.next==null)
                    break;
                currNode=currNode.next;
            }
            System.out.println();
            currNode.next = new Node(key,value);
        }
    }
}
