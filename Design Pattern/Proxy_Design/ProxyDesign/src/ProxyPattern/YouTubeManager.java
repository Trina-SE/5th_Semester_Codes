package ProxyPattern;

class YouTubeManager {
    protected ThirdPartyYouTubeLib service;

    public YouTubeManager(ThirdPartyYouTubeLib service) {
        this.service = service;
    }

    public void renderVideoPage(String id) {
        service.getVideoInfo(id);
    }

    public void renderListPanel() {
        service.listVideos();
    }

    public void reactOnUserInput() {
        renderVideoPage("videoID");
        renderListPanel();
    }
}