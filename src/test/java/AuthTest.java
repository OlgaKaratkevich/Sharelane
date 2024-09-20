import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AuthTest extends BaseTest{
    private String url = "https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345";

    @Test
    public void userShouldBeRegisteredWhenEnteringValidData(){
        driver.get(url);
        WebElement firstName = driver.findElement(By.name("first_name"));
        firstName.sendKeys("Abcd");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("Abcd@abc.com");
        WebElement password = driver.findElement(By.name("password1"));
        password.sendKeys("1111");
        WebElement confirmPassword = driver.findElement(By.name("password2"));
        confirmPassword.sendKeys("1111");
        WebElement registrationButton = driver.findElement(By.cssSelector("[value=Register]"));
        registrationButton.click();
        String actualMessage = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText().trim();
        String expectedMessage = "Account is created!";

        assertEquals(actualMessage, expectedMessage);
    }
}
