package weatherterminal.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherClient {
	@Autowired
	private JsonParser jsonParser;
	@Autowired
	private RestService rest;
	private final String urlBeginning = "http://api.worldweatheronline.com/premium/v1/weather.ashx?"
			+ "key=234ff3780c964e3688a162956170611&q=";
	private final String urlEnding = "&num_of_days=2&tp=3&format=json";

	public Weather getWeather(String ip) {
		String request = urlBeginning + ip + urlEnding;
		String dataReceived = rest.getForObject(request, String.class);
		Weather currentWheater = jsonParser.readData(dataReceived);

		return currentWheater;
	}

}
