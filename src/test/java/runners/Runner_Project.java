package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		
		features= {"src/test/resources/features/reserva.feature"},
		glue= "stepsdefinitions",
		tags = {"@tag1,@tag2"}
		
		
		)
public class Runner_Project {
	
	

}
