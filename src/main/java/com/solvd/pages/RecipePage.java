package com.solvd.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RecipePage extends AbstractPage {

    @FindBy(xpath = "//android.view.View[@content-desc='Ingredients']")
    ExtendedWebElement ingredients;

    @FindBy(xpath = "//android.view.View[@content-desc='Preparation']")
    ExtendedWebElement preparation;

    public RecipePage(WebDriver driver) {
        super(driver);
    }

    public boolean isRecipePageOpen(){
        return ingredients.isPresent() && preparation.isPresent();
    }
}
