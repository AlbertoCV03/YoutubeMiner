package aiss.youtubeminer.service;

import aiss.youtubeminer.model.DTO.UserDTO;
import aiss.youtubeminer.model.youtube.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    private static final String BASE_URI = "https://www.googleapis.com/youtube/v3/channels";
    private static final String partParam = "?part=snippet";
    private static final String key = "&key=";
    private static final String idParam = "&id=";

    public UserDTO getUserByChannelId(String channelId, String apiKey){
        Channel channel = restTemplate.getForObject(BASE_URI+partParam+idParam+channelId+key+apiKey, Channel.class);

        UserDTO user = new UserDTO();
        user.setId(null);
        user.setName(channel.getItems().get(0).getSnippet().getCustomUrl());
        user.setUser_link("https://www.youtube.com/"+user.getName());
        user.setPicture_link(channel.getItems().get(0).getSnippet().getThumbnails().getMedium().getUrl());

        return user;
    }
}
