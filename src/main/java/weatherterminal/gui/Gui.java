package weatherterminal.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.springframework.stereotype.Component;

import weatherterminal.domain.Weather;

@Component
public class Gui extends JFrame {
	private JPanel iconPanel, labelPanel;
	private JLabel description, icon, temperature, feelsLikeTemperature, humidity, pressure, windSpeed, time;
	private Box box;

	public Gui() {
		iconPanel = new JPanel();
		labelPanel = new JPanel();
		description = new JLabel();
		icon = new JLabel();
		temperature = new JLabel();
		feelsLikeTemperature = new JLabel();
		humidity = new JLabel();
		pressure = new JLabel();
		windSpeed = new JLabel();
		time = new JLabel();
		box = Box.createVerticalBox();

		iconPanel.setLayout(new BorderLayout());
		description.setHorizontalAlignment(JLabel.CENTER);
		icon.setHorizontalAlignment(JLabel.CENTER);
		iconPanel.setBackground(Color.LIGHT_GRAY);
		iconPanel.add(description, BorderLayout.NORTH);
		iconPanel.add(icon, BorderLayout.CENTER);
		labelPanel.setBackground(Color.LIGHT_GRAY);

		box.add(temperature);
		box.add(feelsLikeTemperature);
		box.add(humidity);
		box.add(pressure);
		box.add(windSpeed);

		labelPanel.add(box);

		this.add(this.labelPanel, BorderLayout.WEST);
		this.add(this.iconPanel, BorderLayout.CENTER);

		this.setTitle("Current weather conditions");
		this.setSize(325, 120);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		BufferedImage programIcon;
		try {
			programIcon = ImageIO
					.read(new URL("http://icons.iconarchive.com/icons/wineass/ios7-redesign/512/Weather-icon.png"));
			ImageIcon mainIcon = new ImageIcon(programIcon);
			this.setIconImage(mainIcon.getImage());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.setVisible(false);
	}

	public void showGui(Weather currentWeather) {

		BufferedImage previewImage;
		try {
			previewImage = ImageIO.read(new URL(currentWeather.getIconUrl()));
			icon.setIcon(new ImageIcon(previewImage));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		description.setText(currentWeather.getWheaterDescription());

		time.setText(currentWeather.getObservationTime());
		temperature.setText("Temperature : " + currentWeather.getTemperature() + " \u2103");
		feelsLikeTemperature
				.setText("Feels like temperature : " + currentWeather.getFeelsLikeTemperature() + " \u2103");
		humidity.setText("Humidity : " + currentWeather.getHumidity() + " %");
		pressure.setText("Pressure : " + currentWeather.getPressure() + " hPa");
		windSpeed.setText("Wind speed : " + currentWeather.getWindSpeed() + " km/h");

		this.setVisible(true);
	}

//	public void setIconPanel(JPanel iconPanel) {
//		this.iconPanel = iconPanel;
//	}
//
//	public void setLabelPanel(JPanel labelPanel) {
//		this.labelPanel = labelPanel;
//	}
//
//	public void setDescription(JLabel description) {
//		this.description = description;
//	}
//
//	public void setIcon(JLabel icon) {
//		this.icon = icon;
//	}
//
//	public void setTemperature(JLabel temperature) {
//		this.temperature = temperature;
//	}
//
//	public void setFeelsLikeTemperature(JLabel feelsLikeTemperature) {
//		this.feelsLikeTemperature = feelsLikeTemperature;
//	}
//
//	public void setHumidity(JLabel humidity) {
//		this.humidity = humidity;
//	}
//
//	public void setPressure(JLabel pressure) {
//		this.pressure = pressure;
//	}
//
//	public void setWindSpeed(JLabel windSpeed) {
//		this.windSpeed = windSpeed;
//	}
//
//	public void setBox(Box box) {
//		this.box = box;
//	}
}
