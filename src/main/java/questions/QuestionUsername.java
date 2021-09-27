package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import userinterfaces.AccountPage;

public class QuestionUsername implements Question<Boolean>{
	
	private String userName;

	public QuestionUsername(String userName) {
		this.userName = userName;
	}


	@Override
	public Boolean answeredBy(Actor actor) {
		// TODO Auto-generated method stub
		
		System.out.println("Texto encontrado: "+AccountPage.CHECK_USER.resolveFor(actor).getText());
		
		if (AccountPage.CHECK_USER.resolveFor(actor).containsText(userName)) {
			
			
			System.out.println("Usuario encontrado");
			
			return true;
			
		}else {
			
			System.out.println("Usuario no coincide");
			return false;
		}
		
	}
	
	
	public static QuestionUsername validateUrlFEnd(String userName) throws InterruptedException {
		return new QuestionUsername(userName);
	}

}
