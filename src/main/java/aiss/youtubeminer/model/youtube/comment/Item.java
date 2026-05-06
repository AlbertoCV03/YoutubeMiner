
package aiss.youtubeminer.model.youtube.comment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "replies"
})
public class Item {
    @JsonProperty("replies")
    private Replies replies;

    @JsonProperty("replies")
    public Replies getReplies() {
        return replies;
    }

    @JsonProperty("replies")
    public void setReplies(Replies replies) {
        this.replies = replies;
    }

    @Override
    public String toString() {
        return "Item{" +
                "replies=" + replies +
                '}';
    }
}
