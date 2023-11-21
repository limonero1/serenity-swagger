package swaglabs.tasks.cart;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.PageElement;

public class AddToCart {
    public static Performable item(String itemName) {
        return Task.where("{0} clicks on the add to cart button for" + itemName,

                Click.on(
                    /*    Button.withText("Add to cart"))*/
                     Button.withText("Add to cart").inside(PageElement.withCSSClass("inventory_item")))
                  /*    Button.located(new By.ByXPath("/html/body/div/div/div/div[2]/div[2]/div[2]/button")).inside(PageElement.containingText("inventory_item").containingText(inventory_item_name)))*/


        );

    }

}
