package br.com.janes.vision.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "requests" })
public class Requests {

	@JsonProperty("requests")
	private List<Request> requests = null;

	@JsonProperty("requests")
	public List<Request> getRequests() {
		return requests;
	}

	@JsonProperty("requests")
	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

}