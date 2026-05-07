
package aiss.youtubeminer.model.youtube.comment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "snippet"
})
public class TopLevelComment {
    @JsonProperty("id")
    private String id;
    @JsonProperty("snippet")
    private Snippet__1 snippet;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("snippet")
    public Snippet__1 getSnippet() {
        return snippet;
    }

    @JsonProperty("snippet")
    public void setSnippet(Snippet__1 snippet) {
        this.snippet = snippet;
    }

    @Override
    public String toString() {
        return "TopLevelComment{" +
                "id='" + id + '\'' +
                ", snippet=" + snippet +
                '}';
    }
}
