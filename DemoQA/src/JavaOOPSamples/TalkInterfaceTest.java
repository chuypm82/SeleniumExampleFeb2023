package JavaOOPSamples;

interface Talk {
	//int index=10;
	String talk();
	
}

class Cat1 implements Talk {
	public String talk() {
		return "Meow!";
	}
}

class Radio implements Talk {
	public String talk() {
		return "This is the Voice of America!";
	}
}

public class TalkInterfaceTest {

	public static void main(String[] args) {
		Talk[] things = new Talk[2];
		Cat1 c = new Cat1();
		Radio r = new Radio();
		things[0] = c;
		things[1] = r;
		for (int i = 0; i < things.length; i++) {
			System.out.println("Things[" + i + "]: " + things[i].talk());
		}
		//System.out.println(c.getMessage("Hola"));
		//System.out.println("Index = " + c.index);
	}

}
