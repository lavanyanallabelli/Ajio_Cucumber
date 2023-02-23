package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features",
                  glue = "steps", publish = true,tags = "@TC1"
                 ,plugin = {"pretty","html:target/cucumber-reports.html"},
                  monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

    @DataProvider
    public Object[][] scenarios(){
        return super.scenarios();

    }

}
//,tags = "@TC1"

//(parallel = true)