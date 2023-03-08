package JavaAbstract;

abstract class sunstar {
    abstract void printInfo();
}
 
class employee extends sunstar {
    void printInfo() {
        String name = "avinash";
        int age = 21;
        float salary = 222.2F;
 
        System.out.println(name);
        System.out.println(age);
        System.out.println(salary);

    }
}

public class base {
	public static void main(String args[]) {
        sunstar s = new employee();
        s.printInfo();
    }
}
