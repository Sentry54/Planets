package ru.sen.planets;


public class Profile {
    int imgPlanet;
    String namePlanet, dscPlanet;

    public Profile() {
    }

    public Profile(int imgPlanet, String namePlanet, String dscPlanet) {
        this.imgPlanet = imgPlanet;
        this.namePlanet = namePlanet;
        this.dscPlanet = dscPlanet;
    }

    public int getImgPlanet() {
        return imgPlanet;
    }

    public void setImgPlanet(int imgPlanet) {
        this.imgPlanet = imgPlanet;
    }

    public String getNamePlanet() {
        return namePlanet;
    }

    public void setNamePlanet(String namePlanet) {
        this.namePlanet = namePlanet;
    }

    public String getDscPlanet() {
        return dscPlanet;
    }

    public void setDscPlanet(String dscPlanet) {
        this.dscPlanet = dscPlanet;
    }

}
