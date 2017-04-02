package br.com.janes.vision.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "aspectRatios" })
public class CropHintsParams {

	@JsonProperty("aspectRatios")
	private List<Double> aspectRatios = new ArrayList<>();

	@JsonProperty("aspectRatios")
	public List<Double> getAspectRatios() {
		return aspectRatios;
	}

	@JsonProperty("aspectRatios")
	public void setAspectRatios(List<Double> aspectRatios) {
		this.aspectRatios = aspectRatios;
	}

}
