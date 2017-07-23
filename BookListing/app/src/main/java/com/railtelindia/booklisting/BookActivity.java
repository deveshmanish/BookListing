package com.railtelindia.booklisting;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class BookActivity extends AppCompatActivity {

    private static final String LOG_TAG = BookActivity.class.getSimpleName();
    private static final String URL_QUERY = "https://www.googleapis.com/books/v1/volumes?q=";
    String URL_SEARCH,jsonResponse=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        Button searchButton = (Button) findViewById(R.id.search_button);
        final TextInputEditText searchText = (TextInputEditText) findViewById(R.id.search_text);
        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                URL_SEARCH = URL_QUERY + searchText.getText().toString();
                new bookAsyncTask().execute(URL_SEARCH);
                Log.i(LOG_TAG,"This is executed");

            }

        });
        // Get a reference to the LoaderManager, in order to interact with loaders.

    }
    private class bookAsyncTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... Url) {
            if (Url[0].length() < 1 || Url[0] == null) {
                return null;
            }
            Log.e(LOG_TAG,Url[0]);
            String response = QueryBook.fetchBookResource(Url[0]);
            Log.e(LOG_TAG,"this is the json"+response);
            jsonResponse = response;
            return response;
        }

        @Override
        protected void onPostExecute(String result) {
            Log.i(LOG_TAG,"Post Execute"+result);
            Intent intent = new Intent(BookActivity.this, BookListActivity.class);
            intent.putExtra("json",result);
            startActivity(intent);
        }
    }

}
