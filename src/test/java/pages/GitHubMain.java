package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class GitHubMain {
    public GitHubMain(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@id=':R2il5:']")
    public WebElement codeButton;

    @FindBy(xpath = "//input[contains(@value, 'https://github.com/')]")
    public WebElement httpsLink;

}
