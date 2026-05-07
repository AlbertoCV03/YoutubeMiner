package aiss.youtubeminer.service;

import aiss.youtubeminer.model.DTO.CaptionDTO;
import aiss.youtubeminer.model.DTO.CommentDTO;
import aiss.youtubeminer.model.DTO.VideoDTO;
import aiss.youtubeminer.model.youtube.video.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CaptionService captionService;

    @Autowired
    CommentService commentService;

    @Autowired
    UserService userService;

    private static final String BASE_URI = "https://www.googleapis.com/youtube/v3/search";
    private static final String partParam = "?part=snippet";
    private static final String typeParam = "&type=video";
    private static final String key = "&key=";
    private static final String idParam = "&channelId=";
    private static final String maxVideosParam = "&maxResults=";

    public Video getAllVideosByChannelId(String channelId, int maxVideos, String apiKey){
        Video videos = restTemplate.getForObject(BASE_URI+partParam+idParam+channelId+maxVideosParam+maxVideos+typeParam+key+apiKey, Video.class);
        return videos;
    }

    public List<VideoDTO> getAllVideosDTO(String channelId, int maxVideos, int maxComments, String apiKey){
        Video videos = getAllVideosByChannelId(channelId, maxVideos, apiKey);
        List<VideoDTO> videosDTO = new ArrayList<>();

        for(int i=0; i<videos.getItems().size(); i++){
            VideoDTO video = new VideoDTO();

            video.setId(videos.getItems().get(i).getId().getVideoId());
            video.setName(videos.getItems().get(i).getSnippet().getTitle());
            video.setDescription(videos.getItems().get(i).getSnippet().getDescription());
            video.setReleaseTime(videos.getItems().get(i).getSnippet().getPublishedAt());

            List<CaptionDTO> captions = captionService.getAllCaptionsDTO(video.getId(), apiKey);
            video.setCaptionDTO(captions);

            List<CommentDTO> comments = commentService.getAllCommentsDTO(video.getId(), maxComments, apiKey);
            video.setCommentDTO(comments);

            video.setUser(userService.getUserByChannelId(channelId, apiKey));

            videosDTO.add(video);
        }

        return videosDTO;
    }




}
