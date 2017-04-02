package br.com.janes.vision.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.janes.vision.domain.CropHintsParams;
import br.com.janes.vision.domain.Feature;
import br.com.janes.vision.domain.FeatureType;
import br.com.janes.vision.domain.Image;
import br.com.janes.vision.domain.ImageContext;
import br.com.janes.vision.domain.Request;
import br.com.janes.vision.domain.Requests;

@RestController
public class VisionController {

	private static final int MAXRESULTS = 50;

	public VisionController() {

	}

	@Autowired
	private Curling curling;

	@RequestMapping(value = "/v1/images", method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> annotate(@RequestBody Image image) {
		Requests requests = new Requests();
		Request request = new Request();

		for (FeatureType type : FeatureType.values()) {
			Feature feature = new Feature();
			feature.setType(type);
			feature.setMaxResults(MAXRESULTS);
			request.getFeatures().add(feature);
		}

		ImageContext imageContext = new ImageContext();
		CropHintsParams cropHintsParams = imageContext.getCropHintsParams();
		cropHintsParams.getAspectRatios().add(0.8);
		cropHintsParams.getAspectRatios().add(1d);
		cropHintsParams.getAspectRatios().add(1.2);

		request.setImageContext(imageContext);
		request.setImage(image);
		requests.getRequests().add(request);

		String json = new Gson().toJson(requests);
		try {
			String response = curling.curl(json);
			return ResponseEntity.ok(response);
		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@RequestMapping(value = "/v1/mock", method = POST)
	public void mock(HttpServletRequest req) {
	}

}