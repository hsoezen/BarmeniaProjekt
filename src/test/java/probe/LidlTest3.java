package probe;

import org.testng.annotations.Test;
import utilities.DriverTestNG;

public class LidlTest3 {

    public static int count=1;
    @Test
    public void test1() throws InterruptedException {
        DriverTestNG.getDriverTestNG().get().get("https://www.fincon.eu");

        System.out.println(count++ +".Test wurde durchgeführt.");
        DriverTestNG.closeTestNG();

    }
    @Test
    public void test2() throws InterruptedException {
        DriverTestNG.getDriverTestNG().get().get("https://www.fincon.eu");
        System.out.println(count++ +".Test wurde durchgeführt.");
        DriverTestNG.closeTestNG();

    }

}