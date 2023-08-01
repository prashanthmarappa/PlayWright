import io.cucumber.spring.CucumberContextConfiguration;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.*;
@CucumberContextConfiguration
@SpringBootConfiguration
@ContextConfiguration(classes = com.stepDefinition.LoginSteps.class) // Replace TestConfig.class with your actual Spring Boot configuration class
public class Runner {
}
