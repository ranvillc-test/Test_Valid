package task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import userinterfaces.HomePage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;


public class Looks_Task implements Task{
	
	public static String email;
	public static String pw;

	@Override
	public <T extends Actor> void performAs(T actor) {
		// TODO Auto-generated method stub
		
		actor.attemptsTo(
				
				Scroll.to(HomePage.SCROLL_FE)
				
				);
		
		
		String text = HomePage.CREDENTIAL_FE.resolveFor(actor).getText(); // Capturar credenciales
		// System.out.println("Texto encontrado: "+text);

		String[] credentials = text.split("\\n");

		for (String string : credentials) { // depurar credenciales
			if (string.contains("Email")) {
				String[] var = string.split(" ");
				this.email = var[1];
			} else if (string.contains("Password")) {
				String[] var = string.split(" ");
				this.pw = var[1];
			}
		}

		// System.out.println("Username: "+username);
		// System.out.println("Passw: "+ password);
		
	}
	
	
	public static Performable s_Credential() {
		return instrumented(Looks_Task.class);
	}



}
