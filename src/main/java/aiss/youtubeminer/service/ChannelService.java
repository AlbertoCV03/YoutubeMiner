package aiss.youtubeminer.service;

import aiss.youtubeminer.model.DTO.ChannelDTO;
import aiss.youtubeminer.model.DTO.VideoDTO;
import aiss.youtubeminer.model.youtube.channel.Channel;
import aiss.youtubeminer.model.youtube.channel.Item;
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

    private static final String BASE_URI = "https://www.googleapis.com/youtube/v3/search";
    private static final String partParam = "?part=snippet";
    private static final String key = "&key=";
    private static final String userName = "&type=channel&q=";


    public Item getChannelByName(String name, String apiKey){
        Channel channel = restTemplate.getForObject(BASE_URI+partParam+userName+name+key+apiKey, Channel.class);
        return channel.getItems().get(0);
    }

    public ChannelDTO getChannelDTOByName(String channelName, int maxVideos, int maxComments, String apiKey){
        Item channel = getChannelByName(channelName, apiKey);
        ChannelDTO channelDTO = new ChannelDTO();

        channelDTO.setId(channel.getSnippet().getChannelId());
        channelDTO.setName(channel.getSnippet().getTitle());
        channelDTO.setDescription(channel.getSnippet().getDescription());
        channelDTO.setCreatedTime(channel.getSnippet().getPublishedAt());

        List<VideoDTO> videos = videoService.getAllVideosDTO(channelDTO.getId(), maxVideos, maxComments, apiKey);
        channelDTO.setVideos(videos);

        return channelDTO;
    }

    public ChannelDTO postChannelByName(String name, int maxVideos, int maxComments, String apiKey){
        ChannelDTO channel = getChannelDTOByName(name, maxVideos, maxComments, apiKey);

        restTemplate.postForObject("http://localhost:8080/videominer/channels", channel, ChannelDTO.class);
        return channel;
    }



}
