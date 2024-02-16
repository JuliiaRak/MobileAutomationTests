package com.solvd.pages;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RecipePage extends AbstractPage implements IMobileUtils {

    @FindBy(xpath = "//android.view.View[@content-desc='Ingredients']")
    ExtendedWebElement ingredientsViewTitle;

    @FindBy(xpath = "//android.view.View[@content-desc='Preparation']")
    ExtendedWebElement preparationViewTitle;

    public RecipePage(WebDriver driver) {
        super(driver);
    }

    public boolean isRecipePageOpened() {
        boolean ingredientsViewTitlePresent = ingredientsViewTitle.isPresent();
        scrollDown();
        boolean preparationViewTitlePresent = preparationViewTitle.isPresent();
        return ingredientsViewTitlePresent && preparationViewTitlePresent;
    }

    public void scrollDown() {
        int height = getDriver().manage().window().getSize().height;
        int width = getDriver().manage().window().getSize().width;
        int startX = (int) (width * 0.5);
        int startY = (int) (height * 0.8);
        int endY = (int) (height * 0.3);
        swipe(startX, startY, startX, endY, 1500);
    }
}
