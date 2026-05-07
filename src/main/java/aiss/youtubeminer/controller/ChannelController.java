package aiss.youtubeminer.controller;

import aiss.youtubeminer.model.DTO.ChannelDTO;
import aiss.youtubeminer.service.ChannelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Channel", description = "Channel operations")
@RestController
@RequestMapping("/youtube/v1")
public class ChannelController {

    @Autowired
    ChannelService channelService;

    @Operation(
            summary = "Gets channel by username",
            description = "Returns a channel from the youtube database using its username"
    )
    @GetMapping
    @ApiResponses({
            @ApiResponse(
                responseCode = "200",
                description = "Channel found",
                content = @Content(
                    schema = @Schema(implementation = ChannelDTO.class),
                    mediaType = "application/json",
                    examples = @ExampleObject(
                            name = "Channel example",
                            summary = "Successful response",
                            description = "This example shows how a channel should look like",
                            value = """
                                    {
                                        "id": "UCq6VFHwMzcMXbuKyG7SQYIg",
                                        "name": "penguinz0",
                                        "description": "Twitter: https://twitter.com/MoistCr1TiKaL Instagram: https://www.instagram.com/bigmoistcr1tikal/?hl=en Twitch: ...",
                                        "createdTime": "2007-05-07T23:42:34Z",
                                        "videos": [
                                            {
                                                "id": "8A2UjJtV_nU",
                                                "name": "She Was Killed for Her Pokemon Cards",
                                                "description": "Starforge PC https://starforgepc.com/moist-yt Get Goof Juice and use code MOIST https://gamersupps.gg/moist Our soap ...",
                                                "releaseTime": "2026-04-28T18:00:14Z",
                                                "user": {
                                                    "id": null,
                                                    "name": "penguinz0",
                                                    "user_link": "https://www.youtube.com/penguinz0",
                                                    "picture_link": "https://yt3.ggpht.com/ytc/AIdro_kOWn68FmChjExAEGw0vjLBpiP907ccNT5wASHcBjZeEuA=s240-c-k-c0x00ffffff-no-rj"
                                                },
                                                "captions": [
                                                    {
                                                        "id": "AUieDaZwxmYrJBEtWRid6W1sQr2ATu7jC8e7gBn9QP-eaL1knCI",
                                                        "language": "en"
                                                    }
                                                ],
                                                "comments": [
                                                    {
                                                        "id": "UgzgLIFbgUfkWb0ToX14AaABAg",
                                                        "text": "A fully kitted Spartan may be a slight challenge to an unarmored Space Marine.<br><br>Maybe you can argue that a Neophyte or newly inducted space marine is comparable in physical stats to a brute chieftain (with even better mobility and cognitive ability), but the genetic enhancements make their bare bodies more durable than most normal armors the UNSC has available, which is what most of their weapons are effective against (with a couple exceptions)<br><br>Blue team may be able to handle a single unarmed/unarmored battle brother",
                                                        "createdOn": "2026-05-07T16:28:59Z"
                                                    }
                                                ]
                                            }
                                        ]
                                    }
                                    """
                    )
                )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Channel not found",
                    content = @Content(schema = @Schema())
            )
    }
    )
    public ChannelDTO getChannel(
            @Parameter(description = "The channel username", example = "@penguinz0") @RequestParam String name,
            @Parameter(description = "Your youtube API key") @RequestParam String apiKey,
            @Parameter(description = "Maximum number of videos to be returned") @RequestParam(defaultValue = "10") int maxVideos,
            @Parameter(description = "Maximum number of comments to be returned") @RequestParam(defaultValue = "2") int maxComments){
        ChannelDTO channel = channelService.getChannelDTOByName(name, maxVideos, maxComments, apiKey);
        return channel;
    }

    @Operation(
            summary = "Posts channel",
            description = "Gets the channel from youtube database using its username and posts it in videoMiner database"
    )
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Channel found",
                    content = @Content(
                            schema = @Schema(implementation = ChannelDTO.class),
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Channel example",
                                    summary = "Successful response",
                                    description = "This example shows how a channel should look like",
                                    value = """
                                    {
                                        "id": "UCq6VFHwMzcMXbuKyG7SQYIg",
                                        "name": "penguinz0",
                                        "description": "Twitter: https://twitter.com/MoistCr1TiKaL Instagram: https://www.instagram.com/bigmoistcr1tikal/?hl=en Twitch: ...",
                                        "createdTime": "2007-05-07T23:42:34Z",
                                        "videos": [
                                            {
                                                "id": "8A2UjJtV_nU",
                                                "name": "She Was Killed for Her Pokemon Cards",
                                                "description": "Starforge PC https://starforgepc.com/moist-yt Get Goof Juice and use code MOIST https://gamersupps.gg/moist Our soap ...",
                                                "releaseTime": "2026-04-28T18:00:14Z",
                                                "user": {
                                                    "id": null,
                                                    "name": "penguinz0",
                                                    "user_link": "https://www.youtube.com/penguinz0",
                                                    "picture_link": "https://yt3.ggpht.com/ytc/AIdro_kOWn68FmChjExAEGw0vjLBpiP907ccNT5wASHcBjZeEuA=s240-c-k-c0x00ffffff-no-rj"
                                                },
                                                "captions": [
                                                    {
                                                        "id": "AUieDaZwxmYrJBEtWRid6W1sQr2ATu7jC8e7gBn9QP-eaL1knCI",
                                                        "language": "en"
                                                    }
                                                ],
                                                "comments": [
                                                    {
                                                        "id": "UgzgLIFbgUfkWb0ToX14AaABAg",
                                                        "text": "A fully kitted Spartan may be a slight challenge to an unarmored Space Marine.<br><br>Maybe you can argue that a Neophyte or newly inducted space marine is comparable in physical stats to a brute chieftain (with even better mobility and cognitive ability), but the genetic enhancements make their bare bodies more durable than most normal armors the UNSC has available, which is what most of their weapons are effective against (with a couple exceptions)<br><br>Blue team may be able to handle a single unarmed/unarmored battle brother",
                                                        "createdOn": "2026-05-07T16:28:59Z"
                                                    }
                                                ]
                                            }
                                        ]
                                    }
                                    """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Channel not found",
                    content = @Content(schema = @Schema())
            )
    }
    )
    public ChannelDTO postChannel(
            @Parameter(description = "The channel username", example = "@penguinz0") @RequestParam String name,
            @Parameter(description = "Your youtube API key") @RequestParam String apiKey,
            @Parameter(description = "Maximum number of videos to be returned") @RequestParam(defaultValue = "10") int maxVideos,
            @Parameter(description = "Maximum number of comments to be returned") @RequestParam(defaultValue = "2") int maxComments){
        ChannelDTO channel = channelService.postChannelByName(name, maxVideos, maxComments, apiKey);
        return channel;
    }


}
