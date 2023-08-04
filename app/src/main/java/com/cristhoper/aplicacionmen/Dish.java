package com.cristhoper.aplicacionmen;

import android.os.Parcel;
import android.os.Parcelable;

public class Dish implements Parcelable {
    private String name;
    private String description;
    private String ingredients;
    private double price;
    private int imageResourceId;

    public Dish(String name, String description, String ingredients, double price, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.price = price;
        this.imageResourceId = imageResourceId;
    }

    // Getter para el nombre del platillo
    public String getName() {
        return name;
    }

    // Setter para el nombre del platillo
    public void setName(String name) {
        this.name = name;
    }

    // Getter para la descripción del platillo
    public String getDescription() {
        return description;
    }

    // Setter para la descripción del platillo
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter para los ingredientes del platillo
    public String getIngredients() {
        return ingredients;
    }

    // Setter para los ingredientes del platillo
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    // Getter para el precio del platillo
    public double getPrice() {
        return price;
    }

    // Setter para el precio del platillo
    public void setPrice(double price) {
        this.price = price;
    }

    // Getter para el ID de la imagen del platillo
    public int getImageResourceId() {
        return imageResourceId;
    }

    // Setter para el ID de la imagen del platillo
    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    // Implementación de Parcelable
    protected Dish(Parcel in) {
        name = in.readString();
        description = in.readString();
        ingredients = in.readString();
        price = in.readDouble();
        imageResourceId = in.readInt();
    }

    public static final Creator<Dish> CREATOR = new Creator<Dish>() {
        @Override
        public Dish createFromParcel(Parcel in) {
            return new Dish(in);
        }

        @Override
        public Dish[] newArray(int size) {
            return new Dish[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(ingredients);
        dest.writeDouble(price);
        dest.writeInt(imageResourceId);
    }
}
