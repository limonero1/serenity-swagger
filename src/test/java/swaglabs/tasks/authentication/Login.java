package swaglabs.tasks.authentication;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ui.Button;
import swaglabs.model.SwaplabsUser;

public class Login {
    public static Performable asA(SwaplabsUser standardUser) {
        return Task.where("{0} logs in as a " + standardUser,
                Enter.theValue("standard_user").into("#user-name"),
                Enter.theValue("secret_sauce").into("#password"),
                Click.on(Button.withNameOrId("login-button"))
        );
    }
}
