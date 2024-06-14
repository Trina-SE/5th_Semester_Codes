package ProxyPattern;

class ThirdPartyYouTubeClass implements ThirdPartyYouTubeLib {
    public void listVideos() {
        System.out.println("Listing videos from YouTube...");
    }

    public void getVideoInfo(String id) {
        System.out.println("Getting video info for ID: " + id);
    }

    public void downloadVideo(String id) {
        System.out.println("Downloading video with ID: " + id);
    }
}