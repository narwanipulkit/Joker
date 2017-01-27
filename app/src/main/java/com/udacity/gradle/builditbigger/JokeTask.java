package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.example.pulkitnarwani.myapplication.backend.myJokeApi.MyJokeApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import pn3.jokeshow.JokeActivity;

/**
 * Created by pulkitnarwani on 27/01/17.
 */

public class JokeTask extends AsyncTask<Context,Integer,String> {

    private MyJokeApi myApiService = null;
    Context c;
    @Override
    protected String doInBackground(Context... contexts) {
        c=contexts[0];
        try {
            if (myApiService == null) {
                MyJokeApi.Builder builder = new MyJokeApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                        .setRootUrl("https://joke-156809.appspot.com/_ah/api/")
                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                                request.setDisableGZipContent(true);
                            }
                        });
                myApiService = builder.build();
            }

            return myApiService.getMyJoke("2").execute().getData();

        }catch (IOException e){
            Log.e("e",e.toString());
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Intent i=new Intent(c, JokeActivity.class);
        i.putExtra("joke",s);
        c.startActivity(i);

    }
}
