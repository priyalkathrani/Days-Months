package com.example.days_and_months.COLOR;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.days_and_months.DAYS.Day;
import com.example.days_and_months.DAYS.DayAdpater;
import com.example.days_and_months.R;

import java.util.ArrayList;

public class ColorAdapter extends ArrayAdapter<Color> {
    private static final String LOG_TAG = ColorAdapter.class.getSimpleName();

    public ColorAdapter(Activity context, ArrayList<Color> colors) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, colors);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.color_layout_file, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Color currentcolorname = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.color_txt);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentcolorname.getColorsName());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
