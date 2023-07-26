package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DemoQAPage;

public class EditarQATests {

    WebDriver driver;
    DemoQAPage demoqa;


    @BeforeClass
    public void start() {
        demoqa = new DemoQAPage(driver);
        driver = demoqa.conexionDriverChrome();
        demoqa.visitarSitio("https://demoqa.com/webtables");
        demoqa.maximizarVentanaBrowser();
    }

    @Test
    public void editar(){
        try {
            demoqa.EditUser();
            Assert.assertEquals(demoqa.nombreTabla, "Andres");
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @AfterClass
    public void end() throws Exception{
        driver.close();
    }
}
