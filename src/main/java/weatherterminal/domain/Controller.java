package weatherterminal.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import weatherterminal.gui.Gui;

@Component
public class Controller {
	@Autowired
	private IpClient ipClient;
	@Autowired
	private WeatherClient weatherClient;
	@Autowired
	private Gui gui;

	public void printWeather() {
		Weather currentWeather;
		currentWeather = weatherClient.getWeather(ipClient.getIp());
		gui.showGui(currentWeather);
	}

	public void repaint() {
		gui.repaint();
	}
}
