package JavaDataStructs;

import java.util.Stack;
public class StackListDS {
	
	public static void printStack(Stack<String> words) {
		System.out.print("[");
		while(!words.empty()) {
			System.out.print(words.pop() + " ");
			}
		System.out.println("]");
	}

	public static void find(Stack<String> words, String w) {
		int idx = words.search("thrive");
		if (idx < 0) {
			System.out.println(w + " not found in this stack");
		} else {
			System.out.println("Index of [" + w + "] is: " + idx);
		}
	}

	public static void main(String[] args) {
		
		Stack<String> words = new Stack<String>();
		// append
		words.push("thrive");
		words.push("at");
		words.push("work");		
		System.out.println("Peek is: [" + words.peek() + "]");

		System.out.println("> Before pop ");
		find(words, "thrive");
		printStack(words);
		System.out.println("> After pop ");
		find(words, "thrive");
	}
}
