import java.util.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class SearchTest {

    WebDriver driver;

    @Before
    public void Nastaveni() {

        System.setProperty("webdriver.gecko.driver", "C:\\Java-Training\\Projects\\Czechitas-selenium\\seleniumdriver\\geckodriver.exe");
        driver = new FirefoxDriver();

    }

    @Test
    public void TestHledanikabelky() {

        driver.navigate().to("http://czechitas-shopizer.azurewebsites.net/shop");
        // driver.manage().window().maximize();
        System.out.println("Open the e-shop website.");
        //2
        WebElement element = driver.findElement(By.id("searchField"));
        element.sendKeys("Handsbag");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Into searchField put Handsbag.");

        WebElement botton = driver.findElement(By.className("searchButton"));
        WebElement searchButton = driver.findElement(By.className("searchButton"));
        searchButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
         
        //3.ukol
        WebElement elementSearchField = driver.findElement(By.id("searchField"));

        String searchFieldClassAtribute = elementSearchField.getAttribute("class");

        System.out.println(searchFieldClassAtribute);


      

        //5.ukol
        List<WebElement> elementyProduktu = driver.findElements(By.className("produkt"));
        for (int i = 0; i < elementyProduktu.size(); i++) {
            WebElement prvniprodukt = elementyProduktu.get(i);
            System.out.println(prvniprodukt.getText());

        }

    }

    @Test
    public void TestHledanikabelecky() throws InterruptedException {
        driver.navigate().to("http://czechitas-shopizer.azurewebsites.net/shop");
        // driver.manage().window().maximize();
        System.out.println("Open shop");
        //2
        WebElement element = driver.findElement(By.id("searchField"));
        element.sendKeys("UrciteneexistujiciKabelka");
                     Thread.sleep(5000);
                     
        WebElement searchButton = driver.findElement(By.className("searchButton"));
        searchButton.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String url = driver.getCurrentUrl();
        Assert.assertEquals("http://czechitas-shopizer.azurewebsites.net/shop/search/search.html", url );
        System.out.println("Porovnani ocekanave a akutani url.");

    }

    @After
    public void CleanUp() {

        driver.quit();
    }

}
