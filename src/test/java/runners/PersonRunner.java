package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/customer",
        glue = {"stepdefinitions", "hooks"}, // Buradaki path doğru mu?
        //tags = "@EmptyPassword or @EmptyUserName", // Alternatif 1: Virgüllü
        //tags = "@InvalidCredentials", // Alternatif 2: Tekli
        //tags = "@ValidCredentials", // Alternatif 2: Tekli
        plugin = {
                "pretty",
                "html:target/cucumber-reports"//,
                //"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)

public class PersonRunner {
}


