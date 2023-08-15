package setup;

import com.microsoft.playwright.Tracing;
import manager.BrowserManager;
import manager.NavigationManager;
import org.junit.jupiter.api.*;

import java.nio.file.Paths;

import static manager.BrowserManager.context;
import static manager.PlaywrightManager.getPage;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TestSetup {

//  @BeforeAll
//   void setUp() {
//    getPage();
//    NavigationManager.launchUrl();
//  }
//
//  @AfterAll
//   void tearDown() {
//   BrowserManager.tearDown();
//  }

    @BeforeEach
    void setUp() {
        getPage();
        NavigationManager.launchUrl();
    }


   @AfterEach
   protected void tearDown() {
        BrowserManager.tearDown();
    }
}