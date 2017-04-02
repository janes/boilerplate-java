package br.com.janes.vision.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"content"
})
public class Image {

@JsonProperty("content")
private String content;

@JsonProperty("content")
public String getContent() {
return content;
}

@JsonProperty("content")
public void setContent(String content) {
this.content = content;
}

}

