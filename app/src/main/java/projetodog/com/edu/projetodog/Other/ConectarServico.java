package projetodog.com.edu.projetodog.Other;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import projetodog.com.edu.projetodog.interfaces.RetornoStringWebService;

/**
 * Created by edu-f on 14/07/2017.
 */

public class ConectarServico extends AsyncTask<String, Void, String>{

    ProgressDialog load;
    Context c;
    RetornoStringWebService r;

    public ConectarServico(Context c,RetornoStringWebService r){
        this.c = c;
        this.r = r;
    }


    @Override
    protected void onPreExecute(){
        Log.i("AsyncTask", "Exibindo ProgressDialog na tela Thread: " + Thread.currentThread().getName());
        load = ProgressDialog.show(c, "Por favor Aguarde ...",
                "Baixando Imagem ...");
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://192.168.123.2/teste")
                    .build();

            Response response = client.newCall(request).execute();

            if (response.code() != 200) {
                return null;
            } else {
                String body = response.body().string();
                return body;
            }
        }catch (Exception e){
            Log.i("Exception", e+"");
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Log.i("Script","Asynctask = "+result);

        load.dismiss();
        r.retornoStrongWebService(result);



    }

}