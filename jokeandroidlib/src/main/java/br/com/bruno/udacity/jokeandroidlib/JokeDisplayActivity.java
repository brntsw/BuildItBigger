package br.com.bruno.udacity.jokeandroidlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        Bundle bundle = getIntent().getExtras();
        String joke = bundle.getString("joke");

        TextView tvJoke = (TextView) findViewById(R.id.tv_joke);
        assert tvJoke != null;
        tvJoke.setText(joke);
    }
}
