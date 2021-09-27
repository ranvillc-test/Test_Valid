package userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class FrontEndPage {
	
	public static final Target LOGIN = Target.the("Option Login").located(By.xpath("//a[@class='theme-btn theme-btn-small theme-btn-transparent ml-1 waves-effect']"));
	
	public static final Target INPUT_EMAIL = Target.the("input email").located(By.xpath("//input[@placeholder='Email']"));
	
	public static final Target INPUT_PASSWORD = Target.the("input password").located(By.xpath("//input[@placeholder='Password']"));
	
	public static final Target BUTTON_LOGIN = Target.the("Button Login").located(By.xpath("//button[@class='btn btn-default btn-lg btn-block effect ladda-button waves-effect']"));
	
	public static final Target BUTTON_COOKIES = Target.the("Cookies").located(By.xpath("//button[normalize-space()='Got It']"));
	
	

}
