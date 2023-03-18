import org.testng.annotations.Test;

public class DependsOnTestMultiple {

	@Test
	public void OpenBrowser() {
		System.out.println("The browser is opened");
	}
	
	@Test(dependsOnMethods = { "SignIn", "OpenBrowser" })
	public void LogOut() {
		System.out.println("The user logged out successfully");
	}

	@Test
	public void SignIn() {
		System.out.println("User has signed in successfully");
	}
}