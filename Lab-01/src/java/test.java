package java;

public class test {
    public static void main(String[] args) throws Exception {
        Runnable task = () -> System.out.println("Hello, World!");
        task.run();
    }
}
