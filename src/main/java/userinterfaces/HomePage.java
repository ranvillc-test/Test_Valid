package userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://phptravels.com/demo")
public class HomePage extends PageObject{
	
	public static final Target SCROLL_FE = Target.the("Search Homepage Front-End").located(By.xpath("//a[normalize-space()='Homepage - Front-End']"));
	
	public static final Target CREDENTIAL_FE = Target.the("Credentials Front-End").located(By.xpath("//div[@class='wow fadeInUp col-md-4 animated']//div[@class='col-md-12']//div[@class='row']//div[@class='col-md-12']//div[@class='row']"));
	
	public static final Target CLICK_FE = Target.the("Homepage Front-End").located(By.xpath("//small[normalize-space()='http://www.phptravels.net']"));
	
}
