package manager;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

import static java.util.Objects.isNull;
import static manager.BrowserManager.context;

public final class PlaywrightManager {

    private PlaywrightManager() {
    }

    static final ThreadLocal<Playwright> PLAYWRIGHT_THREAD_LOCAL = ThreadLocal.withInitial(Playwright::create);
    static final ThreadLocal<BrowserContext> BROWSER_CONTEXT_THREAD_LOCAL = new ThreadLocal<>();
    static final ThreadLocal<Page> PAGE_THREAD_LOCAL = new ThreadLocal<>();
    static final ThreadLocal<Browser> BROWSER_THREAD_LOCAL = new ThreadLocal<>();
    static final ThreadLocal<BrowserType> BROWSER_TYPE_THREAD_LOCAL = new ThreadLocal<>();


    public static synchronized Page getPage() {

        if (isNull(PAGE_THREAD_LOCAL.get())) {
            Playwright playwright = Playwright.create();
            PLAYWRIGHT_THREAD_LOCAL.set(playwright);
            Page page = BrowserManager.createPage(playwright);
            PAGE_THREAD_LOCAL.set(page);
        }
        return PAGE_THREAD_LOCAL.get();
    }


    public static void cleanUp() {
        BROWSER_CONTEXT_THREAD_LOCAL.get().tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get(BROWSER_CONTEXT_THREAD_LOCAL.toString()+"_trace.zip")));
        PAGE_THREAD_LOCAL.get().close();
        PAGE_THREAD_LOCAL.remove();
        BROWSER_THREAD_LOCAL.get().close();
        BROWSER_THREAD_LOCAL.remove();
//        BROWSER_CONTEXT_THREAD_LOCAL.get().close();
//        BROWSER_CONTEXT_THREAD_LOCAL.remove();
        PLAYWRIGHT_THREAD_LOCAL.get().close();
        PLAYWRIGHT_THREAD_LOCAL.remove();
    }
}