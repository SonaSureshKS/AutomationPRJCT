package testPackage;

import org.testng.annotations.Test;

import pagePackage.PracticeFormPage;

public class TestClass extends BaseTest {
	
	@Test
	public void practiceFormTest() throws InterruptedException {
		PracticeFormPage PracticeFormPage=new PracticeFormPage(driver);
		
		 PracticeFormPage.fillPersonDetails("sona", "suresh", "sonasuresh@gmail.com", "9644005335");
		 
		 PracticeFormPage.selectDateOfBirth("July", "1999", "22");
		 
		 PracticeFormPage.enterSubjects("Physics");
		 
		 PracticeFormPage.selectHobbies();
		 
		 PracticeFormPage.uploadPicture("C:\\Users\\akash\\Downloads\\photo.jpg");
		 
		 PracticeFormPage.enterAddress("Kollatt(H),P.O.Azhicode jetty,Thrissur,PIN 680666");
		 
		 PracticeFormPage.selectStateAndCity();
		 
		 PracticeFormPage.submitForm();
		 Thread.sleep(3000);
	
		 
		 
	}

}
