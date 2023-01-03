package main;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class assignment {

  public static void main(String[] args) throws JSONException {
    System.out.println(  postAPI()); 
	  postAPI();
    postAPI();
    postAPI();
    postAPI();

	  
	  
    loginResult(false);

    if (login() == true) {
      Correct();
    } else {
      Incorrect();
    }
  
	    DeleteRequest();
	    System.out.println("Is the list empty: " + noAlerts());

  }

  public static boolean loginResult(boolean loginResultt) {
    return loginResultt == login();
  }

  public static boolean postResult(boolean postResult) throws JSONException {
    return postResult == postAPI();
  }

  public static boolean AmountOfAlert(boolean Alert) throws JSONException {
    return Alert == noAlerts();
  }

  public static void Correct() {
    System.out.println("correct login");
  }

  public static void Incorrect() {
    System.out.println("incorrect login");
  }

  public static boolean login() {
    System.setProperty(
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
    String url = driver.getCurrentUrl();

    if (url.equals("https://www.marketalertum.com/Alerts/List")) {
      return true;
    } else {
      return false;
    }
  }

  public static boolean postAPI() throws JSONException {
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

      InputStream in = new BufferedInputStream(conn.getInputStream());
      String result = IOUtils.toString(in, "UTF-8");
      System.out.println(result);

      in.close();
      conn.disconnect();

      return true;
    } catch (Exception e) {
      System.out.println(e);
      return false;
    }
  }

  public static int DeleteRequest() {
    String UserID = "157831f5-179f-4640-9634-98d2801da987";

    System.out.println("Alerts deleted");

    try {
      URL url = new URL("https://api.marketalertum.com/Alert?userId=" + UserID);
      HttpURLConnection con = (HttpURLConnection) url.openConnection();
      con.setRequestMethod("DELETE");
      return con.getResponseCode();
    } catch (Exception e) {}
    return 0;
  }

  public static boolean noAlerts() {
    System.setProperty(
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

      return false;
    } catch (Exception e) {
      return true;
    }
  }
}
