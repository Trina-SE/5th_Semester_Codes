package ProxyPattern;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        app.init();
    }

    public void init() {
        ThirdPartyYouTubeLib aYouTubeService = new ThirdPartyYouTubeClass();
        ThirdPartyYouTubeLib aYouTubeProxy = new CachedYouTubeClass(aYouTubeService);
        YouTubeManager manager = new YouTubeManager(aYouTubeProxy);
        manager.reactOnUserInput();
        manager.reactOnUserInput();
    }
}