package com.railtelindia.booklisting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Devesh Chaturvedi on 031-31-05-2017.
 */

public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(Context context, List<Book> users){
        super(context,0,users);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Book book = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        // Lookup view for data population
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView author = (TextView) convertView.findViewById(R.id.authors);
        TextView description = (TextView) convertView.findViewById(R.id.description);
        TextView rating = (TextView) convertView.findViewById(R.id.rating);

        // Populate the data into the template view using the data object

        title.setText(book.getmBookTitle());
        author.setText(book.getmBookAuthors());
        description.setText(book.getmBookDescription());
        rating.setText(String.valueOf(book.getmAverageRating()));
        // Return the completed view to render on screen
        return convertView;
    }
}
