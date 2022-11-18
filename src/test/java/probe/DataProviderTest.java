package probe;

import org.testng.annotations.Test;
import utilities.dataProviders.DataProviderTNG;

public class DataProviderTest {

    @Test(dataProvider = "dProvider", dataProviderClass = DataProviderTNG.class)
    public void addierenTest(int ersteZahl, int zweiteZahl){
        System.out.println(addieren(ersteZahl,zweiteZahl));

    }
    public int addieren(int a, int b){
       int c= a+b;
        return c;
    }
}
