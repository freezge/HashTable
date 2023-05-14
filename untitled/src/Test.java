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
