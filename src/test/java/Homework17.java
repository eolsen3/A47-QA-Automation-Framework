//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String newSongAddedNotificationText = "Added 1 song into";

        navigateToPage();
        provideEmail("erika.olsen@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        searchSong("Take My Hand");
        //clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        choosePlaylist();
        Assert.assertTrue(getNotificationText().contains(newSongAddedNotificationText));
    }

    public void searchSong (String songTitleKeyword) throws InterruptedException{
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type=search]"));
        searchField.sendKeys(songTitleKeyword);
        Thread.sleep(3000);
}
    public void clickViewAllBtn () throws InterruptedException{
   WebElement viewAllSearchResult = driver.findElement(By.cssSelector("[data-test = 'view-all-songs-btn']"));
    viewAllSearchResult.click();
   Thread.sleep(3000);
    }

    public void selectFirstSongResult() throws InterruptedException {
        WebElement firstSongResult = driver.findElement(By.cssSelector("section#songResultsWrapper .items > tr:nth-of-type(1)"));
        firstSongResult.click();
        Thread.sleep(3000);
    }
    public void clickAddToBtn() throws InterruptedException {
        WebElement addToBtn = driver.findElement(By.cssSelector("button.btn-add-to"));
        addToBtn.click();
        Thread.sleep(3000);
    }
    public void choosePlaylist() throws InterruptedException {
        WebElement playlistElement = driver.findElement(By.xpath( "//section[id ='songResultsWrapper']//li[contains(text(), 'Test Pro Playlist')]"));
        playlistElement.click();
        Thread.sleep(3000);
    }
    public String getNotificationText() {
        WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
        return notificationElement.getText();

    }
}



