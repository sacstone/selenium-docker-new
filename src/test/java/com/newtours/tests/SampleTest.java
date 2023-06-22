package com.newtours.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest {

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver","/Users/rameshdhanenkula/Downloads/chromedriver_mac64/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com");


    }
}
