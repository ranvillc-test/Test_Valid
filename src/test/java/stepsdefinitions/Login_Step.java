package stepsdefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.QuestionUrlFEnd;
import questions.QuestionUsername;
import task.FrontEndPage_Task;
import task.Login_Task;
import task.Looks_Task;
import userinterfaces.HomePage;

public class Login_Step {

	private String nActor;
	private HomePage homePage;
	private String email;
	private String password;

	@Before
	public void setUp() {
		OnStage.setTheStage(new OnlineCast());
	}

	@Given("^the user (.*) is in the home page$")
	public void the_HomePage(String nActor) {

		this.nActor = nActor;

		theActorCalled(nActor).attemptsTo(

				Open.browserOn(homePage)

		);
	}

	@When("^the user looks for option Front-End Home Page$")
	public void option_Front_End_Home_Page() throws InterruptedException {

		theActorCalled(nActor).attemptsTo(

				Looks_Task.s_Credential());

		this.email = Looks_Task.email;
		this.password = Looks_Task.pw;

	}

	@SuppressWarnings("unchecked")
	@When("^the user enters the Front-End Home Page (.*)$")
	public void enters_Front_End_Home_Page(String url) throws InterruptedException {

		theActorCalled(nActor).attemptsTo(

				FrontEndPage_Task.c_Front_End()

		);

		theActorInTheSpotlight().should(GivenWhenThen.seeThat(

				QuestionUrlFEnd.validateUrlFEnd(url)

		));

	}

	@When("^the user enters credentials and logs in$")
	public void log_In_Front_End_Home_Page() throws InterruptedException {

		theActorCalled(nActor).attemptsTo(Login_Task.send_Credentials(email, password));

	}

	@Then("^the user validates that the username (.*) on the user home page$")
	public void validate_Username(String username) throws InterruptedException {
		
		

		theActorInTheSpotlight().should(GivenWhenThen.seeThat(

				QuestionUsername.validateUrlFEnd(username)

		));
		
	}

}
