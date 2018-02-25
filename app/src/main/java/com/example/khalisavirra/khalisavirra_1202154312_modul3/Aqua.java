package com.example.khalisavirra.khalisavirra_1202154312_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;

/**
 * Created by virra PC on 2/24/2018.
 */

public class Aqua {
    //Member variables representing the title, image and information about the sport
    private final String title;
    private final String info;
    private final int imageResource;
    private final String aquaDetail;

    static final String TITLE_KEY = "Title";
    static final String IMAGE_KEY = "Image Resource";
    static final String DETAIL_KEY = "Detail";

    /**
     * Constructor for the Aqua class data model
     * @param title The name if the sport.
     * @param info Information about the sport.
     * @param imageResource The resource for the sport image
     */
    Aqua(String title, String info, int imageResource, String aquaDetail) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
        this.aquaDetail = aquaDetail;
    }

    /**
     * Gets the title of the sport
     * @return The title of the sport.
     */
    String getTitle() {
        return title;
    }
    /**
     * Gets the info about the sport
     * @return The info about the sport.
     */
    String getInfo() {
        return info;
    }

    String getDetaill() { return aquaDetail; }

    /**
     * Gets the resource for the image
     * @return The resource for the image
     */
    int getImageResource() {
        return imageResource;
    }



    /**
     * Method for creating  the Detail Intent
     * @param context Application context, used for launching the Intent
     * @param title The title of the current Aqua
     * @param imageResId The image resource associated with the current sport
     * @return The Intent containing the extras about the sport, launches Detail activity
     */
    static Intent starter(Context context, String title, @DrawableRes int imageResId, String detailAqua) {
        Intent detailIntent = new Intent(context, DetailActivity.class);
        detailIntent.putExtra(TITLE_KEY, title);
        detailIntent.putExtra(IMAGE_KEY, imageResId);
        detailIntent.putExtra(DETAIL_KEY, detailAqua);
        return detailIntent;
    }
}
