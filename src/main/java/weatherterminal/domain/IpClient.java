package weatherterminal.domain;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IpClient {
	@Autowired
	private RestService rest;

	private final String url = "https://api.ipify.org?format=text";
	
	public String getIp() {
		String ip = rest.getForObject(url, String.class);
		return ip;
	}

}
