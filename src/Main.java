public class Main {

    public static void main(String[] args) {
//        throw new UnsupportedOperationException();
        DoublyLinkedList ll = new DoublyLinkedList(new int[]{1,2,3,4,5});
        ll.print();
        System.out.println(ll.get(2));
        ll.addToTail(6);
        ll.addToHead(0);
        ll.print();
        ll.removeAtIdx(4);
        ll.print();
        ll.addAtIdx(4, 4);
        ll.print();
    }
}
