package userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class AccountPage {
	
	public static final Target CHECK_USER = Target.the("Validate username").located(By.xpath("//div[@class='author-bio']"));

}
