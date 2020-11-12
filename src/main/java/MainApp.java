import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.*;

public class MainApp {

    private static List<WebElement> elementyProduktu;

    public static void main(String[] args) throws InterruptedException {
         System.setProperty("webdriver.gecko.driver", "C:\\Java-Training\\Projects\\Czechitas-selenium\\seleniumdriver\\geckodriver.exe");
         WebDriver driver = new FirefoxDriver();
        try {

            driver.navigate().to("http://czechitas-shopizer.azurewebsites.net/shop");
           // driver.manage().window().maximize();
            
           //2
            WebElement element = driver.findElement(By.id("searchField"));
            element.sendKeys("Handsbag");
         Thread.sleep(5000);
            WebElement botton = driver.findElement(By.className("searchButton"));
            WebElement searchButton = driver.findElement(By.className("searchButton"));
            searchButton.click();
         Thread.sleep(2000);

         //3.ukol
            WebElement elementSearchField = driver.findElement(By.id("searchField"));

            String searchFieldClassAtribute = elementSearchField.getAttribute("class");
            
            System.out.println(searchFieldClassAtribute);

         //5.ukol   
            List<WebElement> elementyProduktu = driver.findElements(By.className("produkt"));
            for (int i = 0; i <elementyProduktu.size() ; i++) {
                WebElement prvniprodukt =  elementyProduktu.get(i);
                System.out.println(prvniprodukt.getText());

            }
    }   finally {
            Thread.sleep(2000);
       driver.quit();

    }
    }
}
