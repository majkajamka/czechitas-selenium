import java.util.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import jdk.nashorn.internal.ir.annotations.Ignore;

public class SearchToSearch {

    WebDriver driver;

    @Before
    public void Nastaveni() {

        System.setProperty("webdriver.gecko.driver", "C:\\Java-Training\\Projects\\Czechitas-selenium\\seleniumdriver\\geckodriver.exe");
        driver = new FirefoxDriver();

    }

    @Test
    public void OpenSeznam() throws InterruptedException {

        driver.navigate().to("https://www.rajce.idnes.cz/hledej");
        System.out.println("Open the website.");

        WebElement element = driver.findElement(By.className("search-input"));
        element.click();

       // WebElement element1 = driver.findElement(By.id("mapy-input"));
        element.sendKeys("Krnov");
        System.out.println("Go to mapy.cz");
        WebElement botton = driver.findElement(By.className("search-submit"));
        botton.click();
        Thread.sleep(10000);

        @Ignore
        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://www.rajce.idnes.cz/hledej?q=Krnov&type=albums", url);
        System.out.println("Porovnani ocekanave a aktualni url.");
        WebElement searchButton = driver.findElement(By.className("searchButton"));
        searchButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//
//        //3.ukol
//        WebElement elementSearchField = driver.findElement(By.id("searchField"));
//
//        String searchFieldClassAtribute = elementSearchField.getAttribute("class");
//
//        System.out.println(searchFieldClassAtribute);
//
//        //5.ukol
//        List<WebElement> elementyProduktu = driver.findElements(By.className("produkt"));
//        for (int i = 0; i < elementyProduktu.size(); i++) {
//            WebElement prvniprodukt = elementyProduktu.get(i);
//            System.out.println(prvniprodukt.getText());

//        }
//
//    }

//        @Test
//        public void TestHledanikabelecky () InterruptedException {
//        driver.navigate().to("http://czechitas-shopizer.azurewebsites.net/shop");
//        // driver.manage().window().maximize();
//        System.out.println("Open shop");
//        //2
//        WebElement element = driver.findElement(By.id("searchField"));
//        element.sendKeys("UrciteneexistujiciKabelka");
//
//        WebElement searchButton = driver.findElement(By.className("searchButton"));
//        searchButton.click();
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        String url = driver.getCurrentUrl();
//        Assert.assertEquals("http://czechitas-shopizer.azurewebsites.net/shop/search/search.html", url);
//        System.out.println("Porovnani ocekanave a aktualni url.");



        }

        @After
        public void CleanUp () {

            driver.quit();

        }
    }



