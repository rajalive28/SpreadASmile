package com.manthan.hackbit.spreadasmile;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telephony.SmsManager;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class Slidewhite extends Activity {

ViewFlipper flipper;
SharedPreferences fooddata;
    SharedPreferences clothdata;
private Animation inFromRightAnimation() {

Animation inFromRight = new TranslateAnimation(
Animation.RELATIVE_TO_PARENT,  +1.0f, Animation.RELATIVE_TO_PARENT,  0.0f,
Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,   0.0f
);
inFromRight.setDuration(500);
inFromRight.setInterpolator(new AccelerateInterpolator());
return inFromRight;
}
private Animation outToLeftAnimation() {
Animation outtoLeft = new TranslateAnimation(
  Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,  -1.0f,
  Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,   0.0f
);
outtoLeft.setDuration(500);
outtoLeft.setInterpolator(new AccelerateInterpolator());
return outtoLeft;
}

private Animation inFromLeftAnimation() {
Animation inFromLeft = new TranslateAnimation(
Animation.RELATIVE_TO_PARENT,  -1.0f, Animation.RELATIVE_TO_PARENT,  0.0f,
Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,   0.0f
);
inFromLeft.setDuration(500);
inFromLeft.setInterpolator(new AccelerateInterpolator());
return inFromLeft;
}
private Animation outToRightAnimation() {
Animation outtoRight = new TranslateAnimation(
  Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,  +1.0f,
  Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,   0.0f
);
outtoRight.setDuration(500);
outtoRight.setInterpolator(new AccelerateInterpolator());
return outtoRight;
}
    String gen,area,number;
/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.whitengo);
    SharedPreferences prefs = this.getSharedPreferences("Login Credentials",MODE_PRIVATE);
    gen=prefs.getString("Username", "");
    area=prefs.getString("address","");
    number=prefs.getString("password","");
    fooddata= PreferenceManager.getDefaultSharedPreferences(this);
    clothdata= PreferenceManager.getDefaultSharedPreferences(this);
    flipper = (ViewFlipper) findViewById(R.id.flipper);
}

    public void nextngo(View view) {
        flipper.setInAnimation(inFromRightAnimation());
        flipper.setOutAnimation(outToLeftAnimation());
        flipper.showNext();
    }
    public void prengo(View view) {
        flipper.setInAnimation(inFromLeftAnimation());
        flipper.setOutAnimation(outToRightAnimation());
        flipper.showPrevious();
    }
    public void selectngo(View view)
    {
        final SmsManager sm=SmsManager.getDefault();
        final Dialog myDialog = new Dialog(this);
        myDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        myDialog.setContentView(R.layout.callorsms_layout);
//        myDialog.setTitle("Select Option" );
        Button b_call = (Button) myDialog.findViewById( R.id.btncall);
        Button b_text = (Button) myDialog.findViewById( R.id.btntext);
        final TextView tv=(TextView) findViewById(R.id.textView2);
        b_text.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        myDialog.dismiss();
                        if (fooddata.getInt("exists1", 0) == 1) {
                            switch (tv.getText().toString()) {
                                case "1":
                                    Toast.makeText(getBaseContext(), "mesage sent", Toast.LENGTH_SHORT).show();
                                    sm.sendTextMessage("9620559280", null, "Hi My name is " + gen + ". I want to donate clothes for " + clothdata.getString("number", "") + " people and my address is " + area + ". Please contact me on this number " + number, null, null);
                                    break;
                                case "2":
                                    Toast.makeText(getBaseContext(), "mesage sent", Toast.LENGTH_SHORT).show();
                                    sm.sendTextMessage("9620559280", null, "Hi My name is " + gen + ". I want to donate clothes for " + clothdata.getString("number", "") + " people and my address is " + area + ". Please contact me on this number " + number, null, null);
                                    break;
                            }
                        }
                        if (fooddata.getInt("exists1", 0) == 2) {
                            switch (tv.getText().toString()) {
                                case "1":
                                    Toast.makeText(getBaseContext(), "mesage sent", Toast.LENGTH_SHORT).show();
                                    sm.sendTextMessage("8951038181", null, "Hi My name is " + gen + ". I want to donate food for " + fooddata.getString("number", "") + " people and my address is " + area + ". Please contact me on this number " + number, null, null);
                                    break;
                                case "2":
                                    Toast.makeText(getBaseContext(), "mesage sent", Toast.LENGTH_SHORT).show();
                                    sm.sendTextMessage("8951038181", null, "Hi My name is " + gen + ". I want to donate food for " + fooddata.getString("number", "") + " people and my address is " + area + ". Please contact me on this number " + number, null, null);
                                    break;
                            }
                        }

                    }
                }
        );


        b_call.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View arg0)
                    {
                        myDialog.dismiss();
                        switch(tv.getText().toString())
                        {
                            case "1": Intent i = new Intent(Intent.ACTION_CALL);
                                i.setData(Uri.parse("tel:" + "8951038181"));
                                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(i);
                                break;
                            case "2": Intent i1 = new Intent(Intent.ACTION_CALL);
                                i1.setData(Uri.parse("tel:" + "8951038181"));
                                i1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(i1);
                                break;
                        }
                    }
                }
        );
        myDialog.show();
    }

}