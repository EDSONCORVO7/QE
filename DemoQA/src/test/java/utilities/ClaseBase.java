package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.logging.Logger;


public class ClaseBase {

    public final Logger logger = Logger.getLogger(ClaseBase.class.getName());

    private WebDriver driver;

    JavascriptExecutor js = (JavascriptExecutor) driver;

    //Constructor
    public ClaseBase(WebDriver driver){
        this.driver = driver;
    }

    public WebElement buscarElementoWeb(By localizador){
        return this.driver.findElement(localizador);
    }

    public List<WebElement> buscarElementosWeb(By localizador){
        return this.driver.findElements(localizador);
    }

    public void click(By localizador){
        this.driver.findElement(localizador).click();
    }

    public void click2(WebElement element){
        element.click();
    }

    public void doubleclick(By localizador){
        Actions act = new Actions(driver);
        WebElement ele = driver.findElement(localizador);
        act.doubleClick(ele).perform();
    }

    public void scrolldown(By localizador){
        js.executeScript("arguments[0].scrollIntoView();", localizador);
    }

    public String obtenerTexto(By localizador){
        return this.driver.findElement(localizador).getText();
    }

    public void agregarTexto(String texto, By localizador){
        this.driver.findElement(localizador).sendKeys(texto);
    }

    public void limpiarTexto(By localizador){
        this.driver.findElement(localizador).clear();
    }

    public void agregarCombinacionTeclas(Keys key, By localizador){
        this.driver.findElement(localizador).sendKeys(key);
    }

    public void visitarSitio(String url){
        this.driver.get(url);
    }

    public String mainTab(){
        return this.driver.getWindowHandle();
    }

    public void stop(){
        this.driver.quit();
    }

    public void Focus(String maintab){
        String newTab = "";

        Set<String> handles = driver.getWindowHandles();
        for (String actual: handles){
            if(!actual.equalsIgnoreCase(maintab)){
                driver.switchTo().window(actual);
                newTab=actual;
            }
        }
    }

    public void focusOldTab(String maintab){
        driver.switchTo().window(maintab);
    }

    public void openNewTab(){
        ((JavascriptExecutor)driver).executeScript("window.open()");
    }

    public String obtener_nombre_sitio(){
        String nombre_sitio;
        nombre_sitio=this.driver.getTitle();
        return nombre_sitio;
    }

    public String obtener_url(){
        String url;
        url=this.driver.getCurrentUrl();
        return url;
    }

    public void espera(int milisegundos) throws InterruptedException {
        Thread.sleep(milisegundos);
    }

    public WebElement esperaExplicita(By localizador){
        WebDriverWait espera = new WebDriverWait(this.driver, 60);
        return espera.until(ExpectedConditions.visibilityOfElementLocated(localizador));
    }

    public Boolean esperaExplicita2(String url){
        WebDriverWait espera = new WebDriverWait(this.driver, 60);
        return espera.until(ExpectedConditions.urlToBe(url));
    }

    public WebElement esperaExplicita3(By localizador){
        // Waiting 30 seconds for an element to be present on the page, checking
        // for its presence once every 5 seconds.
        Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchFieldException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(localizador);
            }
        });
        return foo;
    }

    public int sizeElement(By localizador){
        return this.driver.findElements(localizador).size();
    }

    public WebDriver conexionDriverChrome(){
        String path = Paths.get(System.getProperty("user.dir"), "/src/test/resources/drivers/chromedriver114.exe")
                .toString();
        System.setProperty("webdriver.chrome.driver", path);

        this.driver = new ChromeDriver();

        this.driver.manage().timeouts().pageLoadTimeout(240, TimeUnit.SECONDS);
        this.driver.manage().timeouts().setScriptTimeout(240,TimeUnit.SECONDS);

        return driver;
    }

    public Boolean estaDesplegado(By localizador){
        try{
            return driver.findElement(localizador).isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public Boolean estaDisponible(By localizador){
        try {
            return this.driver.findElement(localizador).isSelected();
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public void maximizarVentanaBrowser(){
        this.driver.manage().window().maximize();
    }

    public void cerrarBrowser(){
        this.driver.close();
    }

}
