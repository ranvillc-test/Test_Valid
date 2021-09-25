package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class QuestionHome implements Question{
	
	private String title;

	public QuestionHome(String title) {
		// TODO Auto-generated constructor stub
		this.title= title;
	}


	@Override
	public Object answeredBy(Actor actor) {
		// TODO Auto-generated method stub
		
		//System.out.println("Browser: "+BrowseTheWeb.as(actor).getTitle());
		
		if(BrowseTheWeb.as(actor).getTitle().equals(title)) {
			
			return true;
		}
		
			return false;
	}
	
	
	public static QuestionHome validateTitle(String title) throws InterruptedException {
		return new QuestionHome(title);
	}

}
