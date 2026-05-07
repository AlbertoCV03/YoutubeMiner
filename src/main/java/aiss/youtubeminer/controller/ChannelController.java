package aiss.youtubeminer.controller;

import aiss.youtubeminer.model.youtube.channel.Channel;
import aiss.youtubeminer.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/youtube/v1")
public class ChannelController {

    @Autowired
    ChannelService channelService;


}
