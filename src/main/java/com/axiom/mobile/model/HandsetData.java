package com.axiom.mobile.model;
public class HandsetData
{
    private String phone;

    private Release release;

    private String sim;

    private String id;

    private String brand;

    private String resolution;

    private String picture;

    private Hardware hardware;

    public String getPhone ()
    {
        return phone;
    }

    public void setPhone (String phone)
    {
        this.phone = phone;
    }

    public Release getRelease ()
    {
        return release;
    }

    public void setRelease (Release release)
    {
        this.release = release;
    }

    public String getSim ()
    {
        return sim;
    }

    public void setSim (String sim)
    {
        this.sim = sim;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getBrand ()
    {
        return brand;
    }

    public void setBrand (String brand)
    {
        this.brand = brand;
    }

    public String getResolution ()
    {
        return resolution;
    }

    public void setResolution (String resolution)
    {
        this.resolution = resolution;
    }

    public String getPicture ()
    {
        return picture;
    }

    public void setPicture (String picture)
    {
        this.picture = picture;
    }

    public Hardware getHardware ()
    {
        return hardware;
    }

    public void setHardware (Hardware hardware)
    {
        this.hardware = hardware;
    }

    @Override
    public String toString()
    {
        return "[phone = "+phone+", release = "+release+", sim = "+sim+", id = "+id+", brand = "+brand+", resolution = "+resolution+", picture = "+picture+", hardware = "+hardware+"]";
    }
}