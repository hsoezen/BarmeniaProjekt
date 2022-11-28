package docker;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.DriverDocker;

import java.net.MalformedURLException;

public class DockerTest4MitDockerDriver {
    @Test
    public void dockerTest() throws MalformedURLException {
        DriverDocker.getDriver().get(ConfigReader.getProperty("base_url"));
        System.out.println(DriverDocker.getDriver().getTitle());
        System.out.println(DriverDocker.getDriver().getCurrentUrl());

        DriverDocker.closeDriver();
    }
}
