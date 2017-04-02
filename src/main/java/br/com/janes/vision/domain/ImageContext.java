package br.com.janes.vision.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"cropHintsParams"
})
public class ImageContext {

@JsonProperty("cropHintsParams")
private CropHintsParams cropHintsParams = new CropHintsParams();

@JsonProperty("cropHintsParams")
public CropHintsParams getCropHintsParams() {
return cropHintsParams;
}

@JsonProperty("cropHintsParams")
public void setCropHintsParams(CropHintsParams cropHintsParams) {
this.cropHintsParams = cropHintsParams;
}


}

