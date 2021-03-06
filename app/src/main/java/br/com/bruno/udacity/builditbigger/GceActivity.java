package br.com.bruno.udacity.builditbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import br.com.bruno.udacity.builditbigger.tasks.JokeTask;

public class GceActivity extends AppCompatActivity {

    private TextView tvGce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gce);

        tvGce = (TextView) findViewById(R.id.tv_gce_joke);
    }

    protected void onResume(){
        super.onResume();

        new JokeTask().execute(this);

        //Setar o texto no onPostExecute da task
        tvGce.setText("");
    }
}
