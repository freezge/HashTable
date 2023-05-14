# ADS Assignment 4
### Assignment 4 | HashTable
### Task
```
Create an additional class for testing K (example: MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();)

Create your own hashCode() method in MyTestingClass (You are not allowed to use default hashing methods like Objects.hash())

Add random 10000 elements to your hashtable and print number of elements in each bucket (chain or linkedlist).

Tune your hashCode method in MyTestingClass so that it does not violate the uniform distribution.
```
### Code for Main
```
public class Main {
    public static void main(String[] args) {
        Test test = new Test();
//        test.test1();
//        test.test2();
//        test.test3();
//        test.test4();
    }
}
```
### Code for MyHashTable
```
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
    public MyHashTable(){//constructor
        this.chainArray = new HashNode[len];
    }
    public MyHashTable(int len){//constructor
        this.len = len;
        this.chainArray = new HashNode[len];
    }
    private int hash(K key){
        if (key == null) {//checking if key is not empty
            return 0;
        }
        int hashCode = 1;//can put any prime number here
        char[] arr = key.toString().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            hashCode = 13 * hashCode + c;
        }
        hashCode = hashCode % len;
        return hashCode;//returning index
    }
    public void put(K key, V value){
        int hash = hash(key);
        HashNode<K, V> hashNode = new HashNode<K, V>(key, value);
        HashNode<K, V> rootNode = chainArray[hash];
        if(rootNode == null){//checking if its first entered element
            chainArray[hash] = hashNode;//input in array
            size++;//increasing size
            return;//end of func here
        }
        while(rootNode.next != null){//if it's not first moving to the end
            if (rootNode.key.equals(key)){//if we already have the same key
                rootNode.value = value;//we change its value
                return;//end of func here
            }
            rootNode = rootNode.next;
        }
        if (rootNode.key.equals(key)){//doing the same again for the last element
            rootNode.value = value;
            return;
        }
        rootNode.next = hashNode;//adding to the end
        size++;
    }
    public V get(K key){
        int hash = hash(key);
        HashNode<K, V> rootNode = chainArray[hash];
        while(rootNode != null){//loop to move through array
            if(rootNode.key.equals(key)){//if we found it we return its value
                return rootNode.value;
            }
            rootNode = rootNode.next;
        }
        return null;
    }
    public V remove(K key){
        int hash = hash(key);
        HashNode<K, V> rootNode = chainArray[hash];
        if (rootNode == null){//checking for emptiness
            return null;
        }
        if(rootNode.key.equals(key)){//checking needed element is the first
            chainArray[hash] = rootNode.next;
            size--;
            return rootNode.value;
        }
        while(rootNode.next != null){//loop to move through array
            if(rootNode.next.key.equals(key)){//condition
                rootNode.next = rootNode.next.next;//removing element here
                size--;//decreasing size
                return rootNode.next.value;
            }
            rootNode = rootNode.next;
        }
        return null;
    }
    public boolean contains(V value){
        return getKey(value) != null;//if getKey found smthng it exists
    }
    public K getKey(V value){
        for (int i = 0; i < len; i++){//for every bucket
            HashNode<K, V> rootNode = chainArray[i];
            while(rootNode != null){//loop to move through array
                if (rootNode.value.equals(value)){//if we found value we return its key
                    return rootNode.key;
                }
                rootNode = rootNode.next;
            }
        }
        return null;
    }
    public void testing(){//printing number of elements in each bucket
        for (int i = 0; i < len; i++) {
            HashNode<K, V> rootNode = chainArray[i];
            int counter = 0;
            while (rootNode != null) {
                counter++;
                rootNode = rootNode.next;
            }
            System.out.println(i + " : " + counter);
        }
    }
}
```
### Code for Student Class
```
public class Student {
    private String fullName;
    private String group;

    public Student(String fullName, String group) {
        this.fullName = fullName;
        this.group = group;
    }
}
```
### Code for Testing
```
public class Test {
    private int a;
    public Test(){}
    public Test(int a){
        this.a = a;
    }
    MyHashTable table = new MyHashTable<>();
    public void test1(){
        table.put(1, "Hello");
        table.put(2, "How are you?");
        table.put(3, "Goodbye");
        table.remove(2);
        System.out.println(table.get(1));
        System.out.println(table.get(2));
        System.out.println(table.get(3));
    }
    public void test2(){
        table.put(1, "Hello");
        table.put(2, "How are you?");
        table.put(2, "Goodbye");
        System.out.println(table.contains("Hello"));
        System.out.println(table.contains("How are you?"));
        System.out.println(table.contains("Goodbye"));
    }
    public void test3(){
        table.put(1, "Hello");
        table.put(2, "How are you?");
        table.put(2, "Goodbye");
        System.out.println(table.getKey("Hello"));
        System.out.println(table.getKey("How are you?"));
        System.out.println(table.getKey("Goodbye"));
    }
    public void test4(){
        for (int i = 0; i < 10000; i++) {
            Test test10000 = new Test(i);
            Student student = new Student(String.valueOf(i), String.valueOf(i));
            table.put(test10000, student);
        }
        table.testing();
    }
}

```
