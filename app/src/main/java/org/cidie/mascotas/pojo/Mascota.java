package org.cidie.mascotas.pojo;

public class Mascota {
    int id;
    String name;
    int rating;
    int image;

    public Mascota(int id, String name, int rating, int image) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.image = image;
    }

    public Mascota() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
