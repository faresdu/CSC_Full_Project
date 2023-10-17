/****************************

CLASS: Node.java

CSC212 Data structures - Project phase I

Fall 2023

EDIT DATE:

17-10-2023

TEAM:

CSC

AUTHORS:

1- Abdulaziz Alkhonefer                            443100675
2- Abdulrahman Hamad Alaqeel                       443100920           
3- Fares Essa Alduhailan                           443102276

***********************************/

public class Node<T> {
	public T data;
	public Node<T> next;

	public Node() {
		data = null;
		next = null;
	}

	public Node(T val) {
		data = val;
		next = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

}
