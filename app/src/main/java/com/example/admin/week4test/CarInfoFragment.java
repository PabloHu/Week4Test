package com.example.admin.week4test;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



public class CarInfoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private static final String CAR_PARAM = "carList";

    // TODO: Rename and change types of parameters

    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    Car car;
    private TextView tvModel ;
    private TextView tvType;
    private TextView tvYear;

    private OnFragmentInteractionListener mListener;

    public CarInfoFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CarInfoFragment newInstance(Car car) {



        CarInfoFragment fragment = new CarInfoFragment();
        Bundle args = new Bundle();
        args.putParcelable(CAR_PARAM, car);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            car = getArguments().getParcelable(CAR_PARAM);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvModel = view.findViewById(R.id.tvModel);
        tvType = view.findViewById(R.id.tvType);
        tvYear = view.findViewById(R.id.tvYear);



    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tvModel.setText(car.getModel());
        tvType.setText(String.valueOf(car.getType()));
        tvYear.setText(String.valueOf(String.valueOf(car.getYear())));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_car_info, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String data) {
        if (mListener != null) {
            mListener.onFragmentInteraction(data);
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


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String uri);
        void sendDataToActivity(String data);
    }
}
