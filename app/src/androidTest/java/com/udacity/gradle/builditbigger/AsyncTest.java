package com.udacity.gradle.builditbigger;



import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;



import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertNotNull;


/**
 * Created by pulkitnarwani on 27/01/17.
 */

@RunWith(AndroidJUnit4.class)
public class AsyncTest{

   @Rule
   public ActivityTestRule rule=new ActivityTestRule(MainActivity.class,false,false);

    @Test
    public void testNull () throws Exception {

        JokeTask a=new JokeTask();
        if(rule.getActivity()==null){
            rule.launchActivity(new Intent());
        }
        assertNotNull(a.doInBackground(rule.getActivity().getApplicationContext()));



    }
}
