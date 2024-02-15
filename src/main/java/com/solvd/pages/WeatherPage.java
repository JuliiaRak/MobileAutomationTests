package com.solvd.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class WeatherPage extends AbstractPage {

    @FindBy(xpath = "//android.view.View[@content-desc='Weather Forecast']")
    ExtendedWebElement weatherForecastTitle;

    public WeatherPage(WebDriver driver) {
        super(driver);
    }

    public boolean isWeatherForecastTitlePresent(){
        return weatherForecastTitle.isPresent();
    }
}
