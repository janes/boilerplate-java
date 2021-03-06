package br.com.janes.vision.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

@Component
public class Curling {

	private static final String URL = "https://vision.googleapis.com/v1/images:annotate?";
	private static final String KEY = new String(Base64Utils.decodeFromString("a2V5PUFJemFTeUJ6ZWdoaTBXN21HY3phcDhTQzhBbU51ZFlPbHdmVS1LRQ=="));
	// private static final String URL = "http://95345402.ngrok.io/v1/mock";

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.janes.vision.controller.Curling#curl(java.lang.String)
	 */
	public String curl(String data) throws IOException {

		ProcessBuilder pb = new ProcessBuilder("curl", "-s", URL + KEY, "-H", "pragma: no-cache", "-H",
				"origin: https://cloud.google.com", "-H", "accept-encoding: gzip, deflate", "-H",
				"accept-language: pt-BR,pt;q=0.8,en-US;q=0.6,en;q=0.4,es;q=0.2", "-H",
				"user-agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.87 Safari/537.36",
				"-H", "content-type: text/plain;charset=UTF-8'", "-H", "accept: */*", "-H", "cache-control: no-cache",
				"-H", "authority: vision.googleapis.com", "-H", "referer: https://cloud.google.com/vision/",
				"--data-binary", data, "--compressed");

		pb.redirectErrorStream(true);
		Process p = pb.start();
		InputStream is = p.getInputStream();
		String read = read(is);
		return read;
	}

	public static String read(InputStream input) throws IOException {
		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(input))) {
			return buffer.lines().collect(Collectors.joining("\n"));
		}
	}
}