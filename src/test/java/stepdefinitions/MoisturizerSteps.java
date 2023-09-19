package stepdefinitions;

import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Lorsque;
import pages.MoisturizerPage;

public class MoisturizerSteps {

    MoisturizerPage moisturizerPage = new MoisturizerPage(StepsConfiguration.getDriver());

    @Et("Je check si je me suis redirigé vers la page Moisturizers")
    public void jeCheckSiJeMeSuisRedirigéVersLaPageMoisturizers() {
        moisturizerPage.checkCurrentPage();
    }

    @Et("Je check que chaque produit est affiché avec son titre et son prix")
    public void jeCheckQueChaqueProduitEstAffichéAvecSonTitreEtSonPrix() {
        moisturizerPage.checkTitleAndPrice();
    }

    @Et("J’ajoute le premier produit à mon panier")
    public void jAjouteLePremierProduitÀMonPanier() {
        moisturizerPage.addFirstProduct();
    }

    @Et("Je check si le produit ajouté correspond bien à mon produit \\(titre , prix , total)")
    public void jeCheckSiLeProduitAjoutéCorrespondBienÀMonProduitTitrePrixTotal() throws InterruptedException {
        moisturizerPage.checkProductMatching();
    }
}
