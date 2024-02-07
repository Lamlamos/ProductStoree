package ExamProductStore;

import io.qameta.allure.Allure;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

public class CartPage {
    WebDriver webDriver;
    List<String> deviceNames = new ArrayList<>();
    List<Integer> devicePrice = new ArrayList<>();
    List<String> xpathCartLists;
    Config config = new Config();

    String totalAmonutOrder;

    public CartPage(WebDriver webDriver, List<String> xpathCartLists) {
        this.webDriver =webDriver;
        this.xpathCartLists = xpathCartLists;
    }

    public void checkCartPage() throws InterruptedException {
        int sumPrice = 0;
        List<String> deviceNameAtTheCart = new ArrayList<>();
        int containsCounter = 0;
       Thread.sleep(3000);

        //System.out.println("1 xpathListToGetNames" + xpathCartLists);
        for(String x: xpathCartLists) {
            deviceNames.add(webDriver.findElement(By.xpath(x)).getText());
        }
        Allure.step("Adding selected devices to the list");

        webDriver.get("https://www.demoblaze.com/cart.html");
        Thread.sleep(3000);

        Allure.step("Adding the selected devices name and prices from the cart");
        for(int i=0 ; i < deviceNames.size();i++) {
            int tr=i+1;
            deviceNameAtTheCart.add(webDriver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr["+tr+"]/td[2]")).getText());
            devicePrice.add(Integer.parseInt(webDriver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr["+tr+"]/td[3]")).getText()));
            if(deviceNames.contains(deviceNameAtTheCart.get(i))){

//                System.out.println("deviceNames counter " + counter +" " + deviceNames.contains(deviceNameAtTheCart.get(i)));
         //       System.out.println("devicePrice counter " + counter +" " + devicePrice.get(i));
                containsCounter++;
           }
        }

        Allure.step("check if the counter equals to devices names list length");
        if(containsCounter == deviceNames.size()){
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
        }

        Allure.step("sum devices prices");
        for (int price : devicePrice){
            sumPrice +=price;
        }

        Allure.step("check if the prices from the cart equals to total price");
        totalAmonutOrder = webDriver.findElement(By.xpath(config.getProperties("totalPrice"))).getText();
        int priceFromPage = Integer.parseInt(totalAmonutOrder);
        if(sumPrice == priceFromPage ){
            Assert.assertTrue(true);
            System.out.println("sumPrice:" + sumPrice );

        }else {
            Assert.assertTrue(false);
            System.out.println("sumPrice false" + sumPrice);
        }
    }


    public void placeProduct() throws InterruptedException, ParseException {
        String privateName  ="יוסף";
        String country  ="ישראל";
        String city  ="בית שאן";
        String creditCard  ="123123123";
        String month  ="08";
        String year="2029";
        String creditCardFromPopUp;
        String nameFromPopUp;
        String dateFromPopUp;


        int totalPrice =0;

        webDriver.findElement(By.xpath(config.getProperties("placeOrderBt"))).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath(config.getProperties("inputNn"))).sendKeys(privateName);
        webDriver.findElement(By.xpath(config.getProperties("inputCountry"))).sendKeys(country);
        webDriver.findElement(By.xpath(config.getProperties("inputCity"))).sendKeys(city);
        webDriver.findElement(By.xpath(config.getProperties("inputCreditCard"))).sendKeys(creditCard);
        webDriver.findElement(By.xpath(config.getProperties("inputMonth"))).sendKeys(month);
        webDriver.findElement(By.xpath(config.getProperties("inputYear"))).sendKeys(year);
        webDriver.findElement(By.xpath(config.getProperties("purchase"))).click();
        Thread.sleep(3000);

        System.out.println("totalPrice" + totalPrice);
        WebElement divElement =  webDriver.findElement(By.xpath("/html/body/div[10]"));
        WebElement innerElement = divElement.findElement(By.xpath("/html/body/div[10]/p"));
        String[] popUpDetails = innerElement.getText().split(" ");

        creditCardFromPopUp = popUpDetails[5];
        nameFromPopUp = popUpDetails[6];
        dateFromPopUp = popUpDetails[7];

        String toDay= getDate(dateFromPopUp);
        checkDateMatch(toDay , dateFromPopUp);

     // System.out.println(" toDay" + toDay + "dateFromPopUp " + dateFromPopUp );

        Allure.step("Check if the name from cart equals the costumer name");
        if (nameFromPopUp.contains(privateName)){
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);

        }
        Allure.step("Check if the credit card from cart equals the costumer credit card");
        if (creditCardFromPopUp.contains(creditCard)){
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);

        }

        }

    private String getDate(String dateFromCart){
        Allure.step("date Time Formatter");
        DateTimeFormatter dateTimeFormatter = null;
        String[] dateFP = dateFromCart.split("/");
        LocalDate toDay = LocalDate.now();

        if(dateFP[0].length() ==2 && dateFP[1].length() == 2) {
             dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            Allure.step("Change date to this format dd/MM/yyyy ");
        }else if(dateFP[0].length() ==1 && dateFP[1].length() == 2) {
             dateTimeFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            Allure.step("Change date to this format d/MM/yyyy ");
        }else if(dateFP[0].length() ==2 && dateFP[1].length() == 1) {
             dateTimeFormatter = DateTimeFormatter.ofPattern("dd/M/yyyy");
            Allure.step("Change date to this format dd/M/yyyy ");
        }else if(dateFP[0].length() ==1 && dateFP[1].length() == 1) {
             dateTimeFormatter = DateTimeFormatter.ofPattern("d/M/yyyy");
            Allure.step("Change date to this format d/M/yyyy ");
        }else {
            Assert.assertTrue(false);
        }


        String date=toDay.format(dateTimeFormatter);
        Assert.assertEquals(dateFromCart ,dateFromCart );


            return date;
        }


    private void checkDateMatch(String toDay, String dateFromPopUp) {
        Allure.step("Check date match");
        String[] toDayArray=toDay.split("/");
        String[] dateFromPopUpArray=toDay.split("/");

        if (toDay.length() == dateFromPopUp.length()){
            for(int i=0;i< toDayArray.length ; i++){
                if(toDayArray[i] != dateFromPopUpArray[0])
                    Assert.assertEquals(dateFromPopUpArray[i] , toDayArray[i]);
            }

        }else{
            Assert.assertEquals(dateFromPopUp.length() , toDay.length());

        }
    }

    }
