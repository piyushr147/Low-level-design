package youtube.proxy;

import video.Video;
import youtube.YoutubeInterface;
import youtube.concreteClass.Youtube;
import java.util.List;

public class YoutubeProxy implements YoutubeInterface {
    Youtube youtube;
    List<Video> videoListCache;
    Video videoCache;

    public YoutubeProxy(Youtube youtube){
        this.youtube = youtube;
    }

    @Override
    public List<Video> getAllVideos() {
        if(videoListCache == null || videoListCache.isEmpty()){
            videoListCache = youtube.getAllVideos();
        }
        return videoListCache;
    }

    @Override
    public Video getVideo(int id) {
        if(videoCache != null && videoCache.id == id)
            return videoCache;
        videoCache = youtube.getVideo(id);
        return videoCache;
    }

    @Override
    public void setVideo(Video video) {
        youtube.setVideo(video);
    }
}
