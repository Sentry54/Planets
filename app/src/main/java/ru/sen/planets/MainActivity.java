package ru.sen.planets;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ListView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static ArrayList<String> listNamePlanets, listDscPlanets;
    private static TypedArray listImgPlanets;
    private static ArrayList<Profile> plants = new ArrayList<>();
    Resources res;
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    private static ArrayList<Profile> loadData() {
        for (int i = 0; i < listNamePlanets.size(); i++) {
            plants.add(new Profile(listImgPlanets.getResourceId(i, 0), listNamePlanets.get(i), listDscPlanets.get(i)));
        }
        return plants;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        listNamePlanets = new ArrayList<>(Arrays.asList(res.getStringArray(R.array.txt_array_planets)));
        listDscPlanets = new ArrayList<>(Arrays.asList(res.getStringArray(R.array.txt_array_dsc_planets)));
        listImgPlanets = res.obtainTypedArray(R.array.array_img_planet);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         **/
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView;
            switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
                case 0:
                    rootView = inflater.inflate(R.layout.fragment_tab_1, container, false);
                    ListView lv = (ListView) rootView.findViewById(R.id.listView);
                    ListViewAdapter lvAdapter = new ListViewAdapter(loadData());
                    lv.setAdapter(lvAdapter);
                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            //TODO создание фрагмента с алерт диалогом для отображения инфы о планете
                            DataFragment dataFragment = DataFragment.newInstance(view);
                            dataFragment.show(getFragmentManager(), "dataFragment");

                        }
                    });
                    return rootView;
                case 1:
                    rootView = inflater.inflate(R.layout.fragment_tab_2, container, false);

                    return rootView;
                case 2:
                    rootView = inflater.inflate(R.layout.fragment_tab_3, container, false);

                    return rootView;
            }

            //View rootView = inflater.inflate(R.layout.fragment_tab_1, container, false);
            //TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return null;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position);
        }


        @Override
        public int getCount() {
            // Show 3 total pages.
            //return 3;

            return res.getInteger(R.integer.number_pages);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.tabs_1);
                case 1:
                    return getString(R.string.tabs_2);
                case 2:
                    return getString(R.string.tabs_3);
            }
            return null;
        }
    }
}
