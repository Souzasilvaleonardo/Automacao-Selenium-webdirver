package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class RunBase {
    static WebDriver driver;

//    public enum Browser {CHROME, FIREFOX, EDGE}

    // iniciar o nosso driver
    public static WebDriver initDriver() {

        String browser = System.getProperty("browser");

        if (driver != null) {
            driver.quit();
        }

        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                throw new IllegalArgumentException("Edge ainda não suportado");
            default:
                throw new IllegalArgumentException("Navegador não encontrado! Passe um navegador existente: chrome, firefox ou edge");

        }
        if(driver != null){
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

        return driver;
    }

    // retonrar o driver criado
    public static WebDriver getDriver(){

        return  driver;
    }
}
