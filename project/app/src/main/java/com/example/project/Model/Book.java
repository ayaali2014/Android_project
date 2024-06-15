package com.example.project.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {
    private String title,desc,rate,cost;
    private int image;

    protected Book(Parcel in) {
        title = in.readString();
        desc = in.readString();
        rate = in.readString();
        cost = in.readString();
        image = in.readInt();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Book(String title, String desc, String rate,String cost,int image) {
        this.title = title;
        this.desc = desc;
        this.rate = rate;
        this.cost=cost;
        this.image=image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(desc);
        dest.writeString(rate);
        dest.writeString(cost);
        dest.writeInt(image);
    }
}
