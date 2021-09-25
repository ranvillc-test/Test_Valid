package questions;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class QuestionUrlFEnd implements Question {

	private String url;
	private String currentUrl;

	public QuestionUrlFEnd(String url) {
		this.url = url;
	}

	@Override
	public Object answeredBy(Actor actor) {
		// TODO Auto-generated method stub

		WebDriver driver = BrowseTheWeb.as(actor).getDriver();

		currentUrl = driver.getCurrentUrl();

		// System.out.println("Current URL: "+currentUrl);
		// System.out.println("validate URL: "+url);

		if (currentUrl.equals(url)) {

			return true;
		} else {
			return false;
		}

	}

	public static QuestionUrlFEnd validateUrlFEnd(String url) throws InterruptedException {
		return new QuestionUrlFEnd(url);
	}

}
