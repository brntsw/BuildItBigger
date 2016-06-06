package br.com.bruno.udacity.builditbigger;

import android.content.Context;
import android.test.AndroidTestCase;
import android.test.mock.MockContext;
import android.util.Pair;

import java.util.concurrent.ExecutionException;

import br.com.bruno.udacity.builditbigger.tasks.JokeTask;

/**
 * Created by Bruno on 05/06/2016.
 */
public class AsyncAndroidTest extends AndroidTestCase {

    public void testAsyncResponse() throws ExecutionException, InterruptedException {
        assertNotNull("", new JokeTask().execute(new Pair<Context, String>(new MockContext(), "Test")).get());
    }

}
