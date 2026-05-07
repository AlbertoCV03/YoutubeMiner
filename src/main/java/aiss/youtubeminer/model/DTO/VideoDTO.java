package aiss.youtubeminer.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "description",
        "releaseTime",
        "user",
        "captions",
        "comments"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoDTO {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("releaseTime")
    private String releaseTime;
    @JsonProperty("user")
    private UserDTO userDTO;
    @JsonProperty("captions")
    private List<CaptionDTO> captionDTO;
    @JsonProperty("comments")
    private List<CommentDTO> commentDTO;

    @JsonProperty("id")
    public String getId() {
        return id;
    }
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }
    @JsonProperty("name")
    public String getName() {
        return name;
    }
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }
    @JsonProperty("releaseTime")
    public String getReleaseTime() {
        return releaseTime;
    }
    @JsonProperty("releaseTime")
    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }
    @JsonProperty("user")
    public UserDTO getUser() {
        return userDTO;
    }
    @JsonProperty("user")
    public void setUser(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
    @JsonProperty("captions")
    public List<CaptionDTO> getCaptionDTO() {
        return captionDTO;
    }
    @JsonProperty("captions")
    public void setCaptionDTO(List<CaptionDTO> captionDTO) {
        this.captionDTO = captionDTO;
    }
    @JsonProperty("comments")
    public List<CommentDTO> getCommentDTO() {
        return commentDTO;
    }
    @JsonProperty("comments")
    public void setCommentDTO(List<CommentDTO> commentDTO) {
        this.commentDTO = commentDTO;
    }

    @Override
    public String toString() {
        return "VideoDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                ", userDTO=" + userDTO +
                ", captionDTO=" + captionDTO +
                ", commentDTO=" + commentDTO +
                '}';
    }
}
