
package aiss.youtubeminer.model.youtube.comment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "textDisplay",
    "publishedAt",
})
public class Snippet {

    @JsonProperty("textDisplay")
    private String textDisplay;

    @JsonProperty("publishedAt")
    private String publishedAt;

    @JsonProperty("textDisplay")
    public String getTextDisplay() {
        return textDisplay;
    }

    @JsonProperty("textDisplay")
    public void setTextDisplay(String textDisplay) {
        this.textDisplay = textDisplay;
    }

    @JsonProperty("publishedAt")
    public String getPublishedAt() {
        return publishedAt;
    }

    @JsonProperty("publishedAt")
    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    @Override
    public String toString() {
        return "Snippet{" +
                "textDisplay='" + textDisplay + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                '}';
    }
}
