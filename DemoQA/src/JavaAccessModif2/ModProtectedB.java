// Java program to illustrate
// protected modifier
package JavaAccessModif2;

import JavaAccessModif1.ModProtectedA;

public class ModProtectedB extends ModProtectedA{
	public static void main(String args[])
	{
		ModProtectedB obj = new ModProtectedB();
	    obj.display();
	}
}
