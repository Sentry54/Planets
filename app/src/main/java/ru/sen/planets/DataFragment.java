package ru.sen.planets;

import android.app.Dialog;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;


public class DataFragment extends AppCompatDialogFragment {

    public static String mPlanetName = "planet name";
    //public static String mPlanetDescription = "planet description";
    //public static String mPlanetImage = "planet image";
    //private static String ARG_SELECTED_ITEM = "selected item";

    public static DataFragment newInstance(View view) {
        DataFragment fragment = new DataFragment();
        Bundle args = new Bundle();
        args.putString(mPlanetName, ((TextView) view).getText());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.data_layout, null))
                .setTitle(getArguments().getString(mPlanetName));
        //TextView

        ListFragment
        return super.onCreateDialog(savedInstanceState);
    }
}
