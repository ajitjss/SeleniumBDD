package RUNNER;


import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(ExtendedCucumber.class)
@CucumberOptions(features = "resources/feature", glue={"test/java/stepDef"},
        plugin= {"pretty","html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json"},
               tags={"@AB2"},
        dryRun = false,
monochrome = true)
public class Runner {
}
