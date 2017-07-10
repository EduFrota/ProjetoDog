package projetodog.com.edu.projetodog.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import projetodog.com.edu.projetodog.R;

public class SearchActivity extends AppCompatActivity {
    EditText editTRaca;
    EditText editTTemperamento;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        editTRaca = (EditText)findViewById(R.id.editText_S_Raça);
        editTTemperamento = (EditText)findViewById(R.id.editText_s_teperamento);
        bt = (Button) findViewById(R.id.button_buscar);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Clique", "Clique ok!");
                Toast.makeText(SearchActivity.this, "Clicou", Toast.LENGTH_LONG).show();

                String readTwitterFeed = readTwitterFeed();
                try {
                    JSONArray jsonArray = new JSONArray(readTwitterFeed);
                    Log.i("script", "Number of entries " + jsonArray.length());
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Log.i("script", jsonObject.getString("nome"));
                    }
                } catch (Exception e) {
                    Log.i("Scrip", ""+e);
                }

            }
        });

    }

    public String readTwitterFeed() {
        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://10.0.3.2:8080/teste")
                    .build();

            Response response = client.newCall(request).execute();

            if (response.code() != 200) {
                return null;
            } else {
                String body = response.body().string();
                return body;
            }
        }catch (Exception e){
            return null;
        }
    }

}
