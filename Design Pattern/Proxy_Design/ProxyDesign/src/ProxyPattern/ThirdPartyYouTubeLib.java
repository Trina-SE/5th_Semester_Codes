package ProxyPattern;

interface ThirdPartyYouTubeLib {
    void listVideos();
    void getVideoInfo(String id);
    void downloadVideo(String id);
}