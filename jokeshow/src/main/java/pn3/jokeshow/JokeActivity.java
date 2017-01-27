package pn3.jokeshow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    String j;
    TextView joke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        joke=(TextView)findViewById(R.id.joke);
        j=getIntent().getExtras().getString("joke");
        joke.setText(j);
    }
}
