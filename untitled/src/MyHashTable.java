public class MyHashTable<K, V>{
    private class HashNode<K, V>{
        private K key;
        private V value;
        private HashNode<K, V> next;
        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString(){
            return "{" + key + ":" + value + "}";
        }
    }
    private HashNode <K, V>[] chainArray;
    private int len = 11;
    private int size = 0;
    public MyHashTable(){
        this.chainArray = new HashNode[len];
    }
    public MyHashTable(int len){
        this.len = len;
        this.chainArray = new HashNode[len];
    }
    private int hash(K key){
        if (key == null) {
            return 0;
        }
        int hashCode = 1;
        char[] arr = key.toString().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            hashCode = 13 * hashCode + c;
        }
        hashCode = hashCode % len;
        return hashCode;
    }
    public void put(K key, V value){
        int hash = hash(key);
        HashNode<K, V> hashNode = new HashNode<K, V>(key, value);
        HashNode<K, V> rootNode = chainArray[hash];
        if(rootNode == null){
            chainArray[hash] = hashNode;
            size++;
            return;
        }
        while(rootNode.next != null){
            if (rootNode.key.equals(key)){
                rootNode.value = value;
                return;
            }
            rootNode = rootNode.next;
        }
        if (rootNode.key.equals(key)){
            rootNode.value = value;
            return;
        }
        rootNode.next = hashNode;
        size++;
    }
    public V get(K key){
        int hash = hash(key);
        HashNode<K, V> rootNode = chainArray[hash];
        while(rootNode != null){
            if(rootNode.key.equals(key)){
                return rootNode.value;
            }
            rootNode = rootNode.next;
        }
        return null;
    }
    public V remove(K key){
        int hash = hash(key);
        HashNode<K, V> rootNode = chainArray[hash];
        if(rootNode.key.equals(key)){
            chainArray[hash] = rootNode.next;
            size--;
            return rootNode.value;
        }
        while(rootNode.next != null){
            if(rootNode.next.key.equals(key)){
                rootNode.next = rootNode.next.next;
                size--;
                return rootNode.next.value;
            }
            rootNode = rootNode.next;
        }
        return null;
    }
    public boolean contains(V value){
        return false;
    }
    public K getKey(V value){
        for (int i = 0; i < len; i++){
            HashNode<K, V> rootNode = chainArray[i];
            while(rootNode != null){
                if (rootNode.value.equals(value)){
                    return rootNode.key;
                }
                rootNode = rootNode.next;
            }
        }
        return null;
    }
}