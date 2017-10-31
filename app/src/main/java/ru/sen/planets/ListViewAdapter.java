package ru.sen.planets;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ListViewAdapter extends BaseAdapter {

    private ArrayList<Profile> profiles;

    public ListViewAdapter(ArrayList<Profile> profiles) {
        this.profiles = profiles;
    }

    @Override
    public int getCount() {
        return profiles.size();
    }

    @Override
    public Object getItem(int position) {
        return profiles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) convertView = View.inflate(parent.getContext(), R.layout.list_view_layout, null);

        ImageView imgPlanet = (ImageView) convertView.findViewById(R.id.list_imageView);
        imgPlanet.setImageResource(profiles.get(position).getImgPlanet());

        TextView namePlanet = (TextView) convertView.findViewById(R.id.list_txt_name_planet);
        namePlanet.setText(profiles.get(position).getNamePlanet());

        TextView dscPlanet = (TextView) convertView.findViewById(R.id.list_txt_dsc_planet);
        dscPlanet.setText(profiles.get(position).getDscPlanet());

        return convertView;
    }
}
