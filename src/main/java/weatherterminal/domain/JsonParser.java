package weatherterminal.domain;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JsonParser {
	private JSONParser parser;
	@Autowired
	private Weather currentWeather;

	public JsonParser() {
		this.parser = new JSONParser();
	}

	public Weather readData(String dataReceived) {
		try {
			Object jsonData = parser.parse(dataReceived);
			JSONObject root = (JSONObject) jsonData;
			JSONObject dataNode = (JSONObject) root.get("data");
			JSONArray currentConditionNode = (JSONArray) dataNode.get("current_condition");
			JSONObject condition = (JSONObject) currentConditionNode.get(0);

			currentWeather.setTemperature((String) condition.get("temp_C"));
			currentWeather.setPressure((String) condition.get("pressure"));
			currentWeather.setFeelsLikeTemperature((String) condition.get("FeelsLikeC"));
			currentWeather.setHumidity((String) condition.get("humidity"));
			currentWeather.setWindSpeed((String) condition.get("windspeedKmph"));
			currentWeather.setObservationTime((String) condition.get("observation_time"));
			JSONArray weatherDesc = (JSONArray) condition.get("weatherDesc");
			JSONObject weatherDescription = (JSONObject) weatherDesc.get(0);
			currentWeather.setWheaterDescription((String) weatherDescription.get("value"));
			JSONArray weatherIconUrl = (JSONArray) condition.get("weatherIconUrl");
			JSONObject iconUrl = (JSONObject) weatherIconUrl.get(0);
			currentWeather.setIconUrl((String) iconUrl.get("value"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return this.currentWeather;
	}

}
