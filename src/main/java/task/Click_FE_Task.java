package task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import userinterfaces.HomePage;

public class Click_FE_Task implements Task{

	@Override
	public <T extends Actor> void performAs(T actor) {
		// TODO Auto-generated method stub
		
		actor.attemptsTo(
				
				Click.on(HomePage.CLICK_FE)
				
				);
		
		
		WebDriver driver = BrowseTheWeb.as(actor).getDriver();
		String firstHandle = driver.getWindowHandle();
		Set<String> allHandles = driver.getWindowHandles(); //Capturar los Handles de los tab´s
		
		for (String string : allHandles) {
			System.out.println("Handle: "+ string );
			if (!string.equals(firstHandle)) { 	  
				driver.switchTo().window(string); //De acuerdo al Handle pasar a la siguiente tab generado
				break;
			}
		}
		
		
		
	}
	
	public static Performable c_Front_End() {
		return instrumented(Click_FE_Task.class);
	}

}
