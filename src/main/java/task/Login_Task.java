package task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import userinterfaces.FrontEndPage;

public class Login_Task implements Task {
	
	private String email;
	private String pw;

	public Login_Task(String email, String pw) {
		this.email = email;
		this.pw=pw;
		
		System.out.println("Entro al constructor");
	}


	@Override
	public <T extends Actor> void performAs(T actor) {
		// TODO Auto-generated method stub
		
		actor.attemptsTo(
				
				Click.on(FrontEndPage.LOGIN),
				
				Enter.theValue(email).into(FrontEndPage.INPUT_EMAIL),
				Enter.theValue(pw).into(FrontEndPage.INPUT_PASSWORD),
				Click.on(FrontEndPage.BUTTON_LOGIN)
				
				
				);
		
		
		
	}
	
	
	public static Performable send_Credentials(String email, String pw) {
		return instrumented(Login_Task.class,email,pw);
	}

}
