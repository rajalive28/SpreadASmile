package com.manthan.hackbit.spreadasmile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.Toast;

public  class SignUp extends ActionBarActivity {

    EditText userinput;
    EditText passinput,address;
    Button submit;
    SharedPreferences sh_Pref;
    Editor toEdit;
    String username, password,addresses;
    public void getInit() {
        userinput = (EditText) findViewById(R.id.editText);
        passinput = (EditText) findViewById(R.id.editText2);
        address = (EditText) findViewById(R.id.editText3);
         }

    public void sharedPreferences()
    {

        toEdit = sh_Pref.edit();
        toEdit.putString("Username",username);
        toEdit.putString("password", password);
        toEdit.putString("address", addresses);
        toEdit.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        sh_Pref = getSharedPreferences("Login Credentials", MODE_PRIVATE);
        getInit();
        try {
            userinput.setText(sh_Pref.getString("Username", " "));
            passinput.setText(sh_Pref.getString("password", " "));
            address.setText(sh_Pref.getString("address", " "));
        }
        catch(Exception ex)
        {

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        menu.add(1,246446,1,"About Us");
        menu.add(1,24644654,2,"Contact Us");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case 246446:Intent i=new Intent(this,about.class);
                startActivity(i);
                break;
            case 24644654:Intent i1=new Intent(this,contact.class);
                startActivity(i1);

                break;
        }
        return super.onOptionsItemSelected(item);
    }




    public void selection(View view){
      //  TextView  idView = (TextView) findViewById(R.id.productID);
        username = userinput.getText().toString();
        password = passinput.getText().toString();
      addresses = address.getText().toString();
        if(addresses=="null"||password=="null"||username=="null")
            Toast.makeText(this,"Fill all detail",Toast.LENGTH_SHORT).show();
        sharedPreferences();
  Intent intent=new Intent(SignUp.this,choose.class);
        startActivity(intent);

    }
}