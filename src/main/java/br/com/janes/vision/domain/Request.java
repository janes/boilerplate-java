package br.com.janes.vision.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "image", "features", "imageContext" })
public class Request {

	@JsonProperty("image")
	private Image image;
	@JsonProperty("features")
	private List<Feature> features = null;
	@JsonProperty("imageContext")
	private ImageContext imageContext;

	@JsonProperty("image")
	public Image getImage() {
		return image;
	}

	@JsonProperty("image")
	public void setImage(Image image) {
		this.image = image;
	}

	@JsonProperty("features")
	public List<Feature> getFeatures() {
		return features;
	}

	@JsonProperty("features")
	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

	@JsonProperty("imageContext")
	public ImageContext getImageContext() {
		return imageContext;
	}

	@JsonProperty("imageContext")
	public void setImageContext(ImageContext imageContext) {
		this.imageContext = imageContext;
	}

}
