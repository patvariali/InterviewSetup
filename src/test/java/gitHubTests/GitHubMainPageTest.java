package gitHubTests;

import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pages.GitHubMain;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;
import static org.testng.Assert.assertTrue;

public class GitHubMainPageTest {

    GitHubMain gitHubMain = new GitHubMain();
    String mainURL = ConfigurationReader.getProperty("mainURL");

    @Test
    public void testHTTPS() throws InterruptedException {
        step("Open gitHub page", () -> {
            Driver.getDriver().get(mainURL);
        });

        step("Click on the 'code' button", () ->
                gitHubMain.codeButton.click()
        );
        String actualHTTPS = gitHubMain.httpsLink.getAttribute("value");
        String expected = "Selenium_Junit5_Cucumber_Example";
        step("Check if link contains " + expected, () ->
                    assertTrue(actualHTTPS.contains(expected))

        );

        Driver.closeDriver();

    }
}
