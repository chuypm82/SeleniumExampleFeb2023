package JavaAbstract;

//abstract class
abstract class abstract_gfg{ 
     abstract void myMethod();
}

//extending abstract class
class MyClass extends abstract_gfg{ 
  
  // overriding abstract method otherwise
  // code will produce error
  void myMethod(){ 
      System.out.println("GeeksforGeeks");
  }
}

public class AbstractMain {

	public static void main(String[] args) {
		MyClass obj=new MyClass();
        obj.myMethod(); 

	}

}
