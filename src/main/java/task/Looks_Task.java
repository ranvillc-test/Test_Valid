package task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import userinterfaces.HomePage;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class Looks_Task implements Task{

	@Override
	public <T extends Actor> void performAs(T actor) {
		// TODO Auto-generated method stub
		actor.attemptsTo(
				
				Scroll.to(HomePage.SCROLL_FE)
				
				);
		
	}
	
	
	public static Performable s_Credential() {
		return instrumented(Looks_Task.class);
	}


}
