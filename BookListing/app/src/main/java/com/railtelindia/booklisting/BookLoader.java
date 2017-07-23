package com.railtelindia.booklisting;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by Devesh Chaturvedi on 031-31-05-2017.
 */

public class BookLoader extends AsyncTaskLoader<List<Book>> {
    String Url;
    public BookLoader(Context context, String url) {
        super(context);
        Url=url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Book> loadInBackground() {
        if (Url.length() < 1 || Url == null) {
            return null;
        }
        List<Book> result = QueryBook.fetchBookData(Url);
        return result;
    }
}
