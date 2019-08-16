package ru.spb.gu.eservice.pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditPersonalDateEsia {
    public WebDriver driver;
    public WebDriverWait wait;

    public EditPersonalDateEsia(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    @FindBy(xpath = "//my-common-information/div/div/div[1]/div/h3/a")
            private WebElement buttonEditEsia;

    By slogan = By.className("slogan");

    public void controlOpenEsiaPageProfileUser(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(slogan));
    }

     public void editAnyPersonaDataEsia(){
        buttonEditEsia.click();

     }
}
