
package aiss.youtubeminer.model.youtube.channel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "title",
    "description",
    "customUrl",
    "publishedAt",
    "thumbnails",
})
public class Snippet {

    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("customUrl")
    private String customUrl;
    @JsonProperty("publishedAt")
    private String publishedAt;
    @JsonProperty("thumbnails")
    private Thumbnails thumbnails;

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("customUrl")
    public String getCustomUrl() {
        return customUrl;
    }

    @JsonProperty("customUrl")
    public void setCustomUrl(String customUrl) {
        this.customUrl = customUrl;
    }

    @JsonProperty("publishedAt")
    public String getPublishedAt() {
        return publishedAt;
    }

    @JsonProperty("publishedAt")
    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    @JsonProperty("thumbnails")
    public Thumbnails getThumbnails() {
        return thumbnails;
    }

    @JsonProperty("thumbnails")
    public void setThumbnails(Thumbnails thumbnails) {
        this.thumbnails = thumbnails;
    }

    @Override
    public String toString() {
        return "Snippet{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", customUrl='" + customUrl + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", thumbnails=" + thumbnails +
                '}';
    }
}
