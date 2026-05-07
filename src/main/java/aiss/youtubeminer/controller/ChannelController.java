package aiss.youtubeminer.controller;

import aiss.youtubeminer.model.DTO.ChannelDTO;
import aiss.youtubeminer.model.youtube.channel.Item;
import aiss.youtubeminer.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/youtube/v1")
public class ChannelController {

    @Autowired
    ChannelService channelService;


    @GetMapping
    public ChannelDTO getChannel(@RequestParam String name, @RequestParam String apiKey, @RequestParam(defaultValue = "10") int maxVideos, @RequestParam(defaultValue = "2") int maxComments){
        ChannelDTO channel = channelService.getChannelDTOByName(name, maxVideos, maxComments, apiKey);
        return channel;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ChannelDTO postChannel(@RequestParam String name, @RequestParam String apiKey, @RequestParam(defaultValue = "10") int maxVideos, @RequestParam(defaultValue = "2") int maxComments){
        ChannelDTO channel = channelService.postChannelByName(name, maxVideos, maxComments, apiKey);
        return channel;
    }


}
