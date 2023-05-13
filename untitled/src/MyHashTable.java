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
            return "{" + key + " : " + value + "}";
        }
    }
    private HashNode <K, V>[] chainArray;
    private int length = 11;
    private int size;
    public MyHashTable(){
        this.chainArray = new HashNode[length];
    }
    public MyHashTable(int length){
        this.length = length;
        this.chainArray = new HashNode[length];
    }
    private int hash(K key){
        return 0;
    }
    public void put(K key, V value){}
    public V get(K key){
        return null;
    }
    public V remove(K key){
        return null;
    }
    public boolean contains(V Value){
        return false;
    }
    public K getKey(V value){
        return null;
    }
}