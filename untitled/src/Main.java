public class Main {
    public static void main(String[] args) {
        MyHashTable<Integer, String> table = new MyHashTable<>();
        table.put(1, "hello");
        System.out.println(table.contains("helo"));
    }
}