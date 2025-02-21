package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/java/features/login",
        glue = {"stepdefinitions", "hooks"}, // Buradaki path doğru mu?
        tags = "@EmptyPassword or @EmptyUserName or @InvalidCredentials", // Alternatif 1: Virgüllü
        //tags = "@InvalidCredentials", // Alternatif 2: Tekli
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "pretty",
                "html:target/cucumber-reports"}
)

public class ParalelRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }


}


