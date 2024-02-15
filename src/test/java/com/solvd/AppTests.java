package com.solvd;

import com.solvd.pages.HomePage;
import com.solvd.pages.RecipePage;
import com.solvd.pages.WeatherPage;
import com.solvd.pages.YourPlacesPage;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTests extends AbstractTest implements IMobileUtils {

    private static final String APP = "com.floor57.alcoweather";
    private static final String PLACE_NAME = "Lviv";

    @BeforeTest
    public void startAppBeforeTest(){
        startApp(APP);
    }

    @AfterTest
    public void terminateAppAfterTest(){
        terminateApp(APP);
    }

    @Test(description = "Сheck whether the “Weather forecast” page is opened after clicking the central image with place name")
    public void verifyWeatherForecastPageOpening() {
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isHeyHomeTextPresent(), "Home page is not opened");

        WeatherPage weatherPage = homePage.clickOnLocationWeatherImage();
        Assert.assertTrue(weatherPage.isWeatherForecastTitlePresent(), "Weather page is not opened");
    }

    @Test(description = "Check that all cocktail page display essential information that is visible to the user")
    public void verifyRecipePageOpening() {
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isHeyHomeTextPresent(), "Home page is not opened");

        RecipePage recipePage = homePage.clickOnFirstCocktailImage();
        Assert.assertTrue(recipePage.isRecipePageOpened(), "Recipe page is not opened");
    }

    @Test(description = "Check that after clicking on a 'Surprise me' button in bottom of the page, page with recipe will open")
    public void verifySurpriseMeOpening() {
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isHeyHomeTextPresent(), "Home page is not opened");

        RecipePage recipePage = homePage.clickOnSurpriseMeButton();
        Assert.assertTrue(recipePage.isRecipePageOpened(), "Recipe page is not opened");
    }

    @Test(description = "Check that user can view all places by clicking 'Manage places' button after clicking on a gear button in upper right corner")
    public void verifyYourPlacesOpening() {
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isHeyHomeTextPresent(), "Home page is not opened");

        homePage.clickOnGearButton();
        YourPlacesPage yourPlacesPage = homePage.clickOnManagePlaces();
        Assert.assertTrue(yourPlacesPage.isYourPlacesTitlePresent(), "Your places page is not opened");
    }

    @Test(description = "Attempt to add new existing place in 'Your places' page will be possible")
    public void verifySuccessfulAddingNewPlace() {
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isHeyHomeTextPresent(), "Home page is not opened");

        homePage.clickOnGearButton();
        YourPlacesPage yourPlacesPage = homePage.clickOnManagePlaces();
        Assert.assertTrue(yourPlacesPage.isYourPlacesTitlePresent(), "Your places page is not opened");

        HomePage newHomePage = yourPlacesPage.addNewPlace(PLACE_NAME);
        Assert.assertTrue(newHomePage.isHeyHomeTextPresent(), "Home page is not opened");
        Assert.assertTrue(newHomePage.isAddedPlaceNamePresent(PLACE_NAME), "Added place name is not present on a page");
    }
}
