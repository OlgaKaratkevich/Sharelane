import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ZipcodeFieldTest extends BaseTest{
    private String url = "https://www.sharelane.com/cgi-bin/register.py";

    @Test
    public void zipCodeShouldAccept5Digits(){

        driver.get(url);

        WebElement zipCode = driver.findElement(By.name("zip_code"));
        zipCode.sendKeys("12345");
        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();

        WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
        boolean displayed = registerButton.isDisplayed();
        assertTrue(displayed);
}

@Test
public void zipCodeShouldNotAcceptEmptyField(){
    driver.get(url);
    WebElement continueButton = driver.findElement(By.cssSelector("[value = Continue]"));
    continueButton.click();

    WebElement errorMessage = driver.findElement(By.cssSelector("[class = error_message]"));
    String actualErrorMessage = errorMessage.getText().trim();
    String expectedErrorMessage = "Oops, error on page. ZIP code should have 5 digits";

    assertEquals(actualErrorMessage, expectedErrorMessage);
}


    @Test
    public void zipCodeShouldNotAcceptLetters(){
        driver.get(url);
        WebElement zipCode = driver.findElement(By.name("zip_code"));
        zipCode.sendKeys("abcde");
        WebElement continueButton = driver.findElement(By.cssSelector("[value = Continue]"));
        continueButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("[class = error_message]"));
        String actualErrorMessage = errorMessage.getText().trim();
        String expectedErrorMessage = "Oops, error on page. ZIP code should have 5 digits";

        assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @Test
    public void zipCodeShouldNotAcceptSpecialCharacters(){
        driver.get(url);
        WebElement zipCode = driver.findElement(By.name("zip_code"));
        zipCode.sendKeys("!@#$%");
        WebElement continueButton = driver.findElement(By.cssSelector("[value = Continue]"));
        continueButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("[class = error_message]"));
        String actualErrorMessage = errorMessage.getText().trim();
        String expectedErrorMessage = "Oops, error on page. ZIP code should have 5 digits";

        assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @Test
    public void zipCodeShouldNotAcceptLessThan5Digits(){
        driver.get(url);
        WebElement zipCode = driver.findElement(By.name("zip_code"));
        zipCode.sendKeys("1234");
        WebElement continueButton = driver.findElement(By.cssSelector("[value = Continue]"));
        continueButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("[class = error_message]"));
        String actualErrorMessage = errorMessage.getText().trim();
        String expectedErrorMessage = "Oops, error on page. ZIP code should have 5 digits";

        assertEquals(actualErrorMessage, expectedErrorMessage);
    }
}
