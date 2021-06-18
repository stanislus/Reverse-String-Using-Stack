class ArrayStack <T> {
	private final int  DEFAULT_SIZE = 10;
	private int top;
	private T[] stack;
	
	//Increases the size of the stack when it is full by 
	//doubling the original size.
	private void expandCapacity()
	{
		T[] larger = (T[])(new Object[stack.length*2]);

		for (int index=0; index < stack.length; index++)
			larger[index] = stack[index];
		stack = larger;
	}
	
	// Creates stack of default size.
	public ArrayStack() {
		top = 0;
		stack = (T[])(new Object[DEFAULT_SIZE]);
	}
	
	//Creates stack of user defined size.
	public ArrayStack(int size) {
		top = 0;
		stack = (T[])(new Object[size]);
	}
	
	//Adds element into the top of the stack.
	public void push(T element) {
		if(size() == stack.length) {
			expandCapacity();
		}
		stack[top] = element;
		top++;
	}

	//Returns top element in the stack then decrements size of the stack.
	public T pop() throws Exception {
		if (!isEmpty()) {
			top--;
			T value = stack[top];
			stack[top] = null;
			return value;
		}
		throw new Exception("Stack is Empty");
	}
	
	//Returns the top element in the Stack without altering the contents of the stack.
	public T peek() throws Exception {
		while (!isEmpty()) {
			top--;
			T value = stack[top];
			top++;
			return value;
		}
		throw new Exception("Stack is Empty");
	}
	//Checks whether the stack is empty
	public boolean isEmpty() {
		return (top == 0);
	}
	
	//Returns the size of the stack.
	public int size() {
		return top;
	}
	
	//Prints String Output of the contents of the Stack.
	public String toString()
	{
		String result = "";
		for (int index=0; index < top; index++) {
			result = result + stack[index].toString() + "\n";
			}
		return result;
	}
	
	//Method which reverses a string using the Stack Data Structure.
	public static String reverse(String str) throws Exception {
		char[] charArr = str.toCharArray();
		int size = charArr.length;
		ArrayStack stack = new ArrayStack(size);

		int index;
		for(index = 0; index < size; ++index) {
			stack.push(charArr[index]);
		}

		for(index = 0; index < size; ++index) {
			charArr[index] = (char) stack.pop();
		}
		return String.valueOf(charArr);
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String str = "Hello, How are you ?";
		System.out.println(ArrayStack.reverse(str));
	}

}
