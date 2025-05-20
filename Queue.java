import java.util.Scanner;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class Queue {
	Node head, tail;

	Queue() {
		head = tail = null;
	}

	boolean EmptyQ() {
		return head == null;
	}

	void addQ(int x) {
		Node newNode = new Node(x);
		if (EmptyQ()) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	int RemoveQ() {
		if (EmptyQ()) {
			throw new RuntimeException("Hang doi trong!");
		}
		int x = head.data;
		head = head.next;
		if (head == null)
			tail = null;
		return x;
	}

	void nhap() {
		int x;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("Nhap 1 so != 0 de them vao hang doi ");
			x = sc.nextInt();
			if(x==0) break;
			addQ(x);
		}
		System.out.println("Da tao hang doi thanh cong!");
	}
	void in() {
		Queue q = new Queue();
		System.out.println("Danh dach hang doi: ");
		while(!EmptyQ()) {
			int x = RemoveQ();
			System.out.print(x + " ");
			q.addQ(x);
		}
		while(!q.EmptyQ()) {
			int x = q.RemoveQ();
			addQ(x);
		}
	}
	void tong() {
		int sum = 0;
		Queue q = new Queue();
		while(!EmptyQ()) {
			int x = RemoveQ();
			sum = sum + x;
			q.addQ(x);
		}
		while(!q.EmptyQ()) {
			int x = q.RemoveQ();
			addQ(x);
		}
		System.out.println("\nTong cua hang doi la: " + sum);
	}
	void demLe() {
		Queue le = new Queue();
		int soLuongLe = 0;
		while(!EmptyQ()) {
			int x = RemoveQ();
			if(x%2!=0) {
				soLuongLe++;
			}
			le.addQ(x);
		}
		while(!le.EmptyQ()) {
			int x = le.RemoveQ();
			addQ(x);
		}
		System.out.println("\nSo phan tu le trong hang doi la: " + soLuongLe);
	}
	
	void timMax() {
		Queue max = new Queue();
		int soLonNhat = 0;
		while(!EmptyQ()){
			int x = RemoveQ();
			if(x>soLonNhat) {
				soLonNhat = x;
			}
			max.addQ(x);
		}
		while(!max.EmptyQ()) {
			int x = max.RemoveQ();
			addQ(x);
		}
		System.out.println("So lan nhat trong hang doi la: " + soLonNhat);
	}
	public static void main(String[] args) {
		Queue Q = new Queue();
		Q.nhap();
		Q.in();
		Q.tong();
		Q.in();
		Q.demLe();
		Q.in();
		Q.timMax();
		Q.in();
	}

}
