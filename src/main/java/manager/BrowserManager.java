package manager;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

import static manager.PlaywrightManager.*;

public class BrowserManager {
    static BrowserType browserType;
    static Browser browser;
    static Browser.NewContextOptions newContextOptions;
    public static BrowserContext context;

    public static synchronized Page createPage(Playwright playwright) {
        String browserName = "chromium";
        browserType = getBrowserType(playwright, browserName);
        browser = browserType.launch(getLaunchOptions(browserName));
        newContextOptions = new Browser.NewContextOptions();
        context = browser.newContext(newContextOptions);
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));
        newContextOptions.acceptDownloads = true;
        BROWSER_TYPE_THREAD_LOCAL.set(browserType);
        BROWSER_THREAD_LOCAL.set(browser);
        BROWSER_CONTEXT_THREAD_LOCAL.set(context);
        return context.newPage();
    }

    private static synchronized BrowserType getBrowserType(Playwright playwright, String browserName) {
        switch (browserName) {
            case "chromium":
                return playwright.chromium();
            case "firefox":
                return playwright.firefox();
            case "webkit":
                return playwright.webkit();
            default:
                throw new IllegalArgumentException();
        }
    }

    public static synchronized void tearDown() {
        PlaywrightManager.cleanUp();
    }

    private static BrowserType.LaunchOptions getLaunchOptions(String browserName) {
        if (browserName.equalsIgnoreCase("chromium")) {
            browserName = "chrome";
        }

        return new BrowserType.LaunchOptions().setHeadless(false).setChannel(browserName);

    }
}
