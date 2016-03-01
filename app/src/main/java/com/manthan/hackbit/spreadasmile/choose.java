package com.manthan.hackbit.spreadasmile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.prefs.PreferenceChangeEvent;

/**
 * Created by Raj on 10-04-2015.
 */

public class choose extends ActionBarActivity {
    SharedPreferences fooddata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose);
        SharedPreferences prefs = this.getSharedPreferences("Login Credentials",MODE_PRIVATE);
        fooddata= PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor fooddetail=fooddata.edit();
        fooddetail.clear();
        fooddetail.commit();

        String gen=prefs.getString("Username", "");
        Log.d("kk",gen);
         TextView optiondisp=(TextView)findViewById(R.id.textView4);
        optiondisp.setText("   Hi "+gen+"!");
    }

    public void dataEntry(View view){
        SharedPreferences.Editor fooddetail=fooddata.edit();
        switch (view.getId())
        {
            case R.id.btncloth: fooddetail.putInt("exists1",1);
                fooddetail.commit();
                Intent i1= new Intent(choose.this,cloth.class);
                startActivity(i1);
                break;
            case R.id.btnfood: fooddetail.putInt("exists1",2);
                fooddetail.commit();
                Intent i= new Intent(choose.this,food.class);
                startActivity(i);
                break;
        }


}

}
