package utilities.dataProviders;

import org.testng.annotations.DataProvider;

public class DataProviderUS_001 {

    @DataProvider(name = "EMail")
    public Object[][] emailAdresse() {

        Object[][] email = {{"abc.com"},{"@abc.com"}, {"abc@dcom"}, {"abc@d.set"}};

        return email;
    }
    @DataProvider(name = "BenutzerName")
    public Object[][] benutzerName(){

        Object[][] benutzerName = {{"AJonas/a"}, {"Jona s"}, {"Jonasü"}};

        return benutzerName;
    }
}
