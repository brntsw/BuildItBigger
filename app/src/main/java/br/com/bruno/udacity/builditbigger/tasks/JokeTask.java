package br.com.bruno.udacity.builditbigger.tasks;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.Joker;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.bruno.backend.myApi.MyApi;

import java.io.IOException;

import br.com.bruno.udacity.jokeandroidlib.JokeDisplayActivity;

/**
 * Created by techresult on 01/06/2016.
 */
public class JokeTask extends AsyncTask<Context, Void, String> {
    private static MyApi myApiService = null;
    private Context context;

    protected void onPreExecute(){
        super.onPreExecute();
    }

    @SafeVarargs
    @Override
    protected final String doInBackground(Context... params) {
        if(myApiService == null){
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
        }

        context = params[0];

        try {
            return myApiService.jokeDisplay(new Joker().getJoke()).execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent(context, JokeDisplayActivity.class);
        intent.putExtra("joke", result);
        context.startActivity(intent);
    }
}
