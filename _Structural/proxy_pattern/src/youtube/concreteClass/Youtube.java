package youtube.concreteClass;

import video.Video;
import youtube.YoutubeInterface;

import java.util.ArrayList;
import java.util.List;

public class Youtube implements YoutubeInterface {
    private List<Video> videoList = new ArrayList<Video>();

    @Override
    public List<Video> getAllVideos() {
        return videoList;
    }

    @Override
    public Video getVideo(int id) {
        for(Video video:videoList){
            if(video.id == id)
                return video;
        }
        return null;
    }

    @Override
    public void setVideo(Video video) {
        videoList.add(video);
    }
}
