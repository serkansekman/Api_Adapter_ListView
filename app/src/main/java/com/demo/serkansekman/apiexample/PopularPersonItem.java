package com.demo.serkansekman.apiexample;

/**
 * Created by serkan.sekman on 9/13/2016.
 */
public class PopularPersonItem {
    private String name;
    private String profile_path;
  //  private int poster_path;



    public PopularPersonItem(String name, String profile_path) {
        super();
        this.name = name;
        this.profile_path = profile_path;
       // this.poster_path = poster_path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }

  /*  public int getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(int poster_path) {
        this.poster_path = poster_path;
    }*/
}
