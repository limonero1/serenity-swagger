package swaglabs.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import swaglabs.tasks.cart.AddToCart;
import swaglabs.tasks.cart.CartContents;
import swaglabs.tasks.cart.CartCount;
import swaglabs.tasks.navigation.Navigate;

import java.util.List;

public class CatalogStepDefinitions {

    @And("{actor} is browsing the catalog")
    public void IsBrowsingTheCatalog(Actor actor) {
        actor.attemptsTo(
                Navigate.toTheCatalogPage()
        );
    }
List<String> cartItems;
    @When("{actor} adds the following items to the cart:")
    public void addsTheFollowingItemsToTheCart(Actor actor, List<String> items) {
        cartItems = items;
        for (String itemName : items) {
            actor.attemptsTo(AddToCart.item(itemName));
        }
        System.out.println("el valor de items es" + items);
    }

    @Then("the shopping cart count should be {int}")
    public void theShoppingCartCountShouldBe(int expectedCount) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(CartCount.currentlyDisplayed()).isEqualTo(expectedCount)

        );
    }
    @And("the items should appear in the cart")
    public void theItemsShouldAppearInTheCart() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Navigate.toTheShoppingCart(),
                Ensure.that(CartContents.currentDisplayed()).containsElementsFrom(cartItems)

        );

            }

}