import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class PostStatus {

    private static String FB_EMAIL = "facebook_test@inbox.ru";
    private static String FB_PASSWORD = "Password@User1";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.get("http://www.facebook.com");
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(FB_EMAIL);
        System.out.println(FB_EMAIL + " entered for username");

        WebElement passwordInput = driver.findElement(By.id("pass"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(FB_PASSWORD);
        System.out.println(FB_PASSWORD + " entered for password");

        WebElement loginBtn = driver.findElement(By.id("u_0_t"));
        loginBtn.click();
        System.out.println("Login button clicked!");

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement homeBtn = driver.findElement(By.className("_2md"));
        homeBtn.click();
        System.out.println("Home button clicked!");

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement statusInput = driver.findElement(By.name("xhpc_message"));
        statusInput.click();
        statusInput.sendKeys("Hello world");
        System.out.println("Status message posted.");

        WebElement postBtn = driver.findElement(By.xpath("//button[contains(.,'Post')]"));
        postBtn.click();
        driver.quit();

    }
}
