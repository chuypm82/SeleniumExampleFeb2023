package JavaSamples;

public  class Car {

	// Class Member Variables & Fields
	public String sModel;
	public int iMake;
	public int iGear;
	public int iHighestSpeed;
	String sColor;
	boolean bLeftHandDrive;
	String sTransmission;
	int iTyres;
	public int iSteering;
	public static int iWheels;
	public static int iDoors;
	public final int steering=1;
	public final int wheels=4;

	// This is the syntax to create a Constructor
	/*public Car() {
		iSteering = 1;
		iWheels = 4;
	}*/
	
	static {
		//iSteering = 1;
		iWheels = 4;
		System.out.println("This block is executed firt");
	}

	public void DisplayCharacterstics() {
		System.out.println("Model of the Car: " + sModel);
		System.out.println("Number of gears in the Car: " + iGear);
		System.out.println("Max speed of the Car: " + iHighestSpeed);
		System.out.println("Color of the Car: " + sColor);
		System.out.println("Make of the Car: " + iMake);
		System.out.println("Transmission of the Car: " + sTransmission);
	}
	
	public final void DisplayCharacterstics2() {
		System.out.println("Model of the Car: " + sModel);
		System.out.println("Number of gears in the Car: " + iGear);
		System.out.println("Max speed of the Car: " + iHighestSpeed);
		System.out.println("Color of the Car: " + sColor);
		System.out.println("Make of the Car: " + iMake);
		System.out.println("Transmission of the Car: " + sTransmission);
	}
	
	public static void DisplayStaticCharacterstics() {
        //DisplayCharacterstics();//Compile time error  //compilation error
        //System.out.println("Max speed of the Car: " + iHighestSpeed);//Compile time error 
        System.out.println("Number of Wheels in the Car: " + iWheels);
        //System.out.println("Number of Steering in the Car: " + iSteering);
        }  
	
	public void Print() {
		DisplayCharacterstics();
	}

}
