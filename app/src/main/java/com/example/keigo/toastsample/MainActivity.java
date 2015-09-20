package com.example.keigo.toastsample;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    private static Toast toast = null;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new MyAsyncTask().execute("toast 1");
        new MyAsyncTask().execute("toast 2");
        new MyAsyncTask().execute("toast 3");
    }

    public void showToast(String msg) {
        if (toast == null) {
            toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }

    private class MyAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... msg) {
            return msg[0];
        }

        @Override
        protected void onPostExecute(String msg) {
            showToast(msg);
        }
    }
}
