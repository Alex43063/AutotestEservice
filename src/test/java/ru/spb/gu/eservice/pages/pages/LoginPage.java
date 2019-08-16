package ru.spb.gu.eservice.pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.spb.gu.eservice.pages.EntryPoints;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class LoginPage {
    public WebDriver driver;
    public WebDriverWait wait;
    private final String SNILSPROPRED = "148-827-461 06";
    private final String SNILSTEST = "000-000-600 02";
    private final String PASSWORDPROPRED = "Alex_198914";
    private final String PASSWORDTEST = "11111111";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    @FindBy (xpath = "//a[contains(text(), 'Войти')]")
            private WebElement loginButtonWithEsia;
    @FindBy (xpath = "//a[contains(text(), 'СНИЛС')]")
            private WebElement snils;
    @FindBy (id = "snils")
            private WebElement inputSnils;
    @FindBy (id = "password")
            private WebElement inputPassword;
    @FindBy (id = "loginByPwdButton")
            private WebElement buttonLogin;



    By loginButtonControl = By.xpath("//*[@id=\"auth_module\"]/div/div[1]/div/div/article/div/div/a");
    By formAuth = By.id("authnFrm");
    By divPreloader = By.id("preloader-div");




  public void openLoginPage() {
      EntryPoints entryPoints = new EntryPoints(driver);
      String pre = entryPoints.getPre();
      String test = entryPoints.getTest();
      String prom = entryPoints.getProm();

      driver.findElement(By.id("login")).sendKeys("davydov");
      driver.findElement(By.id("password")).sendKeys("2fseJNRw");
      driver.findElement(By.id("save")).click();
      driver.get(pre);

 }

  public void login()  throws InterruptedException {
//      wait.until(ExpectedConditions.elementToBeClickable(loginButtonControl));
      Thread.sleep(3000);
      wait.until(ExpectedConditions.invisibilityOfElementLocated(divPreloader));
      loginButtonWithEsia.click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(formAuth));
      snils.click();
      inputSnils.click();
      StringSelection selection = new StringSelection(SNILSPROPRED);
      Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
      clipboard.setContents(selection, selection);
      inputSnils.sendKeys(Keys.CONTROL+"v");
      inputPassword.sendKeys(PASSWORDPROPRED);
      buttonLogin.click();

  }

  public void loginOnlyPassword() throws InterruptedException{

      Thread.sleep(3000);
//      wait.until(ExpectedConditions.visibilityOfElementLocated(formAuth));
      inputPassword.sendKeys(PASSWORDPROPRED);
      buttonLogin.click();
  }

}
