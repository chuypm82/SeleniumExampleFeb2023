package JavaOOPSamples;

public class VehiclesTest {

	public static void main(String[] args) {

		Car personalCar = new Car(4);
		personalCar.setLicensePlate("PERSONAL-BN123");
		System.out.println(personalCar.toString());
		
		SportsCar sportsTeam = new SportsCar(2,300);
		sportsTeam.setLicensePlate("SPORTS-123");
		System.out.println(sportsTeam);

	}

}
