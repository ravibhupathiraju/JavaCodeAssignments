//Stack program..Assumes initial stack size of 5, automatically increases to 10 after 5 is reached. 
//10 is max stack size considered for this program
public class Stack {
	public static int stack[] = new int[5];
	static int stackSize = 0;
	public int size = 5;

	// This is push method to add new value to stack,
	// size will double if the stack reaches initial set size of 5
	void push(int value) {
		if (stackSize == 10) {
			System.out
					.println("You cannot add more than 10 entries into the stack");
			return;
		}

		stackSize++;
		if (this.size < stackSize) {
			int arr[] = new int[stackSize];
			for (int i = 0; i < stackSize - 1; i++) {
				arr[i] = stack[i];
			}
			stack = arr;
		}
		stack[stackSize - 1] = value;
	}

	// This is pop method to get the last added value from the stack
	public int pop() {
		if (stackSize == 0) {
			System.out.println("nothing to pop");
			return 1;
		} else {
			int val = stack[stackSize - 1];
			if (stackSize > this.size) {
				int arr[] = new int[stackSize - 1];
				for (int i = 0; i < (stackSize - 1); i++) {
					arr[i] = stack[i];
				}
				stack = arr;
			} else {
				int arr[] = new int[this.size];
				for (int i = 0; i < (stackSize - 1); i++) {
					arr[i] = stack[i];
				}
				if ((stackSize - 1) == 0) {
					int arr2[] = new int[5];
					arr2[0] = 0;
					arr = arr2;
				}
				stack = arr;
			}
			stackSize--;
			return val;
		}
	}

	// This is length method to get the length of the stack
	public int length() {
		return stackSize;
	}

	//Main method starts here
	//Included tested cases that will test thru the boundary conditions
	public static void main(String[] args) {
		Stack objStack = new Stack();
		objStack.push(0);
		objStack.push(10);
		objStack.push(20);
		objStack.push(30);
		System.out.println("pop value is " + objStack.pop()); // 30
		System.out.println("pop value is " + objStack.pop()); // 20
		System.out.println("pop value is " + objStack.pop()); // 10
		System.out.println("pop value is " + objStack.pop()); // 0
		objStack.push(0); // 0
		System.out.println("stack length is " + objStack.length());
		objStack.push(10); // 0 10
		System.out.println("stack length is " + objStack.length());
		objStack.push(20); // 0 10 20
		System.out.println("stack length is " + objStack.length());
		objStack.push(30); // 0 10 20 30
		System.out.println("stack length is " + objStack.length());
		objStack.push(40); // 0 10 20 30 40
		System.out.println("stack length is " + objStack.length());
		objStack.push(50); // 0 10 20 30 40 50
		System.out.println("stack length is " + objStack.length());
		objStack.push(60); // 0 10 20 30 40 50 60
		System.out.println("stack length is " + objStack.length());
		objStack.push(70); // 0 10 20 30 40 50 60 70
		System.out.println("stack length is " + objStack.length());
		objStack.push(80); // 0 10 20 30 40 50 60 70 80
		System.out.println("stack length is " + objStack.length());
		objStack.push(90); // 0 10 20 30 40 50 60 70 80 90
		System.out.println("stack length is " + objStack.length());
		// objStack.push(100); // 0 10 20 30 40 50 60 70 80 90 //test case for
		// max entries check
		System.out.println("stack length is " + objStack.length());
		objStack.pop(); // 0 10 20 30 40 50 60 70 80
		System.out.println("stack length is " + objStack.length());
		objStack.pop(); // 0 10 20 30 40 50 60 70
		System.out.println("stack length is " + objStack.length());
		objStack.pop();// 0 10 20 30 40 50 60
		System.out.println("stack length is " + objStack.length());
		objStack.pop();// 0 10 20 30 40 50
		System.out.println("stack length is " + objStack.length());
		objStack.pop();// 0 10 20 30 40
		System.out.println("stack length is " + objStack.length());
		objStack.pop();// 0 10 20 30
		System.out.println("stack length is " + objStack.length());
		objStack.pop();// 0 10 20
		System.out.println("stack length is " + objStack.length());
		objStack.pop();// 0 10
		System.out.println("stack length is " + objStack.length());
		objStack.pop(); // 0
		System.out.println("stack length is " + objStack.length());
		System.out.println(stackSize);
		objStack.pop();
		System.out.println("stack length is " + objStack.length());
		System.out.println("stack values are ");
		for (int i = 0; i <= (stackSize); i++) {
			System.out.println(stack[i] + " ");
		}
		objStack.pop();
		System.out.println("stack length is " + objStack.length());
		objStack.push(0);
		System.out.println("stack length is " + objStack.length());
		objStack.pop();
		System.out.println("stack length is " + objStack.length());
		System.out.println("stack values are ");
		for (int i = 0; i <= (stackSize); i++) {
			System.out.println(stack[i] + " ");
		}
		objStack.pop();
	}
}
