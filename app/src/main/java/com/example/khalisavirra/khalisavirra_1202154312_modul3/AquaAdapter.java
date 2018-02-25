package com.example.khalisavirra.khalisavirra_1202154312_modul3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by virra PC on 2/24/2018.
 */

public class AquaAdapter extends RecyclerView.Adapter<AquaAdapter.AquaViewHolder>  {

    //Member variables
    private GradientDrawable mGradientDrawable;
    private ArrayList<Aqua> mAquaData;
    private Context mContext;

    /**
     * Constructor that passes in the sports data and the context
     * @param aquaData ArrayList containing the sports data
     * @param context Context of the application
     */
    AquaAdapter(Context context, ArrayList<Aqua> aquaData) {
        this.mAquaData = aquaData;
        this.mContext = context;

        //Prepare gray placeholder
        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);

        //Make the placeholder same size as the images
        Drawable drawable = ContextCompat.getDrawable
                (mContext,R.drawable.ades);
        if(drawable != null) {
            mGradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }


    /**
     * Required method for creating the viewholder objects.
     * @param parent The ViewGroup into which the new View is added after it is
     *               bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return The newly create SportsViewHolder.
     */
    @Override
    public AquaAdapter.AquaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AquaViewHolder(mContext, LayoutInflater.from(mContext).
                inflate(R.layout.list_item, parent, false), mGradientDrawable);
    }

    /**
     * Required method that binds the data to the viewholder.
     * @param holder The viewholder into which the data should be put.
     * @param position The adapter position.
     */
    @Override
    public void onBindViewHolder(AquaAdapter.AquaViewHolder holder, int position) {

        //Get the current aqua
        Aqua currentAqua = mAquaData.get(position);

        //Bind the data to the views
        holder.bindTo(currentAqua);

    }


    /**
     * Required method for determining the size of the data set.
     * @return Size of the data set.
     */
    @Override
    public int getItemCount() {
        return mAquaData.size();
    }


    /**
     * SportsViewHolder class that represents each row of data in the RecyclerView
     */
    static class AquaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //Member Variables for the holder data
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mAquaImage;
        private Context mContext;
        private Aqua mCurrentAqua;
        private GradientDrawable mGradientDrawable;
        private TextView mAquaDetail;

        /**
         * Constructor for the SportsViewHolder, used in onCreateViewHolder().
         * @param itemView The rootview of the list_item.xml layout file
         */
        AquaViewHolder(Context context, View itemView, GradientDrawable gradientDrawable) {
            super(itemView);

            //Initialize the views
            mTitleText = (TextView)itemView.findViewById(R.id.merkaqua);
            mInfoText = (TextView)itemView.findViewById(R.id.subtitleAqua);
            mAquaImage = (ImageView)itemView.findViewById(R.id.aquaImage);
            mAquaDetail = (TextView)itemView.findViewById(R.id.aquaDetail);

            mContext = context;
            mGradientDrawable = gradientDrawable;

            //Set the OnClickListener to the whole view
            itemView.setOnClickListener(this);
        }

        void bindTo(Aqua currentAqua){
            //Populate the textviews with data
            mTitleText.setText(currentAqua.getTitle());
            mInfoText.setText(currentAqua.getInfo());
            mAquaDetail.setText(currentAqua.getDetaill());

            //Get the current sport
            mCurrentAqua = currentAqua;



            //Load the images into the ImageView using the Glide library
            Glide.with(mContext).load(currentAqua.
                    getImageResource()).placeholder(mGradientDrawable).into(mAquaImage);
        }

        @Override
        public void onClick(View view) {

            //Set up the detail intent
            Intent detailIntent = Aqua.starter(mContext, mCurrentAqua.getTitle(),
                    mCurrentAqua.getImageResource(), mCurrentAqua.getDetaill());


            //Start the detail activity
            mContext.startActivity(detailIntent);
        }
    }
}