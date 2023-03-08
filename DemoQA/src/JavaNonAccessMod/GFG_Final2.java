package JavaNonAccessMod;

class Final_Method{
    final void myMethod(){
       System.out.println("GeeksforGeeks");
   }
}
class override_final_gfg extends Final_Method{
   /*void myMethod(){ // error ocurrs if final is added to the method in parent class
       System.out.println("Overrides GeeksforGeeks");
   }*/
}

public class GFG_Final2 {

	public static void main(String[] args) {
		override_final_gfg obj=new override_final_gfg();
        obj.myMethod();

	}

}
