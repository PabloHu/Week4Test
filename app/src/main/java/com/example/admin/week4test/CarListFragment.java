package com.example.admin.week4test;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;



public class CarListFragment extends Fragment implements RecyclerViewAdapterCar.OnViewHolderInteractionListener{
    private static final String PARAM_CAR = "carListPar";
    public static final String TAG = "RedFragmantTAG";
    // TODO: Rename and change types of parameters

    RecyclerView rvCarList;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    List<Car> carList = new ArrayList<>();
    //ToggleButton toggleButton ;

    private OnFragmentInteractionListener mListener;

    public CarListFragment() {

    }


    // TODO: Rename and change types and number of parameters
    public static CarListFragment newInstance(List<Car> carList) {



        CarListFragment fragment = new CarListFragment();
        Bundle args = new Bundle();

        try {
            args.putParcelableArrayList(PARAM_CAR, (ArrayList<? extends Parcelable>) carList);
            Log.d(TAG, "newInstance: "+ "parcelable work!!");
        }
        catch (Exception e){
            Log.d(TAG, "newInstance: "+ e.toString());
        }
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            carList = getArguments().getParcelableArrayList(PARAM_CAR);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvCarList = view.findViewById(R.id.rvCarList);
      //  toggleButton = view.findViewById(R.id.toggle_button_id);

        // famousRecyclerView = view.findViewById(R.id.recycler_view_fragment_left);
        //I need to receive by paremeter the layout manager then a switch to select the correct one




    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



        RecyclerViewAdapterCar adapter = new RecyclerViewAdapterCar(carList);
        adapter.setListener(this);
        rvCarList.setAdapter(adapter);




        layoutManager = new LinearLayoutManager(getContext());
        rvCarList.setLayoutManager(layoutManager);
        rvCarList.setLayoutManager(layoutManager);

        itemAnimator = new DefaultItemAnimator();
        rvCarList.setLayoutManager(layoutManager);
        rvCarList.setItemAnimator(itemAnimator);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_car_list, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String data) {
        if (mListener != null) {
            mListener.onFragmentInteraction(data);
            // Toast.makeText(getContext(), "RedFrag"+data, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onViewHolderInteraction(String data) {
        onButtonPressed(data);
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String uri);
        void sendDataToActivity(String data);
    }

    @Override
    public void onStop() {
        super.onStop();
        //  Toast.makeText(getContext(), "onstop", Toast.LENGTH_SHORT).show();
        carList.clear();
    }
}
