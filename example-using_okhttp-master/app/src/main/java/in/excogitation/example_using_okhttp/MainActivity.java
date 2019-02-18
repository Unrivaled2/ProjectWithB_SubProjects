package in.excogitation.example_using_okhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

	ListView lv;
	ArrayAdapter<String> adapter;
	ArrayList<String> data;

	//Network wrapper class for OKHttp
	NetworkWrapper client;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//Initialize
		client = new NetworkWrapper();

		lv = (ListView) findViewById(R.id.listView);
		data = new ArrayList<String>();
		data.add("GET Request");
		data.add("POST Request");

		adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, data);
		lv.setAdapter(adapter);

		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
				switch (i) {
					case 0:
						//Make GET Req
						client.getReq("test",httpCallback);
						break;
					case 1:
						//Setup params
						HashMap<String, String> params = new HashMap<String, String>();
						params.put("Key1", "Value1");
						params.put("Key2", "Value2");
						params.put("Key3", "Value3");
						//Make POST Req
						client.postReq("test", params,httpCallback);
						break;
				}
			}
		});
	}

	Callback httpCallback=new Callback() {
		@Override
		public void onFailure(Request request, IOException e) {
			Log.e("Error", e.toString());
		}

		@Override
		public void onResponse(Response response) throws IOException {
			if (response.isSuccessful()) {
				Log.d("Response", String.valueOf(response.code()) + " | "+response.body().string());
			}
		}
	};
}
