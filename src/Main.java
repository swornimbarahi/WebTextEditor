public class Main {

    public static void main(String[] args) {
        Heap a = new Heap(50);
        a.add(4);
        System.out.println(a.peek());
        a.add(3);
        System.out.println(a.peek());
        a.add(5);
        System.out.println(a.peek());
        a.add(1);
        System.out.println(a.pop());
        System.out.println(a.pop());
        System.out.println(a.pop());
        System.out.println(a.pop());
    }
}
