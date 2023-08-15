package pages;


import com.deque.html.axecore.results.AxeResults;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import manager.PlaywrightManager;

import java.util.Arrays;
import java.util.Collections;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import com.deque.html.axecore.playwright.*;
import static org.junit.jupiter.api.Assertions.*;


public class HomePage {

    private final Page page;

    private static final String PIM = "text=PIM";
    private static final String EMPLOYEE_INFORMATION = "//h5";
    private static final String ADD_EMPLOYEE_BUTTON = "text='Add Employee'";

    public HomePage(Page page) {
        this.page = page;
    }

    public static HomePage getInstance() {

        return new HomePage(PlaywrightManager.getPage());

    }

    public synchronized HomePage clickBestSeller() {
        long startTime = System.currentTimeMillis();
        assertThat(page.getByLabel("Amazon", new Page.GetByLabelOptions().setExact(true))).isVisible();
        page.getByLabel("Open Menu").click();
        page.locator("#hmenu-content > ul.hmenu.hmenu-visible > li:nth-child(2) > a").click();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Time taken: " + elapsedTime + " milliseconds");
        return this;
    }
    public synchronized HomePage clickNewReleases() {
        long startTime = System.currentTimeMillis();
        page.locator("#zg_header").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("New Releases")).click();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Time taken: " + elapsedTime + " milliseconds");
        return this;
    }
    public synchronized HomePage accessbilityTesting() {
        long startTime = System.currentTimeMillis();
        AxeResults accessibilityScanResults = new AxeBuilder(page)
                .withTags(Arrays.asList("wcag2a", "wcag2aa", "wcag21a", "wcag21aa"))
                .analyze();
        assertEquals(Collections.emptyList(), accessibilityScanResults.getViolations()); // 5
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Time taken: " + elapsedTime + " milliseconds");
        return this;
    }
}