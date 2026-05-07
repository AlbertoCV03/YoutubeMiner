
package aiss.youtubeminer.model.youtube.comment;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "channelId",
    "videoId",
    "topLevelComment",
    "canReply",
    "totalReplyCount",
    "isPublic"
})
@Generated("jsonschema2pojo")
public class Snippet {
    @JsonProperty("topLevelComment")
    private TopLevelComment topLevelComment;

    @JsonProperty("topLevelComment")
    public TopLevelComment getTopLevelComment() {
        return topLevelComment;
    }

    @JsonProperty("topLevelComment")
    public void setTopLevelComment(TopLevelComment topLevelComment) {
        this.topLevelComment = topLevelComment;
    }

    @Override
    public String toString() {
        return "Snippet{" +
                "topLevelComment=" + topLevelComment +
                '}';
    }
}
