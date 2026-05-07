package aiss.youtubeminer.service;

import aiss.youtubeminer.model.DTO.ChannelDTO;
import aiss.youtubeminer.model.DTO.VideoDTO;
import aiss.youtubeminer.model.youtube.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ChannelService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    VideoService videoService;

    private static final String BASE_URI = "https://www.googleapis.com/youtube/v3/channels";
    private static final String partParam = "?part=snippet";
    private static final String key = "&key=";
    private static final String idParam = "&id=";
    private static final String userName = "&forUsername=";

    public Channel getChannelById(String id, String apiKey){
        Channel channel = restTemplate.getForObject(BASE_URI+partParam+idParam+id+key+apiKey, Channel.class);
        return channel;
    }

    public Channel getChannelByName(String name, String apiKey){
        Channel channel = restTemplate.getForObject(BASE_URI+partParam+userName+name+key+apiKey, Channel.class);
        return channel;
    }

    public ChannelDTO getChannelDTOByName(String channelName, String maxVideos, String maxComments, String apiKey){
        Channel channel = getChannelById(channelName, apiKey);
        ChannelDTO channelDTO = new ChannelDTO();

        channelDTO.setId(channel.getItems().get(0).getId());
        channelDTO.setName(channel.getItems().get(0).getSnippet().getTitle());
        channelDTO.setDescription(channel.getItems().get(0).getSnippet().getDescription());
        channelDTO.setCreatedTime(channel.getItems().get(0).getSnippet().getPublishedAt());

        List<VideoDTO> videos = videoService.getAllVideosDTO(channelDTO.getId(), maxVideos, maxComments, apiKey);
        channelDTO.setVideos(videos);

        return channelDTO;
    }

}
