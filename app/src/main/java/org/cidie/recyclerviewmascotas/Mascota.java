package org.cidie.recyclerviewmascotas;

public class Mascota {
    String name;
    int rating;
    int image;

    public Mascota(String name, int rating, int image) {
        this.name = name;
        this.rating = rating;
        this.image=image;
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


}
