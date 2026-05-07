
package aiss.youtubeminer.model.youtube.comment;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "textDisplay",
    "publishedAt",
})
@Generated("jsonschema2pojo")
public class Snippet__1 {

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
        return "Snippet__1{" +
                "textDisplay='" + textDisplay + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                '}';
    }
}
