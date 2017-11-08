package weatherterminal.domain;

import org.springframework.stereotype.Component;

@Component
public class Weather {
	private String temperature;
	private String feelsLikeTemperature;
	private String pressure;
	private String humidity;
	private String iconUrl;
	private String wheaterDescription;
	private String windSpeed;
	private String observationTime;

	public String getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getFeelsLikeTemperature() {
		return feelsLikeTemperature;
	}

	public void setFeelsLikeTemperature(String feelsLikeTemperature) {
		this.feelsLikeTemperature = feelsLikeTemperature;
	}

	public String getPressure() {
		return pressure;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getWheaterDescription() {
		return wheaterDescription;
	}

	public void setWheaterDescription(String wheaterDescription) {
		this.wheaterDescription = wheaterDescription;
	}

	public String getObservationTime() {
		return observationTime;
	}

	public void setObservationTime(String observationTime) {
		this.observationTime = observationTime;
	}

	@Override
	public String toString() {
		return "Weather [temperature=" + temperature + ", feelsLikeTemperature=" + feelsLikeTemperature + ", pressure="
				+ pressure + ", humidity=" + humidity + ", iconUrl=" + iconUrl + ", wheaterDescription="
				+ wheaterDescription + ", windSpeed=" + windSpeed + ", observationTime=" + observationTime + "]";
	}

	
}
