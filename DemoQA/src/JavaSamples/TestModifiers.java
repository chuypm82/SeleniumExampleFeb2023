package JavaSamples;

public class TestModifiers {

	public static void main(String[] args) {

		Car Toyota = new Car();
		
		Toyota.sModel="Camry";
		Toyota.iHighestSpeed=230;
		Car.iDoors=2;
		
		
		
        System.out.println("Model of the Car: " + Toyota.sModel);
        System.out.println("Max speed of the Car: " + Toyota.iHighestSpeed);
        System.out.println("Number of Wheels in the Car: " + Toyota.iWheels); //Compile Time Error
        System.out.println("Number of Wheels in the Car: " + Car.iWheels);
        //System.out.println("Number of Steering in the Car: " + Car.iSteering);
        System.out.println("Number of Steering in the Car: " + Toyota.iSteering);
        System.out.println("Number of Doors in the Car: " + Car.iDoors);
	}

}
