package probe;

import org.testng.annotations.Test;
import utilities.DriverTestNG;

public class LidlTest1  {

     public static int count=1;

    @Test
    public void test1() throws InterruptedException {

        Long thread1 = Thread.currentThread().getId();
        System.out.println(thread1.toString());
        //DriverTestNG.setThreadCurrent(thread1); --> So können wir die aktuelle Thread-Nummer zur thread-List einfügen.

        DriverTestNG.getDriverTestNG().get().get("https://www.fincon.eu");
        Long thread2 = Thread.currentThread().getId();
        System.out.println(thread1.toString());

        DriverTestNG.getDriverTestNG().get().get("https://www.youtube.com");
        Long thread3 = Thread.currentThread().getId();
        System.out.println(thread1.toString());

        System.out.println(count++ +".Test wurde durchgeführt.");
        //System.out.println(DriverTestNG.getThread().get(0).toString()); --> Die aktuelle Thread-Nummer schreiben lassen.
        Long thread4 = Thread.currentThread().getId();
        System.out.println(thread1.toString());

        DriverTestNG.closeTestNG();


    }
    @Test
    public void test2() throws InterruptedException {
        DriverTestNG.getDriverTestNG().get().get("https://www.fincon.eu");
        System.out.println(count++ +".Test wurde durchgeführt.");
        DriverTestNG.closeTestNG();

    }
    @Test
    public void test3() throws InterruptedException {
        DriverTestNG.getDriverTestNG().get().get("https://www.fincon.eu");
        System.out.println(count++ +".Test wurde durchgeführt.");
        DriverTestNG.closeTestNG();

    }

}
