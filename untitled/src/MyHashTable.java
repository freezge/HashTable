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
    private int len = 11;
    private int size;
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
        return hashCode;
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