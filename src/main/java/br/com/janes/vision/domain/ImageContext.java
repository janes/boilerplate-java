package br.com.janes.vision.domain;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"cropHintsParams"
})
public class ImageContext {

@JsonProperty("cropHintsParams")
private CropHintsParams cropHintsParams;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("cropHintsParams")
public CropHintsParams getCropHintsParams() {
return cropHintsParams;
}

@JsonProperty("cropHintsParams")
public void setCropHintsParams(CropHintsParams cropHintsParams) {
this.cropHintsParams = cropHintsParams;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}

