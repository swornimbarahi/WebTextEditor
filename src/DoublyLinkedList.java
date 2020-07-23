public class DoublyLinkedList {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        public ListNode() {}

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode prev, ListNode next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    ListNode head;
    ListNode tail;
    int size;

    public DoublyLinkedList() {
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public DoublyLinkedList(int[] nums) {
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
        size = 0;
        ListNode runner = head;
        for (int n: nums){
            ListNode temp = new ListNode(n);
            temp.next = runner.next;
            runner.next.prev = temp;
            runner.next = temp;
            temp.prev = runner;
            runner = runner.next;
            size++;
        }
    }

    public void addAtIdx(int val, int idx) {
        if (idx < 0 || idx > size)
            throw new IllegalStateException("Index out of bounds.");
        ListNode runner = head;
        while (idx > 0) {
            runner = runner.next;
            idx--;
        }
        ListNode temp = new ListNode(val, runner, runner.next);
        runner.next.prev = temp;
        runner.next = temp;
        size++;
    }

    public void addToHead(int val) {
        addAtIdx(val, 0);
    }

    public void addToTail(int val) {
        ListNode temp = new ListNode(val);
        temp.next = tail;
        temp.prev = tail.prev;
        temp.prev.next = temp;
        tail.prev = temp;
        size++;
    }

    public int getHead() {
        if (size == 0)
            throw new IllegalStateException("List is empty.");
        return head.next.val;
    }

    public int getTail() {
        if (size == 0)
            throw new IllegalStateException("List is empty.");
        return head.prev.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int get(int idx) {
        if (idx < 0 || idx >= size)
            throw new IllegalStateException("Index out of bounds.");
        ListNode runner = head;
        while (idx > 0) {
            idx--;
            runner = runner.next;
        }
        return runner.next.val;
    }

    public void removeAtIdx(int idx) {
        if (idx < 0 || idx >= size)
            throw new IllegalStateException("Index out of bounds.");
        ListNode runner = head;
        while (idx > 0) {
            idx--;
            runner = runner.next;
        }
        runner.next = runner.next.next;
        runner.next.prev = runner;
        size--;
    }

    public void removeHead() {
        removeAtIdx(0);
        size--;
    }

    public void removeTail() {
        if (size == 0)
            throw new IllegalStateException("Index out of bounds.");
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        size--;
    }

    public void print() {
        ListNode runner = head;
        int idx = 0;
        System.out.print("[ ");
        while (idx < size) {
            runner = runner.next;
            System.out.print(runner.val);
            idx++;
            if (runner.next.next != null)
                System.out.print(", ");
        }
        System.out.println("]");
    }
}
