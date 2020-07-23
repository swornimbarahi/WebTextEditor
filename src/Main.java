public class Main {

    public static void main(String[] args) {
//        throw new UnsupportedOperationException();
        SinglyLinkedList ll = new SinglyLinkedList(new int[]{1,2,3,4,5});
        ll.print();
        System.out.println(ll.get(2));
        ll.append(6);
        ll.addToHead(0);
        ll.print();
        ll.removeAtIdx(4);
        ll.print();
        ll.addAtIdx(4, 4);
        ll.print();
    }
}
