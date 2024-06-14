package ProxyPattern;

class CachedYouTubeClass implements ThirdPartyYouTubeLib {
    private ThirdPartyYouTubeLib service;
    private String listCache;
    private String videoCache;
    private boolean needReset;

    public CachedYouTubeClass(ThirdPartyYouTubeLib service) {
        this.service = service;
    }

 // Inside CachedYouTubeClass
    public void listVideos() {
        if (listCache == null || needReset) {
            service.listVideos(); // Just call the method without concatenating
            listCache = "Cached video list";
            System.out.println(listCache);
        } else {
            System.out.println("Using cached video list: " + listCache);
        }
    }

    public void getVideoInfo(String id) {
        if (videoCache == null || needReset) {
            service.getVideoInfo(id); // Just call the method without concatenating
            videoCache = "Cached video info";
            System.out.println(videoCache);
        } else {
            System.out.println("Using cached video info: " + videoCache);
        }
    }

    public void downloadVideo(String id) {
        if (!downloadExists(id) || needReset) {
            service.downloadVideo(id);
        }
    }

    private boolean downloadExists(String id) {
        return false;
    }
}