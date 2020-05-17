
public class DeliverySystem {
	
	/*This system is a simple version of the delivery locker system.
	 It uses an ArrayList to maintain the locker and uses Nodes to keep on track of the information of the packages
	 The required information to store a package are the phone number and user's name
	 User can retrieve the package by entering either the phone number or their names.
	 It uses a for loop to iterate over the entire array and find the first available space, and add the package to the position
	 Currently supported functions:
	 	
	 	Adding a package
	 	Removing a package
	 	Searching for a package*/
	
	
	private class Node{
		private String phoneNumber;
		private String userName;
		private int packageLocation;
		
		public Node(String num, String name, int location) {
			phoneNumber = num;
			userName = name;
			packageLocation = location;
		}
	}
	
	private Node[] boxes;
	private int packages = 0;
	private int MAX;
	
	public DeliverySystem(int size) {
		this.MAX = size;
		this.boxes = new Node[MAX];
		this.packages = 0;
		for (int i = 0; i < 10; i++) {
			this.boxes[i] = null;
		}
	}
	
	public String print() {
		String result = "[";
		
		for (int i = 0; i < MAX; i++) {
			if (this.boxes[i] != null) {
				result += "Phone: ";
				result += boxes[i].phoneNumber;
				result += " -";
				result += " Name: ";
				result += boxes[i].userName;
				result += " - ";
				result += (i + 1);
				result += ", ";
			}
			if (this.boxes[i] == null) {
				result += "empty, ";
			}
		}
		if (result.equals("[")) {
			result = "Oops, it seems like the cabin is empty";
			return result;
		}
		result = result.substring(0, result.length() - 2);
		result += "]";
		return result;
	}
	
	public int firstEmpty() {
		for (int i = 0; i < MAX; i++) {
			if (boxes[i] == null){
				return i;
			}
		}
		return -1;
	}
	
	public boolean add(String num, String name) {
		if (this.packages >= MAX) {
			throw new IllegalArgumentException("This cabin is full");
		}
		int locale = this.firstEmpty();
		if (locale == -1) {
			return false;
		}
		Node temp = new Node(num, name, locale);
		this.boxes[locale] = temp;
		return true;
	}
	
	public boolean remove(String number) {
		for (int i = 0; i < MAX; i++) {
			if (this.boxes[i].phoneNumber.equals(number)) {
				this.boxes[i] = null;
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
	}
	
}