package JavaDataStructs;

//An Enum class
enum Day {
	SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
}

//Driver class that contains an object of "day" and
//main().
class TestDay {
	Day day;

	// Constructor
	public TestDay(Day day) {
		this.day = day;
	}

	// Prints a line about Day using switch
	public void dayIsLike() {
		switch (day) {
		case MONDAY:
			System.out.println("Mondays are bad.");
			break;
		case FRIDAY:
			System.out.println("Fridays are better.");
			break;
		case SATURDAY:
		case SUNDAY:
			System.out.println("Weekends are best.");
			break;
		default:
			System.out.println("Midweek days are so-so.");
			break;
		}
	
	}
}

public class EnumerationSample2 {

	public static void main(String[] args) {

		String str = "FRIDAY";
		TestDay t1 = new TestDay(Day.valueOf(str));
		t1.dayIsLike();
		System.out.println(t1.day.toString().toLowerCase());
	}
}
