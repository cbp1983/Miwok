package com.example.android.miwok;

import android.app.Activity;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bricktop on 2018-02-25.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceID;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceID) {
        super(context, 0, words);
        mColorResourceID = colorResourceID;
    }

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();

    //Override getView
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        //This looks for which view to display. If outside view, not shown

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the English or default word
        TextView defaultLanguageView = (TextView) listItemView.findViewById(R.id.default_text_view);

        // Get the version name from the current Word object and
        // set this text on the Word TextView
        defaultLanguageView.setText(currentWord.getDefaultTranslation());

        // Find the TextView in the list_item.xml layout with the Miwok translation
        TextView miwokView = (TextView) listItemView.findViewById(R.id.miwok_text_view);

        // Get the version number from the current Word object and
        // set this text on the number TextView
        miwokView.setText(currentWord.getMiwokTranslation());

        // Find the ImageView in the list_item.xml layout for words
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        // Check if an image is provided for this word or not
        if (currentWord.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentWord.getImageResourceID());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceID);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }

}