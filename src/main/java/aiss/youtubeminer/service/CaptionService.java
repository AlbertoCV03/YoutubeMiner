package aiss.youtubeminer.service;

import aiss.youtubeminer.model.DTO.CaptionDTO;
import aiss.youtubeminer.model.youtube.caption.Datum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CaptionService {

    @Autowired
    RestTemplate restTemplate;

    private static final String BASE_URI = "https://www.googleapis.com/youtube/v3/captions";
    private static final String partParam = "?part=snippet";
    private static final String key = "&key=";
    private static final String idParam = "&videoId=";

    public Datum getAllCaptionsByVideoId(String videoId, String apiKey){
        Datum captions = restTemplate.getForObject(BASE_URI+partParam+idParam+videoId+key+apiKey, Datum.class);
        return captions;
    }

    public List<CaptionDTO> getAllCaptionsDTO(String videoId, String apiKey){
        Datum captions = getAllCaptionsByVideoId(videoId, apiKey);
        List<CaptionDTO> captionsDTO = new ArrayList<>();

        for(int i=0; i<captions.getItems().size(); i++){
            CaptionDTO caption = new CaptionDTO();

            caption.setId(captions.getItems().get(i).getId());
            caption.setLanguage(captions.getItems().get(i).getSnippet().getLanguage());
            caption.setLink(null);

            captionsDTO.add(caption);
        }

        return captionsDTO;
    }
}
