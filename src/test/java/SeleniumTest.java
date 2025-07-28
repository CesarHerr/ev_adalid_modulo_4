import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    @Test
    public void testFlujoActualizacionPeso() {
        // Opcional: define el path si chromedriver no está en PATH
        // System.setProperty("webdriver.chrome.driver", "/ruta/a/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080");

        driver.findElement(By.id("peso")).sendKeys("75.0");
        driver.findElement(By.id("btn-actualizar")).click();

        String pesoActual = driver.findElement(By.id("peso-actual")).getText();
        assertEquals("75.0", pesoActual);

        driver.quit();
    }
}
