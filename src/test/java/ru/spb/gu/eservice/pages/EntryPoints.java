package ru.spb.gu.eservice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EntryPoints {
    private String pre;
    private String prom;
    private String test;
    public WebDriver driver;
    public WebDriverWait wait;

    public EntryPoints(WebDriver driver) {
        this.pre = "https://eservice-pre.gu.spb.ru";
        this.prom = prom;
        this.test = "https://eservice-dev.gu.spb.ru";
        this.driver = driver;
        wait = new WebDriverWait(driver, 50);
    }

    public String getPre() {
        return pre;
    }

    public String getProm() {
        return prom;
    }

    public String getTest() {
        return test;
    }
}
