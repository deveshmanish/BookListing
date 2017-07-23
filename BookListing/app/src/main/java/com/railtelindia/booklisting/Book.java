package com.railtelindia.booklisting;

/**
 * Created by Devesh Chaturvedi on 031-31-05-2017.
 */

public class Book {

    private double mAverageRating;
    private String mBookTitle;
    private String mBookAuthors;
    private String mBookDescription;
    private String mBookUrl;

    public Book(double averageRating,String bookTitle,String bookAuthors,String bookDescription,String bookUrl){

        mAverageRating = averageRating;
        mBookTitle = bookTitle;
        mBookAuthors = bookAuthors;
        mBookDescription = bookDescription;
        mBookUrl = bookUrl;
    }

    public double getmAverageRating() {
        return mAverageRating;
    }

    public String getmBookTitle() {
        return mBookTitle;
    }

    public String getmBookAuthors() {
        return mBookAuthors;
    }

    public String getmBookDescription() {
        return mBookDescription;
    }

    public String getmBookUrl() {
        return mBookUrl;
    }
}
