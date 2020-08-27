package com.axiom.mobile.model;
public class Release
{
    private String priceEur;

    private String announceDate;

    public String getPriceEur ()
    {
        return priceEur;
    }

    public void setPriceEur (String priceEur)
    {
        this.priceEur = priceEur;
    }

    public String getAnnounceDate ()
    {
        return announceDate;
    }

    public void setAnnounceDate (String announceDate)
    {
        this.announceDate = announceDate;
    }

    @Override
    public String toString()
    {
        return "[priceEur = "+priceEur+", announceDate = "+announceDate+"]";
    }
}