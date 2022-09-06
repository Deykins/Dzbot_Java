package io.projet.DZBot.service;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;




@Component
public class DataMiner  {


    public String plyersScaner(){
        return getServers();
    }
     
     public String getServers(){
         ChromeOptions options = new ChromeOptions();
         options.addArguments("--headless");
         WebDriver driver = new ChromeDriver(options);
         driver.get("https://battlelog.battlefield.com/bf4/servers/show/pc/7db19d20-f4c6-494a-afd3-3ce98233168e/NRU-Gentleman-s-T-Bag-Club-Max-KD-2-0-Active-Admins-60Hz/");
         String text = String.valueOf(driver.findElement(By.xpath("//*[@id=\"server-page-info\"]/div[2]/div[1]/section/h5")).getText());
         String serverName = String.valueOf(driver.findElement(By.xpath("//*[@id=\"server-page\"]/header/div[2]/h1")).getText());
         String serverInfo = serverName + " ---> " + text;
         driver.quit();
         return serverInfo;
     }

    


}
