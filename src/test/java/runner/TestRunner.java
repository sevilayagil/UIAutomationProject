package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber-html-report",
                "json:target/cucumber-json-report/cucumber-json.json"
        },
        features = {"src/test/java/features/"},
        glue = "steps/scenarios",
        //@errorregister @emailerror @passworderror @success  @missing @Invalid @login @register
        tags = {"@login,@register"})
public class TestRunner {
}
