package ru.spb.gu.eservice.pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class MainPage {
    public WebDriver driver;
    public WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    @FindBy (xpath = "//*[@id=\"menu-office-personal-heading\"]/h4/a")
        private WebElement linkPersonalData;
    @FindBy (xpath = "//*[@id=\"menu-office-accordion\"]/div[4]/div[1]/h4/a")
        private WebElement linkApplication;

    @FindBy (xpath = "//*[@id=\"uo-item-el\"]/div/button")
        private WebElement buttonEditPersonalDate;

    @FindBy (xpath = "/html/body/div[4]/div[2]/div/div/div/div/div[4]/button[1]")
        private WebElement buttonYes;

    @FindBy (xpath = "//*[@id=\"uo-user-applications-apphistory-table\"]/tbody/tr/td[1]/a")
            private WebElement numberOfApplication;

    By divTabContent = By.id("tab_content");
    By divPersonalDate = By.id("uo-item-el");
    By divPreloader = By.id("preloader-div");
    By divcСonfirmation = By.xpath("//*[contains(text(), 'Обратите внимание!')]");
    By listOfApplication = By.id("uo-item-el");


    public void controlOpenMainPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(divTabContent));
    }

    public void openPersonalData(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(divPreloader));
        linkPersonalData.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(divPersonalDate));
    }

    public void editPersonalDate(){
        buttonEditPersonalDate.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(divcСonfirmation));
        String originalWindow = driver.getWindowHandle();
        final Set<String> oldWindowsSet = driver.getWindowHandles();
        buttonYes.click();

        /* Работа с дескриптором( переключение между окон, позже вынести в отдельную процедуру(класс)*/
        String newWindow = (new WebDriverWait(driver, 30))
                .until(new ExpectedCondition<String>() {
                           public String apply(WebDriver driver) {
                               Set<String> newWindowsSet = driver.getWindowHandles();
                               newWindowsSet.removeAll(oldWindowsSet);
                               return newWindowsSet.size() > 0 ?
                                       newWindowsSet.iterator().next() : null;
                           }
                       }
                );
        driver.switchTo().window(newWindow);

        System.out.println("New window title: " + driver.getTitle());
//        driver.close();

//        driver.switchTo().window(originalWindow);
//        System.out.println("Old window title: " + driver.getTitle());

        /* Работа с дескриптором( переключение между окон, позже вынести в отдельную процедуру(класс)*/
    }

    public void controlOpenListOfApplication(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(listOfApplication));
    }

    public void openApplication(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(divPreloader));
        linkApplication.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(divPreloader));
        controlOpenListOfApplication();
        numberOfApplication.click();
    }


}
