package com.github.jemb.transit20;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DirectionService {

	private static final String DIRECTIONS_API = "https://maps.googleapis.com/maps/api/directions/json?origin=%s&destination=%s&mode=transit&key=AIzaSyAn-IzU_FRvHyyWTtfIe1vzD_RO0neMWmk";
	private static final String USER_AGENT = "Transit 2.0";

	/**
	 * @param locationName - The destination location
	 * @return a JSON object representing the directions to get from the user's current location to the destination.
	 */
	public JSONObject getDirectionsTo(String locationName) {

		return null;
	}

	/**
	 * @param locationName
	 * @return
	 */
	private String sendGetRequest(String locationName) {
		String requestURL = String.format(DIRECTIONS_API, "mylocation", locationName);
		HttpURLConnection connection;
		try {
			// Create connection
			connection = (HttpURLConnection) new URL(requestURL).openConnection();
			connection.setUseCaches(false);
			connection.setRequestProperty("User-Agent", USER_AGENT);

			// Get response
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			StringBuffer response = new StringBuffer();

			while ((line = bufferedReader.readLine()) != null) {
				response.append(line);
				response.append("\n");
			}

			bufferedReader.close();

			return response.toString();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//TODO: Change?
		return "";
	}
}