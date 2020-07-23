public class SinglyLinkedList {
    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {}

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    ListNode head;
    int size;

    public SinglyLinkedList() {
        head = new ListNode();
        size = 0;
    }

    public SinglyLinkedList(int[] nums) {
        head = new ListNode();
        ListNode runner = head;
        for (int n: nums) {
            runner.next = new ListNode(n);
            runner = runner.next;
            size++;
        }
    }

    public void addAtIdx(int val, int idx) {
        if (idx > size || idx < 0)
            throw new IllegalStateException("Index out of bounds.");
        ListNode runner = head;
        ListNode temp = new ListNode(val);
        while (idx > 0) {
            runner = runner.next;
            idx--;
        }
        temp.next = runner.next;
        runner.next = temp;
        size++;
    }

    public void addToHead(int val) {
        addAtIdx(val, 0);
    }

    public void append(int val) {
        addAtIdx(val, size);
    }

    public void removeAtIdx(int idx) {
        if (idx >= size || idx < 0)
            throw new IllegalStateException("Index out of bounds.");
        ListNode runner = head;
        while (idx > 0) {
            runner = runner.next;
            idx--;
        }
        if (runner.next != null)
            runner.next = runner.next.next;
        size--;
    }

    public void removeFromHead() {
        removeAtIdx(0);
    }

    public void removeFromEnd() {
        removeAtIdx(size - 1);
    }

    public int size() {
        return size;
    }

    public int get(int idx) {
        if (idx >= size || idx < 0)
            throw new IllegalStateException("Index out of bounds.");
        ListNode runner = head;
        while (idx > 0) {
            runner = runner.next;
            idx--;
        }
        return runner.next.val;
    }

    public void print(){
        ListNode runner = head;
        int idx = 0;
        System.out.print("{");
        while (idx < size) {
            idx++;
            runner = runner.next;
            System.out.print(runner.val);
            if (runner.next.next != null)
                System.out.print(", ");
        }
        System.out.println("]");
    }
}
