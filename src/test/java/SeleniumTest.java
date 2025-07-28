import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {

    @Test
    public void testFlujoActualizacionPeso() {
        // Configuración para Chrome en entorno headless (como GitHub Actions)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // importante en CI
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--user-data-dir=/tmp/chrome-profile");

        WebDriver driver = new ChromeDriver(options);

        // Accede a tu aplicación
        driver.get("http://localhost:8080");

        // Interactúa con la UI
        driver.findElement(By.id("peso")).sendKeys("75.0");
        driver.findElement(By.id("btn-actualizar")).click();

        // Verifica el resultado
        String pesoActual = driver.findElement(By.id("peso-actual")).getText();
        assertEquals("75.0", pesoActual);

        // Cierra el navegador
        driver.quit();
    }
}
