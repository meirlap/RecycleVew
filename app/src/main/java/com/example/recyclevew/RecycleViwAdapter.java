package com.example.recyclevew;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleViwAdapter extends RecyclerView.Adapter <RecycleViwAdapter.CountryViwHolder>{
    private List<Country> countries;
    private MycountyListener mycountyListener;
    interface MycountyListener{
        void onCountyClicked(int position,View view );
        void onCountyLongClicked(int position,View view );
    }

    public void setMycountyListener(MycountyListener mycountyListener) {
        this.mycountyListener = mycountyListener;
    }

    public RecycleViwAdapter(List<Country> countries) {
        this.countries = countries;
    }

    public class  CountryViwHolder extends RecyclerView.ViewHolder{
        TextView tv,population;
        ImageView flag;
        CheckBox isGood;

        public CountryViwHolder(@NonNull final View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.cntyName);
            population=itemView.findViewById(R.id.countypopulation);
            flag=itemView.findViewById(R.id.countryFlag);
            isGood=itemView.findViewById(R.id.good_to_live);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mycountyListener!=null)mycountyListener.onCountyClicked(getAdapterPosition(),v);
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (mycountyListener!=null)mycountyListener.onCountyLongClicked(getAdapterPosition(),v);
                    return false;
             }
            });


        }

    }

    @NonNull
    @Override
    public CountryViwHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.country_cell,parent,false);
        CountryViwHolder countryViwHolder=new CountryViwHolder(view);
        return countryViwHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViwHolder holder, int position) {
Country country=countries.get(position);
holder.tv.setText(country.getName());
        holder.population.setText(country.getPopulation().toString());
        holder.flag.setImageResource(country.getFlagResId());
        holder.isGood.setChecked(country.getGood());
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }
}
