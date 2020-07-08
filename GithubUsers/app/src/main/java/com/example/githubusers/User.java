package com.example.githubusers;

class User {
    private int photo;
    private String name;
    private String location;
    private String company;
    private String repository;
    private String following;
    private String followers;
    private String userName;

    //setter and getter hasil generate
    public int getPhoto() {
        return photo;
    }
    public void setPhoto(int photo) {
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
}
