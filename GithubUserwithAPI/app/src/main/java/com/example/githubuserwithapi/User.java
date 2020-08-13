package com.example.githubuserwithapi;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String photo;
    private String name;
    private String location;
    private String company;
    private String repository;
    private String following;
    private String followers;
    private String userName;

    public User() {

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

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
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

    protected User(Parcel in) {
        name = in.readString();
        userName = in.readString();
        company = in.readString();
        location = in.readString();
        following = in.readString();
        followers = in.readString();
        photo = in.readString();
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
        dest.writeString(repository);
        dest.writeString(followers);
        dest.writeString(following);
        dest.writeString(photo);
    }

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
}