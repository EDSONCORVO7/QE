package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ClaseBase;

public class DemoQAPage extends ClaseBase {

    public DemoQAPage(WebDriver driver){
        super(driver);
    }

    By btnAdd = By.xpath("//button[@id='addNewRecordButton']");
    By txtName = By.xpath("//input[@id='firstName']");
    By txtLastName = By.xpath("//input[@id='lastName']");
    By txtEmail = By.xpath("//input[@id='userEmail']");
    By txtAge = By.xpath("//input[@id='age']");
    By txtSalary = By.xpath("//input[@id='salary']");
    By txtDeparment = By.xpath("//input[@id='department']");
    By btnSubmit = By.xpath("//button[@id='submit']");
    By txtSearch = By.xpath("//input[@id='searchBox']");
    By btnSearch = By.xpath("//span[@id='basic-addon2']//span//*[name()='svg']");
    By firstName = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div/div[1]");
    By btnEdit = By.xpath("//span[@id='edit-record-1']//*[name()='svg']");
    By btnDelete = By.xpath("//span[@id='delete-record-1']//*[name()='svg']//*[name()='path' and contains(@d,'M864 256H7')]");

    public String nombreTabla = "";


    public void AddNewUser(){

        esperaExplicita(btnAdd);
        click(btnAdd);
        esperaExplicita(btnSubmit);
        agregarTexto("Edson", txtName);
        agregarTexto("Corvo", txtLastName);
        agregarTexto("edson@gmail.com", txtEmail);
        agregarTexto("35", txtAge);
        agregarTexto("2000000", txtSalary);
        agregarTexto("QA", txtDeparment);
        click(btnSubmit);
        esperaExplicita(btnSearch);
        agregarTexto("Edson", txtSearch);
        nombreTabla = obtenerTexto(firstName);
    }

    public void EditUser() throws InterruptedException {

        esperaExplicita(btnEdit);
        click(btnEdit);
        esperaExplicita(btnSubmit);
        limpiarTexto(txtName);
        espera(1000);
        agregarTexto("Andres",txtName);
        limpiarTexto(txtLastName);
        espera(1000);
        agregarTexto("Vera",txtLastName);
        limpiarTexto(txtEmail);
        espera(1000);
        agregarTexto("andres@gmail.com",txtEmail);
        limpiarTexto(txtAge);
        espera(1000);
        agregarTexto("40",txtAge);
        limpiarTexto(txtSalary);
        espera(1000);
        agregarTexto("1500000",txtSalary);
        limpiarTexto(txtDeparment);
        espera(1000);
        agregarTexto("DEV",txtDeparment);

        click(btnSubmit);
        esperaExplicita(btnSearch);
        agregarTexto("Andres", txtSearch);
        nombreTabla = obtenerTexto(firstName);
    }

    public void EliminarUser(){

        esperaExplicita(btnDelete);
        click(btnDelete);
        agregarTexto("cierra@example.com",txtSearch);
        nombreTabla = obtenerTexto(firstName).trim();
    }

}
