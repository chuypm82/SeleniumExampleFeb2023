package JavaNonAccessMod;

//static variable
class static_gfg {
	static String s = "GeeksforGeeks";
	static int count = 0; // static makes it look like a global variable

	void myMethod() {
		count++;
		System.out.println(count);
	}
}

public class GFG_Stattic {

	public static void main(String[] args) {
		// No object required
		System.out.println(static_gfg.s); // no object needs to be instantiated

		static_gfg obj1 = new static_gfg();

		// method calling of first object
		obj1.myMethod();

		// second object creation
		static_gfg obj2 = new static_gfg();

		// method calling of second object
		obj2.myMethod();

	}

}
