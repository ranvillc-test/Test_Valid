package stepsdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.QuestionHome;
import userinterfaces.HomePage;

public class Home_Step {
	
	private String nActor;
	private HomePage homePage;

	
	@Before 
	public void setUp() {
		OnStage.setTheStage(new OnlineCast());
	}
	
	
	
	@Given("^the user (.*) is on the browser$")
	public void on_Broswer(String nActor) {

		this.nActor=nActor;
	}


	@When("^the user enters the home page$")
	public void enters_Home_Page() {
		
		theActorCalled(nActor).attemptsTo(
				
				Open.browserOn(homePage)
				
				);
		
	}
	

	@Then("^the user validates that he is on the home page (.*)$")
	public void validate_Home_Page(String title) throws InterruptedException {
		
		theActorInTheSpotlight().should(GivenWhenThen.seeThat(
				
				QuestionHome.validateTitle(title))
				
				);
		
	}
	
	
	

}
