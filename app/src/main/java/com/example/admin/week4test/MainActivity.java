package com.example.admin.week4test;

import android.net.Uri;
import android.support.v4.app.FragmentActivity;


import java.util.ArrayList;
import java.util.List;


import android.os.Bundle;
import android.view.View;
import android.widget.Toast;



public class MainActivity extends FragmentActivity implements
        CarListFragment.OnFragmentInteractionListener, CarInfoFragment.OnFragmentInteractionListener{

    private static final String CAR_INFO_FRAGMENT_TAG = "carInfoRAG";
    private static final String CAR_OPTIONS_FRAGMENT_TAG = "carfragRAG";
    private static final String TAG = "MainActivityTag";
    List<Car> carList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoFillData();
        addCarFragments();

    }



    private void addCarFragments() {

        CarInfoFragment carInfoFragment = CarInfoFragment.newInstance(carList.get(0));
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flFragHolderCarDetails, carInfoFragment, CAR_INFO_FRAGMENT_TAG)
                .addToBackStack(CAR_INFO_FRAGMENT_TAG)

                .commit();

        CarListFragment carListFragment  = CarListFragment.newInstance((carList));
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flFragHolderCarOptions, carListFragment, CAR_OPTIONS_FRAGMENT_TAG)
                .addToBackStack(CAR_OPTIONS_FRAGMENT_TAG)

                .commit();

    }



    private void autoFillData() {
        carList.clear();
        Car car;
        car = new Car("Ford", "Coupe", 2017);
        carList.add(car);
        car = new Car("Mazda", "truck", 2016);
        carList.add(car);
        car = new Car("Nissan", "Sports car", 2015);
        carList.add(car);
        car = new Car("Toyota", "Standard", 2014);
        carList.add(car);
    }





    @Override
    public void sendDataToActivity(String data) {

    }

    @Override
    public void onFragmentInteraction(String uri) {
           Toast.makeText(this, uri, Toast.LENGTH_SHORT).show();

        int position = Integer.parseInt(uri);

        CarInfoFragment carInfoFragment = CarInfoFragment.newInstance(carList.get(position));
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flFragHolderCarDetails, carInfoFragment, CAR_INFO_FRAGMENT_TAG)
                .addToBackStack(CAR_INFO_FRAGMENT_TAG)

                .commit();

    }




}
