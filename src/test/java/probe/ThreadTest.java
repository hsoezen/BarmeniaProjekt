package probe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ThreadTest {
    @Test
    public void thread() {
        ThreadLocal<WebElement> threadLocal = new ThreadLocal<>();

        WebDriverManager.chromedriver().setup();
        //threadLocal.set(new ChromeDriver());
    }
    @Test
    public void thread1() {
        ThreadLocal<WebElement> threadLocal = new ThreadLocal<>();
        System.out.println(threadLocal.toString());
    }


}
