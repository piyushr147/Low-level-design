package youtube;

import video.Video;

import java.util.List;

public interface YoutubeInterface {
    public List<Video> getAllVideos();
    public Video getVideo(int id);
    public void setVideo(Video video);
}
