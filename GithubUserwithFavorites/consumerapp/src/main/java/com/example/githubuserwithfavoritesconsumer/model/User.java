package com.example.githubuserwithfavoritesconsumer.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
    private int id;
    private String photo;
    private String name;
    private String location;
    private String company;
    private String following;
    private String followers;
    private String userName;

    public User() {

    }

    public User(int id, String username, String photoURL) {
        this.id = id;
        this.userName = username;
        this.photo = photoURL;
    }

    protected User(Parcel in) {
        name = in.readString();
        userName = in.readString();
        company = in.readString();
        location = in.readString();
        following = in.readString();
        followers = in.readString();
        photo = in.readString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //setter and getter hasil generate
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(userName);
        dest.writeString(company);
        dest.writeString(location);
        dest.writeString(followers);
        dest.writeString(following);
        dest.writeString(photo);
    }
}