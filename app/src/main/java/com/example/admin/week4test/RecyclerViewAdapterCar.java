package com.example.admin.week4test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Admin on 9/13/2017.
 */

public class RecyclerViewAdapterCar extends RecyclerView.Adapter<RecyclerViewAdapterCar.ViewHolder> {

    RecyclerView rvCelebList;
    private RecyclerViewAdapterCar.OnViewHolderInteractionListener mListener;
    private static final String TAG = "RecyclerViewAdapterCeleb";
    List<Car> carList = new ArrayList<>();
    Context context;

    public RecyclerViewAdapterCar( List<Car> carList) {

        this.carList = carList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvName ;
        private TextView tvType ;
        private TextView tvYear ;



        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvType= itemView.findViewById(R.id.tvType);
             tvYear       = itemView.findViewById(R.id.tvYear);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //    Log.d(TAG, "onCreateViewHolder: ");
        context = parent.getContext();
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.rv_car_item, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //  Log.d(TAG, "onBindViewHolder position: "+position);
        Car car = carList.get(position);

        holder.tvName.setText(car.getModel());


        holder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener != null) {
                    //  Toast.makeText(context, position+"" , Toast.LENGTH_SHORT).show();
                    mListener.onViewHolderInteraction(String.valueOf(position));
                }
                  //  Toast.makeText(context, "click" , Toast.LENGTH_SHORT).show();
            }
        });





    }

    @Override
    public int getItemCount() {

        return carList.size();
    }

    //Dismiss
    public void dismissCar(int pos) {
        this.carList.remove(pos);
        this.notifyItemRemoved(pos);
    }


    public interface OnViewHolderInteractionListener {
        void onViewHolderInteraction(String data);
    }

    public void setListener(RecyclerViewAdapterCar.OnViewHolderInteractionListener listener) {
        this.mListener = listener;
    }
}
