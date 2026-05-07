package aiss.youtubeminer.service;

import aiss.youtubeminer.model.DTO.CommentDTO;
import aiss.youtubeminer.model.youtube.comment.Datum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    RestTemplate restTemplate;

    private static final String BASE_URI = "https://www.googleapis.com/youtube/v3/commentThreads";
    private static final String partParam = "?part=snippet";
    private static final String key = "&key=";
    private static final String idParam = "&videoId=";
    private static final String maxCommentsParam = "&maxResults=";

    public Datum getAllCommentsByVideoId(String videoId, int maxComments, String apiKey){
        Datum comments = restTemplate.getForObject(BASE_URI+partParam+idParam+videoId+maxCommentsParam+maxComments+key+apiKey, Datum.class);
        return comments;
    }

    public List<CommentDTO> getAllCommentsDTO(String videoId,int maxComments, String apiKey){
        Datum comments = getAllCommentsByVideoId(videoId, maxComments, apiKey);
        List<CommentDTO> commentsDTO = new ArrayList<>();

        for(int i=0; i<comments.getItems().size(); i++){
            CommentDTO comment = new CommentDTO();

            comment.setId(comments.getItems().get(i).getSnippet().getTopLevelComment().getId());
            comment.setText(comments.getItems().get(i).getSnippet().getTopLevelComment().getSnippet().getTextDisplay());
            comment.setCreatedOn(comments.getItems().get(i).getSnippet().getTopLevelComment().getSnippet().getPublishedAt());

            commentsDTO.add(comment);
        }

        return commentsDTO;
    }

}
