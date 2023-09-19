package stepdefinitions;

import configuration.ChromeConfiguration;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Lorsque;
import io.cucumber.java.fr.Soit;
import pages.HomePage;

public class HomeSteps{
    HomePage homePage = new HomePage(StepsConfiguration.getDriver());

    @Soit("Je me connecte au page home")
    public void jeMeConnecteAuSiteHttpsWeathershopperPythonanywhereCom() {
        homePage.checkCurrentPage();
    }

    @Lorsque("Je clique sur le bouton Buy moisturizers")
    public void jeCliqueSurLeBoutonBuyMoisturizers() {
        homePage.clickBuyMoisturizer();
    }
}
