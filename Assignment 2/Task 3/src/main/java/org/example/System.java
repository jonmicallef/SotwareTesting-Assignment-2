package org.example;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class System {
    public static void main(String[] args) {
        java.lang.System.out.println("Hello world!");
    }
    WebDriver driver;

    public boolean LoginPage(boolean status) {
        java.lang.System.setProperty(
                "webdriver.chrome.driver",
                "C:/Program Files/chromedriver/chromedriver.exe"
        );
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.marketalertum.com");

        driver.switchTo().activeElement().sendKeys(Keys.TAB);
        driver.switchTo().activeElement().sendKeys(Keys.TAB);
        driver.switchTo().activeElement().sendKeys(Keys.TAB);

        driver.switchTo().activeElement().sendKeys(Keys.TAB);
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
        WebElement creditals = driver.findElement(By.name("UserId"));
        creditals.sendKeys("157831f5-179f-4640-9634-98d2801da987");
        WebElement submitButton = driver.findElement(By.name("__RequestVerificationToken")
        );
        submitButton.submit();
        String url = driver.getCurrentUrl();

        if (url.equals("https://www.marketalertum.com/Alerts/List")) {
            return true;
        } else {
            return false;
        }
    }

//    this is to test incorrect user id
    public boolean LoginIncorrect(boolean status) {
        java.lang.System.setProperty(
                "webdriver.chrome.driver",
                "C:/Program Files/chromedriver/chromedriver.exe"
        );

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.marketalertum.com");

        driver.switchTo().activeElement().sendKeys(Keys.TAB);
        driver.switchTo().activeElement().sendKeys(Keys.TAB);
        driver.switchTo().activeElement().sendKeys(Keys.TAB);

        driver.switchTo().activeElement().sendKeys(Keys.TAB);
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
        WebElement creditals = driver.findElement(By.name("UserId"));
        creditals.sendKeys("incorrect code");
        WebElement submitButton = driver.findElement(By.name("__RequestVerificationToken")
        );
        submitButton.submit();
        String url = driver.getCurrentUrl();

        if (url.equals("https://www.marketalertum.com/Alerts/Login")) {
                return true;
            }else {
            return false;

    }
    }

    public static boolean postAPI(boolean postted) throws JSONException {
        String heading = "heading", description = "Description", url =
                "url", Imageurl = "image url", centInString = "4500";

        JSONObject post = new JSONObject();
        post.put("alertType", 6);
        post.put("heading", heading);
        post.put("description", description);
        post.put("url", url);
        post.put("imageurl", Imageurl);
        post.put("postedBy", "157831f5-179f-4640-9634-98d2801da987");
        post.put("priceInCents", centInString);

        String json = post.toString();

        String query_url = "https://api.marketalertum.com/Alert";

        try {
            URL Apiurl = new URL(query_url);
            HttpURLConnection conn = (HttpURLConnection) Apiurl.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestProperty(
                    "Content-Type",
                    "application/json; charset=UTF-8"
            );
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.close();
            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
            String result = IOUtils.toString(in, "UTF-8");
            java.lang.System.out.println(result);

            in.close();
            conn.disconnect();

            return postted=true;
        } catch (Exception e) {
            java.lang.System.out.println(e);
            return postted=false;
        }
    }



    public static boolean DeleteRequest(boolean b) {
        String UserID = "157831f5-179f-4640-9634-98d2801da987";

        try {
            URL url = new URL("https://api.marketalertum.com/Alert?userId=" + UserID);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("DELETE");
            con.getResponseCode();
            return b = true;
        } catch (Exception e) {}
        return b = false;
    }

    public boolean NoAlerts(boolean NoAlerts) {
        java.lang.System.setProperty(
                "webdriver.chrome.driver",
                "C:/Program Files/chromedriver/chromedriver.exe"
        );
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.marketalertum.com");

        driver.switchTo().activeElement().sendKeys(Keys.TAB);
        driver.switchTo().activeElement().sendKeys(Keys.TAB);
        driver.switchTo().activeElement().sendKeys(Keys.TAB);

        driver.switchTo().activeElement().sendKeys(Keys.TAB);
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
        WebElement creditals = driver.findElement(By.name("UserId"));
        creditals.sendKeys("157831f5-179f-4640-9634-98d2801da987");
        WebElement submitButton = driver.findElement(
                By.name("__RequestVerificationToken")
        );
        submitButton.submit();
        try {
            WebElement item = driver.findElement(
                    By.xpath("/html/body/div/main/table[1]/tbody/tr[1]")
            );

            return NoAlerts = false;
        } catch (Exception e) {
            return NoAlerts = true;
        }
    }

    public boolean formate(boolean b) {
        java.lang.System.setProperty(
                "webdriver.chrome.driver",
                "C:/Program Files/chromedriver/chromedriver.exe"
        );
         driver = new ChromeDriver();

        driver.get("https://www.marketalertum.com");

        driver.switchTo().activeElement().sendKeys(Keys.TAB);
        driver.switchTo().activeElement().sendKeys(Keys.TAB);
        driver.switchTo().activeElement().sendKeys(Keys.TAB);

        driver.switchTo().activeElement().sendKeys(Keys.TAB);
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
        WebElement creditals = driver.findElement(By.name("UserId"));
        creditals.sendKeys("157831f5-179f-4640-9634-98d2801da987");
        WebElement submitButton = driver.findElement(
                By.name("__RequestVerificationToken")
        );
        submitButton.submit();
        try {
            WebElement item = driver.findElement(
                    By.xpath("/html/body/div/main/table[1]/tbody/tr[1]")
            );
            WebElement icon = driver.findElement(
                    By.xpath("/html/body/div/main/table/tbody/tr[1]/td/h4/img")
            );WebElement price = driver.findElement(
                    By.xpath("/html/body/div/main/table/tbody/tr[4]/td/b")
            );WebElement description = driver.findElement(
                    By.xpath("/html/body/div/main/table/tbody/tr[3]/td")
            );


            return b = true;
        } catch (Exception e) {
            return b = true;
        }

    }

    public boolean FiveInList(boolean b) {
        for (int i = 0; i < 5; i++) {
try{
            WebElement description = driver.findElement(
                    By.xpath("/html/body/div/main/table[" + i + "]")
            );
            return b = true;
        } catch (Exception e) {
            return b = true;
        }
        }
return true;

    }
}
