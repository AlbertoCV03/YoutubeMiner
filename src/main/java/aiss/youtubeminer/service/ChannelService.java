package aiss.youtubeminer.service;

import aiss.youtubeminer.model.youtube.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChannelService {

    @Autowired
    RestTemplate restTemplate;

    private static final String BASE_URI = "https://www.googleapis.com/youtube/v3/channels";
    private static final String partParam = "?part=";
    private static final String key = "&key=";
    private static final String idParam = "&id=";

    public Channel findChannelById(String part, String id, String apiKey){
        Channel channel = restTemplate.getForObject(BASE_URI+partParam+part+idParam+id+key+apiKey, Channel.class);
        return channel;
    }

}
