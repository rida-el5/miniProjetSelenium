package stepdefinitions;

import Constants.PurchasingInformation;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import pages.ShoppingCart;

public class ShoppingCartSteps {
    ShoppingCart shoppingCart = new ShoppingCart(StepsConfiguration.getDriver());

    PurchasingInformation purchasingInformation = new PurchasingInformation();

    @Et("Je check que le panier contient un item")
    public void jeCheckQueLePanierContientUnItem() {
        shoppingCart.checkShoppingCart();
    }

    @Et("Je clique sur carte")
    public void jeCliqueSurCarte() {
        shoppingCart.clickOnShoppingCart();
    }

    @Et("Je clique sur le bouton Pay with card")
    public void jeCliqueSurLeBoutonPayWithCard() {
        shoppingCart.clickPayWithCart();
    }

    @Et("Je check si la popup Stripe.com s’affiche")
    public void jeCheckSiLaPopupStripeComSAffiche() {
        shoppingCart.checkPopup();
    }

    @Et("Je saisis les informations nécessaires pour compléter l’achat \\(email, card number , date , cvc, zip code)")
    public void jeSaisisLesInformationsNécessairesPourCompléterLAchatEmailCardNumberDateCvcZipCode() {
        shoppingCart.fillForm(purchasingInformation.getEmail(),
                purchasingInformation.getCardNumber(),
                purchasingInformation.getDate(),
                purchasingInformation.getCvc());
    }

    @Et("Je clique sur le bouton pay iner")
    public void jeCliqueSurLeBoutonPayIner() {
        shoppingCart.clickPay();
    }

    @Alors("Je check si le message Your payment was successful. You should receive a follow-up call from our sales team est bien affiché")
    public void jeCheckSiLeMessageYourPaymentWasSuccessfulYouShouldReceiveAFollowUpCallFromOurSalesTeamEstBienAffiché() {
        shoppingCart.checkConfirmationMessage();
    }
}
