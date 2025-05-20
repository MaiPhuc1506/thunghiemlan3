package linked;
import java.util.Scanner;

public class print {

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        SinglyLinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        SinglyLinkedListNode head;
        SinglyLinkedListNode tail;

        SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int data) {
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

            if (head == null) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
        }
    }

    public static void printLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();

        System.out.print("Nhap so node: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Nhap gia tri node: ");
            int value = scanner.nextInt();
            list.insertNode(value);
        }

        System.out.println("Danh sach da nhap:");
        printLinkedList(list.head);

        scanner.close();
    }
}
