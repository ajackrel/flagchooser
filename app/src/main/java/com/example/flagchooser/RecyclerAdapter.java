package com.example.flagchooser;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/*
RecyclerAdapter "bind" values/data stored in memory to the visual components we see on screen.
In other words, it's the glue between JAVA and XML. More accurately, it's a translation layer.
As you can, this class extends from a class called CountryViewHolder (the class we create below)
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CountryViewHolder>{


    private Context context;
    //ArrayList of that holds all data fields
    private ArrayList<CountryList> list = new ArrayList<>();

    //constructor
    public RecyclerAdapter(ArrayList list, Context context) {
        this.list = list;
        this.context = context;
    }

    /*
    grabs the views from our card_design.xml layout file
    similar to onCreate() methods - initializes the views - connects the Java and XML sides together
     */
    public class CountryViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewCountryName, textViewDetails;
        private ImageView imageView;

        private CardView cardView;

        //
        public CountryViewHolder(@NonNull View itemView){
            super(itemView);

            textViewCountryName = itemView.findViewById(R.id.textViewCountryName);
            textViewDetails = itemView.findViewById(R.id.textViewDetail);
            imageView = itemView.findViewById(R.id.imageView);
            cardView = itemView.findViewById(R.id.cardView);
        }

    }

    @NonNull
    @Override
    //this where you inflate ("draw" the view on screen) the layout
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //take note that we are using the custom card layout here
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_design, parent, false);
        return new CountryViewHolder((view));
    }

    @Override
    //assigning values/data to the views we created in the card_design.xml layout file
    //based on position (row)
    public void onBindViewHolder(@NonNull CountryViewHolder holder, @SuppressLint("RecyclerView") int position) {

        //this is where the country name, details, and image will be set
        //the holder is the temporary holding place for all of the views grabbed from the XML side
        //all depends on the position (row)
        //holder.textViewCountryName.setText(list.get(position).getCountryName());


        //because we want to add interactivity to the app
        // we need an event listener here for the CardView
        //when the user touches a CardView, a toast message will pop up and confirm the selection


    }

    @Override
    //recycler view wants to know how many items(rows) will be displayed
    public int getItemCount() {

        return list.size();

    }


}
