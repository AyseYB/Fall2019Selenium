package com.automation.tests.OfficeHours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SelaniumOH1 {

    public static void main(String[] args) {

        //Create arraylist and iterate over it
        ArrayList<String> keyToSearch = new ArrayList<>();
        keyToSearch.add("fruits");
        keyToSearch.add("veggies");
        keyToSearch.add("berries");
        Iterator <String > iterator = keyToSearch.iterator();
        //iterator return Iterator type which we can use with all iterator method
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
        //print before modification and
        //add * to each string in list before printing

        Iterator <String > iterator1 = keyToSearch.iterator();
        while (iterator1.hasNext()){
            String item = iterator1.next();
            System.out.println(item);
            System.out.println("*" + item);
        }

        //create a map with <String, String>
        HashMap<String , String > personalInfo = new HashMap<>();
        personalInfo.put("Name", "Bryan");
        personalInfo.put("StudentID" , "23456677");
        personalInfo.put("Major","computer science");

        Iterator <String > mapIterator = personalInfo.keySet().iterator();
        while (mapIterator.hasNext()){
            String key = mapIterator.next();
            System.out.println(key + ":" + personalInfo.get(key));
        }

        //===============================
        //SELENIUM
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://etsy.com");
        driver.findElement(By.id("global-enhancements-search-query")).click();
        driver.close();
    }
}
