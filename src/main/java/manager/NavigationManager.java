package manager;


public final class NavigationManager {

    private NavigationManager() {
    }

    private static final String URL = "https://www.amazon.com/";

    public static void launchUrl() {
        PlaywrightManager.getPage().navigate(URL);
    }
}