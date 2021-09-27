package questions;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import userinterfaces.FrontEndPage;


public class QuestionUrlFEnd implements Question<Boolean> {

	private String url;
	private String currentUrl;

	public QuestionUrlFEnd(String url) {
		this.url = url;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		// TODO Auto-generated method stub

		WebDriver driver = BrowseTheWeb.as(actor).getDriver();

		currentUrl = driver.getCurrentUrl();

		// System.out.println("Current URL: "+currentUrl);
		// System.out.println("validate URL: "+url);

		if (currentUrl.equals(url)) {
			
			if (FrontEndPage.BUTTON_COOKIES.resolveFor(actor).isDisplayed()) {
				
				System.out.println("Visibilizo el boton cookies");
				
				actor.attemptsTo(
						
						Click.on(FrontEndPage.BUTTON_COOKIES)
						
						);
				
			}else {System.out.println("No encontro el boton cookies");}		
			
			return true;
		} else {
			return false;
		}

	}

	public static QuestionUrlFEnd validateUrlFEnd(String url) throws InterruptedException {
		return new QuestionUrlFEnd(url);
	}

}
