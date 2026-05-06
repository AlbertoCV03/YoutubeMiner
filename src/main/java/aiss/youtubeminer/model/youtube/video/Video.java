
package aiss.youtubeminer.model.youtube.video;

import java.util.List;

import aiss.youtubeminer.model.youtube.channel.Item;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "items",
})
public class Video {

    @JsonProperty("items")
    private List<Item> items;

    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Video{" +
                "items=" + items +
                '}';
    }
}
