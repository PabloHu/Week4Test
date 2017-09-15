package com.example.admin.week4test;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Admin on 9/15/2017.
 */

public class Car implements Parcelable {
    String Model;
    String Type;
    int year;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Model);
        dest.writeString(this.Type);
        dest.writeInt(this.year);
    }

    public Car() {
    }

    protected Car(Parcel in) {
        this.Model = in.readString();
        this.Type = in.readString();
        this.year = in.readInt();
    }

    public static final Parcelable.Creator<Car> CREATOR = new Parcelable.Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel source) {
            return new Car(source);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

    public Car(String model, String type, int year) {
        Model = model;
        Type = type;
        this.year = year;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static Creator<Car> getCREATOR() {
        return CREATOR;
    }
}
