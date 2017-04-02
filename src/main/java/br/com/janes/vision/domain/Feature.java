package br.com.janes.vision.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "type", "maxResults" })
public class Feature {

	@JsonProperty("type")
	private FeatureType type;
	@JsonProperty("maxResults")
	private Integer maxResults;

	@JsonProperty("type")
	public FeatureType getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(FeatureType type) {
		this.type = type;
	}

	@JsonProperty("maxResults")
	public Integer getMaxResults() {
		return maxResults;
	}

	@JsonProperty("maxResults")
	public void setMaxResults(Integer maxResults) {
		this.maxResults = maxResults;
	}

}
