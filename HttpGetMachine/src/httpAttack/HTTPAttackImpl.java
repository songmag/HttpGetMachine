package httpAttack;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

public class HTTPAttackImpl implements HTTPAttack {
	private HttpGet getRequest;
	private static HttpClient client;
	public HTTPAttackImpl(String url) {
		getRequest = new HttpGet(url);
	}
	
	public void runAttack(int count) {
		for(int i =0;i<count;i++)
		{
		client = HttpClients.createDefault();
		try {
			System.out.println(client.execute(getRequest));
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
