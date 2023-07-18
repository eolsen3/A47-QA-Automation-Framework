import com.fasterxml.jackson.databind.JsonSerializable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test

    public void deletePlaylist () throws InterruptedException {
        String deletedPlayListMsg = "Deleted Playlist";

        provideEmail("erika.olsen@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        openPlaylist();
        clickDeletePlaylistBtn();
        Assert.assertTrue(getDeletedPlaylistMsg().contains(deletedPlayListMsg));
    }

   public void openPlaylist() {
       WebElement clickTestProPlaylist = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(3)"));
       clickTestProPlaylist.click();
   }

   public void clickDeletePlaylistBtn() throws InterruptedException {
        WebElement deletePlaylist = driver.findElement(By.cssSelector("button[title='Delete this playlist']"));
        deletePlaylist.click();
        Thread.sleep(2000);
   }

   public String getDeletedPlaylistMsg() {
        WebElement successMessage = driver.findElement(By.cssSelector("body > .alertify-logs.right.top"));
        return successMessage.getText();
   }

}
