package com.searchmodule.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.util.List;

public class SearchPage {
    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(name="q")
    private WebElement searchText;

   // @FindBy(id="search_button_homepage")
   // private WebElement searchBtn;

    //@FindBy(xpath = "//button[@type='submit']")
    @FindBy(xpath = "//*[@id='searchbox_homepage']/div[1]/div/button[2]")
    private WebElement searchBtn;


    @FindBy(linkText="Videos")
    private WebElement videosLink;

    @FindBy(className="tile--vid")
    private List<WebElement> allVideos;


    public SearchPage(WebDriver driver){

        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }
    public void goTo(){
        this.driver.get("https://duckduckgo.com");
    }

    public void doSearch(String keyword){

        this.wait.until(ExpectedConditions.visibilityOf(this.searchText));
        this.searchText.sendKeys(keyword);
        this.searchText.sendKeys(Keys.ENTER);
       // this.searchBtn.click();
    }

    public void goToVideos(){

        this.wait.until(ExpectedConditions.visibilityOf(videosLink));
        this.videosLink.click();
    }
    public int getResult(){

        By by = By.className("tile--vid");
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
        System.out.println(this.allVideos.size());
        return this.allVideos.size();
    }



}
