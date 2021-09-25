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
import questions.QuestionHome;
import questions.QuestionUrlFEnd;
import task.Click_FE_Task;
import task.Looks_Task;
import userinterfaces.HomePage;

public class Login_Step {

	private String nActor;
	private HomePage homePage;
	private String username;
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

				Looks_Task.s_Credential()

		); // Buscar las credenciasles

		String text = HomePage.CREDENTIAL_FE.resolveFor(theActorCalled(nActor)).getText(); // Capturar credenciales
		// System.out.println("Texto encontrado: "+text);

		String[] credentials = text.split("\\n");

		for (String string : credentials) { // depurar credenciales
			if (string.contains("Email")) {
				String[] var = string.split(" ");
				username = var[1];
			} else if (string.contains("Password")) {
				String[] var = string.split(" ");
				password = var[1];
			}
		}

		// System.out.println("Username: "+username);
		// System.out.println("Passw: "+ password);

	}

	@When("^the user enters the Front-End Home Page (.*)$")
	public void enters_Front_End_Home_Page(String url) throws InterruptedException {

		theActorCalled(nActor).attemptsTo(

				Click_FE_Task.c_Front_End()

		);

		theActorInTheSpotlight().should(GivenWhenThen.seeThat(

				QuestionUrlFEnd.validateUrlFEnd(url))

		);

	}

	@When("^the user enters credentials and logs in$")
	public void log_In_Front_End_Home_Page() throws InterruptedException {

		System.out.println("pending to validate");
	}

	@Then("^the user validates that the username (.*) on the user home page$")
	public void validate_Username(String username) throws InterruptedException {

		System.out.println("pending to validate");

	}

}
