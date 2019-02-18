package in.excogitation.example_using_okhttp;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

import java.util.HashMap;

/**
 * @author Nishant Srivastava
 * @project example-using_okhttp
 * @package in.excogitation.example_using_okhttp
 * @date 22/06/15
 */
public class NetworkWrapper {
	OkHttpClient client;
	final String SERVER = "http://xxx.xxxxxxx.xxx/";

	public NetworkWrapper() {
		client = new OkHttpClient();
	}

	public void postReq(String urlHandle, HashMap<String, String> params,Callback callback) {
		FormEncodingBuilder formdata = new FormEncodingBuilder();
		for (String param : params.keySet()) {
			formdata.add(param, params.get(param));
		}
		RequestBody formBody = formdata.build();

		Request request = new Request.Builder()
				.url(SERVER + urlHandle)
				.post(formBody)
				.build();

		Call call1 = client.newCall(request);
		call1.enqueue(callback);

	}

	public void getReq(String urlHandle,Callback callback) {

		Request req = new Request.Builder().url(SERVER + urlHandle).build();
		Call call = client.newCall(req);
		call.enqueue(callback);

	}

}
