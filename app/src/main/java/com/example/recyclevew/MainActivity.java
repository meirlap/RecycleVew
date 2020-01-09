package com.example.recyclevew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView=findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final List<Country> countryList=new ArrayList<>();
        countryList.add(new Country("Israel", (long) 9000000,R.drawable.flag_israel,true));
        countryList.add(new Country("China", (long) 12000000,R.drawable.flag_china,false));
        countryList.add(new Country("France", (long) 90000000,R.drawable.flag_france,true));
        countryList.add(new Country("Greece", (long) 9000000,R.drawable.flag_greece,true));
        countryList.add(new Country("Italy", (long) 90000000,R.drawable.flag_italy,false));
        countryList.add(new Country("Romania", (long) 90000000,R.drawable.flag_romania,false));
        countryList.add(new Country("Russia", (long) 1200000,R.drawable.flag_russia,false));
        countryList.add(new Country("Spain", (long) 5000000,R.drawable.flag_spain,true));
        countryList.add(new Country("Israel", (long) 9000000,R.drawable.flag_israel,true));
        countryList.add(new Country("China", (long) 12000000,R.drawable.flag_china,false));
        countryList.add(new Country("France", (long) 90000000,R.drawable.flag_france,true));
        countryList.add(new Country("Greece", (long) 9000000,R.drawable.flag_greece,true));
        countryList.add(new Country("Italy", (long) 90000000,R.drawable.flag_italy,false));
        countryList.add(new Country("Romania", (long) 90000000,R.drawable.flag_romania,false));
        countryList.add(new Country("Russia", (long) 1200000,R.drawable.flag_russia,false));
        countryList.add(new Country("Spain", (long) 5000000,R.drawable.flag_spain,true));

        final RecycleViwAdapter countryAdapter =new RecycleViwAdapter(countryList);
        recyclerView.setAdapter(countryAdapter);
        countryAdapter.setMycountyListener(new RecycleViwAdapter.MycountyListener() {
            @Override
            public void onCountyClicked(int position, View view) {
                Toast.makeText(MainActivity.this, countryList.get(position).getName()+" and it's population is  "
                        + countryList.get(position).getPopulation(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCountyLongClicked(int position, View view) {
                countryList.remove(position);
                countryAdapter.notifyItemRemoved(position);

            }
        });

    }
}
