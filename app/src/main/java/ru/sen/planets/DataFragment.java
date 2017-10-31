package ru.sen.planets;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class DataFragment extends AppCompatDialogFragment {

    public static String mPlanetName = "planet name";
    public static String mPlanetDescription = "planet description";
    public static String mPlanetImage = "planet image";

    public static DataFragment newInstance(Profile planet) {
        DataFragment fragment = new DataFragment();
        Bundle args = new Bundle();
        args.putString(mPlanetName, planet.getNamePlanet());
        args.putString(mPlanetDescription, planet.getDscPlanet());
        args.putInt(mPlanetImage, planet.getImgPlanet());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dataView = inflater.inflate(R.layout.data_layout, null);

        ImageView dataImagePlanet = (ImageView) dataView.findViewById(R.id.data_imageView);
        dataImagePlanet.setImageResource(getArguments().getInt(mPlanetImage));

        TextView dataNamePlanet = (TextView) dataView.findViewById(R.id.data_planet_dsc);
        dataNamePlanet.setText(getArguments().getString(mPlanetDescription));

        builder.setView(dataView)
                .setTitle(getArguments().getString(mPlanetName))
                .setPositiveButton(getString(R.string.txt_data_btn_positive), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getDialog().cancel(); ;
                    }
                });

        return builder.create();
    }
}
