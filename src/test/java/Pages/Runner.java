package Pages;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = {"src\\test\\resources\\"},
        format = {"pretty", "html:target/Destination"} ,
        tags={"@Test2"},
        glue={"Pages","resources"}

)
public class Runner {

}