package swaglabs.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import swaglabs.model.SwaplabsUser;
import swaglabs.tasks.authentication.Login;
import swaglabs.tasks.navigation.Navigate;

public class AuthenticationStepDefinitions {
    @Given("{actor} is on the login page")
    public void on_the_login_page(Actor actor) {

        actor.attemptsTo(
                Navigate.toTheLoginPage()
        );
    }
    @When("{actor} logs in with valid credentials")
    public void logs_in_with_valid_credentials(Actor actor) {

        actor.attemptsTo(
                Login.asA(SwaplabsUser.STANDARD_USER)
        );
    }

    @Given("{actor} has logged on to the application")
    public void is_logged_on(Actor actor) {
        actor.attemptsTo(
                Navigate.toTheLoginPage(),
                Login.asA(SwaplabsUser.STANDARD_USER)
        );
    }


    @Then("{actor} should be presented with the product catalog")
    public void should_be_presented_with_the_product_catalog(Actor actor) {
        actor.attemptsTo();
        Ensure.that(Text.of(".title")).isEqualTo("Products");
    }
}
