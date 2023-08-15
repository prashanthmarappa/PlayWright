package Test;


import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.HomePage;
import setup.TestSetup;

@Execution(value = ExecutionMode.CONCURRENT)
class AmazonPageCheck extends TestSetup {


  @Test
  @Description("Some detailed test description")
   public synchronized void testWhetherAmazonIsDisplayed1() {
    HomePage.getInstance()
            .clickBestSeller();
  }

  @Test
  @Description("Some detailed test description1")
  public synchronized void testWhetherAmazonIsDisplayed2() {
    HomePage.getInstance()
            .clickBestSeller().clickNewReleases();
  }

    @Test
    @Description("Some detailed test description3")
    public synchronized void accessbilityTesting() {
        HomePage.getInstance()
                .accessbilityTesting();
    }

}