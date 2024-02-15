package com.solvd.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//android.view.View[contains(@content-desc, 'Hey')]")
    ExtendedWebElement heyHomeText;

    @FindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Wind')]")
    ExtendedWebElement locationWeatherImage;

    @FindBy(xpath = "//android.widget.ImageView[contains(@content-desc, '%s')]")
    ExtendedWebElement homePlaceName;

    @FindBy(xpath = "(//android.widget.ImageView)[2]")
    ExtendedWebElement firstCocktailImage;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Surprise Me!']")
    ExtendedWebElement surpriseMeButton;

    @FindBy(xpath = "//android.widget.Button")
    ExtendedWebElement gearButton;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Manage Places']")
    ExtendedWebElement managePlacesButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHeyHomeTextPresent(){
        return heyHomeText.isPresent();
    }

    public WeatherPage clickOnLocationWeatherImage(){
        locationWeatherImage.click();
        return new WeatherPage(getDriver());
    }

    public RecipePage clickOnFirstCocktailImage(){
        firstCocktailImage.click();
        return new RecipePage(getDriver());
    }

    public RecipePage clickOnSurpriseMeButton(){
        surpriseMeButton.click();
        return new RecipePage(getDriver());
    }

    public void clickOnGearButton(){
        gearButton.click();
        waitUntil(ExpectedConditions.visibilityOf(managePlacesButton.getElement()), 10);
    }

    public YourPlacesPage clickOnManagePlaces(){
        managePlacesButton.click();
        return new YourPlacesPage(getDriver());
    }

    public boolean isAddedPlaceNamePresent(String placeName){
        return homePlaceName.format(placeName).isPresent();
    }
}
