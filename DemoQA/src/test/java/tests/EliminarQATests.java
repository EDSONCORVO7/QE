package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DemoQAPage;

public class EliminarQATests {

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
    public void eliminar(){
        try {
            demoqa.EliminarUser();
            Assert.assertTrue(demoqa.nombreTabla.isEmpty(),"Registro Eliminado");
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    @AfterClass
    public void end() throws Exception{
        driver.close();
    }
}
