package JavaNonAccessMod;
//This class is final
final class final_gfg {
	String s1 = "geek1";
}
/*
class extended_gfg extends final_gfg {  // we can not inherit from final

	String s2 = "geek2";
}
*/
public class GFG_Final {
	public static void main(String[] args) {
		// creating object
		//extended_gfg obj = new extended_gfg(); 

		final_gfg obj = new final_gfg();
				
		System.out.println(obj.s1);
		//System.out.println(obj.s2);
	}
}
