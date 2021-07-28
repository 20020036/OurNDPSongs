package sg.edu.rp.c346.id20020036.ourndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Song> versionList;

    public CustomAdapter(Context context, int resource, ArrayList<Song> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        versionList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater)parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvTitle = rowView.findViewById(R.id.tvTitle);
        TextView tvYear = rowView.findViewById(R.id.tvYear);

        TextView tvSinger = rowView.findViewById(R.id.tvSinger);
        RatingBar rb = rowView.findViewById(R.id.ratingBar);
        ImageView iv = rowView.findViewById(R.id.iv);

        Song currentVersion = versionList.get(position);

        int year = Integer.parseInt(currentVersion.getYearReleased());
        tvTitle.setText(currentVersion.getTitle());
        tvYear.setText(currentVersion.getYearReleased());
        if(year < 2019)
        {
            iv.setVisibility(View.INVISIBLE);
        }

        tvSinger.setText(currentVersion.getSingers());
        rb.setRating(currentVersion.getStars());

        return rowView;
    }

}

