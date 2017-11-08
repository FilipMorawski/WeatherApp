package weatherterminal.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Refresher implements Runnable {
	@Autowired
	private Controller controller;

	public void run() {
		controller.printWeather();
	}

}
