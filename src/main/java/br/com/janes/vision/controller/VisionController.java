package br.com.janes.vision.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.janes.vision.domain.Requests;

@Configuration
@EnableAutoConfiguration
@RestController
public class VisionController {

    public VisionController() {

    }
    
    private Curling curling = new Curling();

	@RequestMapping(value = "/v1/images", method = POST)
	public @ResponseBody ResponseEntity<String> annotate(@RequestBody Requests visionRequest) {
		String json = new Gson().toJson(visionRequest);
		try {
			return ResponseEntity.ok(curling.curl(json));
		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

    public static void main(String[] args) {
        SpringApplication.run(VisionController.class, args);
    }


}