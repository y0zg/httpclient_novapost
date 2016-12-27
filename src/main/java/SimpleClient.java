// // This sample uses the Apache HTTP client from HTTP Components (http://hc.apache.org/httpcomponents-client-ga/)
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class SimpleClient
{
	public static void main(String[] args)
	{
		HttpClient httpclient = HttpClients.createDefault();

		try
		{
			URIBuilder builder = new URIBuilder("http://testapi.novaposhta.ua/v2.0/json/Address/getAreas");


			URI uri = builder.build();
			HttpPost request = new HttpPost(uri);
			request.setHeader("Content-Type", "application/json");


			// Request body
			StringEntity reqEntity = new StringEntity("{\"apiKey\": \"fab4d55103bf8c43c39ab9989b3ff1d3\",\n" +
					"\"modelName\": \"Address\",\n" +
					"\"calledMethod\": \"getAreas\",\n" +
					"\"methodProperties\": {}}");
			request.setEntity(reqEntity);

			HttpResponse response = httpclient.execute(request);
			HttpEntity entity = response.getEntity();

			if (entity != null)
			{
				System.out.println(EntityUtils.toString(entity));
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}