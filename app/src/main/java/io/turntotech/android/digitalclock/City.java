package io.turntotech.android.digitalclock;

public class City {

    private String cityName;

    public City(String cityName) {
        this.cityName = cityName;
    }

    //Overide to display city names in listview
    @Override
    public String toString() {
        return cityName;
    }
}
