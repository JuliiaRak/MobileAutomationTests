package com.solvd.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class YourPlacesPage extends AbstractPage {

    @FindBy(xpath = "//android.view.View[@content-desc='Your Places']")
    ExtendedWebElement yourPlacesTitle;

    @FindBy(xpath = "//android.widget.EditText")
    ExtendedWebElement placeInput;

    @FindBy(xpath = "//android.view.View[contains(@content-desc, '%s')]")
    ExtendedWebElement exactFirstPlace;

    public YourPlacesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isYourPlacesTitlePresent() {
        return yourPlacesTitle.isPresent();
    }

    public HomePage addNewPlace(String placeName) {
        placeInput.click();
        placeInput.type(placeName);
        waitUntil(ExpectedConditions.visibilityOf(exactFirstPlace.format(placeName).getElement()), 10);
        exactFirstPlace.format(placeName).click();
        return new HomePage(getDriver());
    }
}
