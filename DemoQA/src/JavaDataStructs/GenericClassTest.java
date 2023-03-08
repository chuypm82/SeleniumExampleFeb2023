package JavaDataStructs;

//File GenericClassTest.java
public class GenericClassTest {
 public static void main(String []args) {
     Entry<String, String> phone = new Entry<String, String>("Alice", "123456789");
     Entry<String, Integer> height = new Entry<String, Integer>("Alice", 167);
     System.out.println("Phone number: " + phone);
     System.out.println("Height: " + height);

     Entry<String, Boolean> isMarried = new Entry<String, Boolean>("Alice", true);
     if (isMarried.getValue()) System.out.println(isMarried.getKey() + " is married.");
     else System.out.println(isMarried.getKey() + " is not married.");
 }
}
