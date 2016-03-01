package com.manthan.hackbit.spreadasmile;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Raj on 10-04-2015.
 */
public class cloth extends Activity implements AdapterView.OnItemSelectedListener {
    SharedPreferences clothdata;
    Spinner spinner1,spinner2,spinner3;
    String options1[]={"Select","Male","Female","Both"};
    String options2[]={"Select","< 10","10-20","20-30","30+"};
    String options3[]={"Choose Area","Jayanagar","WhiteField","Malleshwaram","Koramangala"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cloth_layout);
        SharedPreferences prefs = this.getSharedPreferences("Login Credentials",MODE_PRIVATE);
        String gen=prefs.getString("Username", "");
        TextView tvname=(TextView)findViewById(R.id.tvname);
        tvname.setText(gen);
        clothdata= PreferenceManager.getDefaultSharedPreferences(this);
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(cloth.this,android.R.layout.simple_spinner_item,options1);
        spinner1=(Spinner) findViewById(R.id.spinner1);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);
        spinner2=(Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(cloth.this,android.R.layout.simple_spinner_item,options2);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);
        spinner3=(Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<String> adapter3=new ArrayAdapter<String>(cloth.this,android.R.layout.simple_spinner_item,options3);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(this);

    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        final SharedPreferences.Editor fooddetail = clothdata.edit();
        int position1=spinner1.getSelectedItemPosition();
        int position2=spinner2.getSelectedItemPosition();
        int position3=spinner3.getSelectedItemPosition();

        switch(position1){
            case 1:
                fooddetail.putString("type", "Male");
                break;
            case 2:fooddetail.putString("type","Female");
                break;
            case 3:fooddetail.putString("type","Both");
                break;
        }
            fooddetail.commit();
        switch(position2){
            case 1:
                fooddetail.putString("number", "less then 10");
                break;
            case 2:fooddetail.putString("number","10 to 20");
                break;
            case 3:fooddetail.putString("number","20 to 30");
                break;
            case 4:fooddetail.putString("number","more then 30");
                break;
        }
        fooddetail.commit();
        switch(position3) {
            case 1:
                fooddetail.putString("area", "jayanagar");
                break;
            case 2:
                fooddetail.putString("area", "WhiteField");
                break;
            case 3:
                fooddetail.putString("area", "Malleshwaram");
                break;
            case 4: fooddetail.putString("area", "Koramangala");
                break;

        }
        fooddetail.commit();
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
        Toast.makeText(this,"select",Toast.LENGTH_SHORT).show();
    }
    public void searchngo(View view)
    {
        if(clothdata.getString("type","null")=="null"||clothdata.getString("number","null")=="null"||clothdata.getString("area","null")=="null")
            Toast.makeText(this,"Fill all detail",Toast.LENGTH_SHORT).show();
        else {
            switch(clothdata.getString("area","null"))
            {
                case "jayanagar": Intent i = new Intent(this, Slide.class);
                    startActivity(i);
                    break;
                case "WhiteField":Intent i1 = new Intent(this, Slidewhite.class);
                    startActivity(i1);
                    break;
                case "Malleshwaram":Intent i2 = new Intent(this, Slidemalleswaram.class);
                    startActivity(i2);
                    break;
                case "Koramangala" :Intent i3 = new Intent(this, Slidekor.class);
                    startActivity(i3);
                    break;
            }

        }
    }
}