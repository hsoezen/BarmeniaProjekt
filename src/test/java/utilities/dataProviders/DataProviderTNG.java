package utilities.dataProviders;

import org.testng.annotations.DataProvider;

public class DataProviderTNG {

    @DataProvider(name = "dProvider")
    public  Object[][] datenPro(){
        Object[][] daten = {{2,3}, {4,6}, {12, 13}};
        return daten;
    }

}
