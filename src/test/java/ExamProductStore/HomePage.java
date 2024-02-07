package ExamProductStore;

import com.github.rsheremeta.AllureEnv;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import jdk.jfr.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Listeners(ProductStoreListener.class)
public class HomePage {

    String url = "https://www.demoblaze.com";
    HashMap<Integer , Product> productFromDB = new HashMap<>();
    ConnectToMySql connectToMySql = new ConnectToMySql();
    List<String> xpathCartLists = new ArrayList<>();
    WebDriver webDriver;
    Config config = new Config();



    @BeforeClass
    public void before() throws ClassNotFoundException {
        productFromDB = connectToMySql.connectTo();
        try {
            WebDriverManager.chromedriver().setup();
        } catch (Exception E) {
            System.out.println("WebDriverManager exception :" + E);
        }

        Dimension windowsSize = new Dimension(1200,1200); // הגדרת גודל חלון
        webDriver = new ChromeDriver();
        webDriver.get(url);
        webDriver.manage().window().setSize(windowsSize);
    }

    @AfterClass
    public void afterClass(){

        webDriver.quit();
    }

    @Test(priority = 1 )
    @Description("Phones Devices Are Available")
    void phonesDevicesAreAvailable() throws InterruptedException {
       Allure.description("Phones Devices Are Available");

       Thread.sleep(3000);
       WebElement phoneCategory = webDriver.findElement(By.xpath(config.getProperties("phoneCategory")));
       phoneCategory.click();
       Allure.step("Go to phone category");

       // phone 1 id 1
       WebElement phone_Samsung_galaxy_s6 = webDriver.findElement(By.xpath(config.getProperties("phone_Samsung_galaxy_s6")));
       Assert.assertEquals(phone_Samsung_galaxy_s6.getText() , productFromDB.get(1).getDeviceName());
       Allure.step("Check if Samsung galaxy s6 phone show up on page");

        // phone 2 id 2
        WebElement phone_Nokia_lumia_1520 = webDriver.findElement(By.xpath(config.getProperties("phone_Nokia_lumia_1520")));
        Assert.assertEquals(phone_Nokia_lumia_1520.getText() , productFromDB.get(2).getDeviceName());
        Allure.step("Check if Nokia lumia 1520 phone show up on page");
        // phone 3 id 3
        WebElement phone_Nexus_6 = webDriver.findElement(By.xpath(config.getProperties("phone_Nexus_6")));
        Assert.assertEquals(phone_Nexus_6.getText() , productFromDB.get(3).getDeviceName());
        Allure.step("Check if Nexus 6 phone show up on page");

        // phone 4 id 4
        WebElement phone_Samsung_galaxy_s7 = webDriver.findElement(By.xpath(config.getProperties("phone_Samsung_galaxy_s7")));
        Assert.assertEquals(phone_Samsung_galaxy_s7.getText() , productFromDB.get(4).getDeviceName());
        Allure.step("Check if Samsung galaxy s7 phone show up on page");

        // phone 5 id 5
        WebElement phone_Iphone_6_32gb = webDriver.findElement(By.xpath(config.getProperties("phone_Iphone_6_32gb")));
        Assert.assertEquals(phone_Iphone_6_32gb.getText() , productFromDB.get(5).getDeviceName());
        Allure.step("Check if Iphone 6 32gb phone show up on page");

        // phone 6 id 6
        WebElement phone_Sony_xperia_z5 = webDriver.findElement(By.xpath(config.getProperties("phone_Sony_xperia_z5")));
        Assert.assertEquals(phone_Sony_xperia_z5.getText() , productFromDB.get(6).getDeviceName());
        Allure.step("Check if Sony xperia z5 show up on page");
        // phone 7 id 7
        WebElement phone_HT_COne_M9 = webDriver.findElement(By.xpath(config.getProperties("phone_HT_COne_M9")));
        Assert.assertEquals(phone_HT_COne_M9.getText(), productFromDB.get(7).getDeviceName());
        Allure.step("Check if HT COne M9 phone show up on page");

    }

   @Test(priority = 2)
    @Description("Laptops Devices Are Available")
    void laptopsDevicesAreAvailable() throws InterruptedException {

        Thread.sleep(3000);

        WebElement laptopCategory = webDriver.findElement(By.xpath(config.getProperties("laptopCategory")));
        laptopCategory.click();
        Allure.step("Go to laptop category");

       Thread.sleep(2000);
        // laptop 1 id 13 8
        WebElement laptop_Sony_vaio_i5 = webDriver.findElement(By.xpath(config.getProperties("laptop_Sony_vaio_i5")));
        Assert.assertEquals(laptop_Sony_vaio_i5.getText() , productFromDB.get(8).getDeviceName());
        Allure.step("Check if Sony vaio i5 laptop show up on page");


        // laptop 2 id 13 9
        WebElement laptop_Sony_vaio_i7 = webDriver.findElement(By.xpath(config.getProperties("laptop_Sony_vaio_i7")));
        Assert.assertEquals(laptop_Sony_vaio_i7.getText() , productFromDB.get(9).getDeviceName());
        Allure.step("Check if Sony vaio i7 laptop show up on page");

        // laptop 3 id 10
        WebElement laptop_MacBook_air = webDriver.findElement(By.xpath(config.getProperties("laptop_MacBook_air")));
        Assert.assertEquals(laptop_MacBook_air.getText() , productFromDB.get(10).getDeviceName());
        Allure.step("Check if MacBook air laptop show up on page");

        // laptop 4 id 11
        WebElement laptop_Dell_i7_8gb = webDriver.findElement(By.xpath(config.getProperties("laptop_Dell_i7_8gb")));
        Assert.assertEquals(laptop_Dell_i7_8gb.getText() , productFromDB.get(11).getDeviceName());
        Allure.step("Check if Dell i7 8gb laptop show up on page");

        // laptop 5 id 12
        WebElement laptop_2017_Dell_15_6_Inch = webDriver.findElement(By.xpath(config.getProperties("laptop_2017_Dell_15_6_Inch")));
        Assert.assertEquals(laptop_2017_Dell_15_6_Inch.getText() , productFromDB.get(12).getDeviceName());
        Allure.step("Check if 2017 Dell 15 6 Inch laptop show up on page");

        // laptop 6 id 13
        WebElement laptop_MacBook_Pro = webDriver.findElement(By.xpath(config.getProperties("laptop_MacBook_Pro")));
        Assert.assertEquals(laptop_MacBook_Pro.getText() , productFromDB.get(13).getDeviceName());
        Allure.step("Check if MacBook Pro laptop show up on page");

    }

    @Test(priority = 3)
    @Description("Monitors Devices Are Available")
    void monitorsDevicesAreAvailable() throws InterruptedException {

        Thread.sleep(3000);

        WebElement monitorCategory = webDriver.findElement(By.xpath(config.getProperties("monitorCategory")));
        monitorCategory.click();
        Allure.step("Go to monitor category");

        Thread.sleep(2000);
        // laptop 1 id 13 8
        WebElement monitor_Apple_monitor_24 = webDriver.findElement(By.xpath(config.getProperties("monitor_Apple_monitor_24")));
        Assert.assertEquals(monitor_Apple_monitor_24.getText() , productFromDB.get(14).getDeviceName());
        Allure.step("Check if Apple monitor 24 monitor show up on page");

        // laptop 2 id 13 9
        WebElement monitor_ASUS_Full_HD = webDriver.findElement(By.xpath(config.getProperties("monitor_ASUS_Full_HD")));
        Assert.assertEquals(monitor_ASUS_Full_HD.getText() , productFromDB.get(15).getDeviceName());
        Allure.step("Check if Apple ASUS Full HD monitor show up on page");

    }




    @Test (priority = 4)
    @Description("Home routing")
    void home() throws InterruptedException {
        WebElement home = webDriver.findElement(By.xpath(config.getProperties("homeButton")));
        home.click();
        Allure.step("Button home");

        Thread.sleep(2000);
        WebElement categoriesHome = webDriver.findElement(By.xpath(config.getProperties("categories")));
        Assert.assertEquals(categoriesHome.getText() ,"CATEGORIES");
        Allure.step("Check if cetegory exist in home page");

    }

    @Test (priority = 5)
    @Description("Contact routing")
    void contact() throws InterruptedException {
        Alert alert;
        WebElement contact = webDriver.findElement(By.xpath(config.getProperties("contactButton")));
        contact.click();
        Allure.step("Contact routing");
        Thread.sleep(2000);

        WebElement newMessage = webDriver.findElement(By.xpath(config.getProperties("newMessage")));
        Assert.assertEquals(newMessage.getText() ,"New message");
        Allure.step("Check if new message exist in contact routing");

        WebElement closeMessage = webDriver.findElement(By.xpath(config.getProperties("closeMessage")));
        closeMessage.click();
        Allure.step("close message at contact routing");
    }

    @Test (priority = 6)
    @Description("About us routing")
    void aboutUs() throws InterruptedException {
        WebElement aboutUs = webDriver.findElement(By.xpath(config.getProperties("aboutUsButton")));
        aboutUs.click();
        Allure.step("About us routing");
        Thread.sleep(2000);

        WebElement video = webDriver.findElement(By.xpath(config.getProperties("videoAU")));
        Assert.assertTrue(video.isDisplayed());
        Allure.step("check if videoAU exist");

        WebElement closeVideo = webDriver.findElement(By.xpath(config.getProperties("closeVideo")));
        closeVideo.click();
        Allure.step("close close video");
    }

    @Test (priority = 7)
    @Description("Cart routing")
    void cart() throws InterruptedException {
        WebElement cart = webDriver.findElement(By.xpath(config.getProperties("cartButton")));
        cart.click();
        Allure.step("Cart routing");

        Thread.sleep(2000);
        WebElement placeOrder = webDriver.findElement(By.xpath(config.getProperties("placeOrder")));
        Assert.assertTrue(placeOrder.isDisplayed());
        Allure.step("Check if place order exist");
    }

    @Test (priority = 8)
    @Description("Log in routing")
    void logIn() throws InterruptedException {
        WebElement logIn = webDriver.findElement(By.xpath(config.getProperties("loginButton")));
        logIn.click();
        Thread.sleep(2000);
        WebElement loginHeader = webDriver.findElement(By.xpath(config.getProperties("loginHeader")));
        Assert.assertTrue(loginHeader.isDisplayed());
        Allure.step("Check if the header exist");
        WebElement closeLogin = webDriver.findElement(By.xpath(config.getProperties("closeLogin")));
        closeLogin.click();
        Allure.step("close login");
    }

    @Test (priority = 9)
    @Description("Sing up routing")
    void singUp() throws InterruptedException {
        WebElement singUp = webDriver.findElement(By.xpath(config.getProperties("singUpButton")));
        singUp.click();
        Allure.step("Sing up button");
        Thread.sleep(2000);
        WebElement singUpHeader = webDriver.findElement(By.xpath(config.getProperties("singUpHeader")));
        Assert.assertTrue(singUpHeader.isDisplayed());
        Allure.step("Sing up header");
        WebElement closeSingUp = webDriver.findElement(By.xpath(config.getProperties("closeSingUp")));
        closeSingUp.click();
        Allure.step("Close sing up");

    }

    @Test (priority = 10)
    @Description("contact Send Message alert text")
    void contactSendMessage() throws InterruptedException {
        Alert alert;
        WebElement contact = webDriver.findElement(By.xpath(config.getProperties("contactButton")));
        contact.click();
        Allure.step("Contact Button");

        Thread.sleep(2000);
        WebElement inputEmail = webDriver.findElement(By.xpath(config.getProperties("inputEmail")));
        inputEmail.sendKeys("yosef@samo.com");
        Allure.step("send email");
        WebElement inputName = webDriver.findElement(By.xpath(config.getProperties("inputName")));
        inputName.sendKeys("יוסף");
        Allure.step("send name");

        WebElement inputMessage = webDriver.findElement(By.xpath(config.getProperties("inputMessage")));
        inputMessage.sendKeys("אתר מדהים");
        Allure.step("set message");

        WebElement sendMessage = webDriver.findElement(By.xpath(config.getProperties("sendMessage")));
        sendMessage.click();
        Allure.step("send message");

        //get the alert text
        alert = webDriver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        Assert.assertEquals(alertText , "Thanks for the message!!");
        Allure.step("accept alert");


    }

    @Test (priority = 11)
    @Description("Add to cart")
    void addToCart() throws InterruptedException {
        Allure.step("Add to cart");
        CartPage cartPage;
        webDriver.get(url);
        Thread.sleep(3000);
        Alert alert;
        xpathCartLists.add(config.getProperties("phone_Samsung_galaxy_s6"));
        xpathCartLists.add(config.getProperties("laptop_Sony_vaio_i7"));
        xpathCartLists.add(config.getProperties("laptop_Sony_vaio_i5"));

        for (String xpathCartList : xpathCartLists) {
            WebElement addToCart = webDriver.findElement(By.xpath(xpathCartList));
            addToCart.click();
            Thread.sleep(3000);
            webDriver.findElement(By.xpath(config.getProperties("addToCart"))).click();
            Allure.step("Add product to cart");
            Thread.sleep(2000);
            //get the alert text
            alert = webDriver.switchTo().alert();
            String alertText = alert.getText();
            alert.accept();
            Allure.step("accept alert ");
            Assert.assertEquals(alertText,"Product added");
            webDriver.navigate().to(url);
            Thread.sleep(3000);
        }
//        cartPage = new CartPage(webDriver, xpathCartLists );
//        cartPage.checkCartPage();

    }

    @Test(priority = 12)
    @Description("Check cart page")
    public void checkCartPage() throws InterruptedException {
        CartPage cartPage;
        cartPage = new CartPage(webDriver, xpathCartLists );
        cartPage.checkCartPage();

    }

    @Test(priority = 13)
    @Description("Check total price - bonus")
    public void checkPrice() throws InterruptedException, ParseException {
        CartPage cartPage;
        cartPage = new CartPage(webDriver, xpathCartLists );
        cartPage.placeProduct();

    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        // Instantiate a map with your needed Environment values

        Map<String, String> envData = new HashMap<>();
        envData.put("Base URL", "https://google.com/");
        envData.put("User", "Admin");
        envData.put("OS", System.getProperty("os.name"));

  /*
  If your /allure-results is in /target – just pass instantiated map as a parameter
  */
        AllureEnv.createAllureEnvironmentFile(envData);

  /*
  If your /allure-results is in custom directory – just pass one more parameter
  with customPath to your /allure-results directory
  */
        AllureEnv.createAllureEnvironmentFile(envData, "C:\\Users\\user\\Desktop\\demo\\ProductStore\\allure-results");

        // some your other code
    }



}
