package tn.mechatitans.forms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class splash extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Button getStartedbtn = (Button) findViewById(R.id.getStartedbtn);
        TextView desc = (TextView) findViewById(R.id.desc);
        LinearLayout title = (LinearLayout) findViewById(R.id.title);
        Animation fadeinwithmvt = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadeinwithmvt);
        Animation fadeinwithdownmvt = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadeinwithdownmvt);
        title.startAnimation(fadeinwithdownmvt);
        fadeinwithdownmvt.setStartOffset(300);
        desc.startAnimation(fadeinwithdownmvt);
        getStartedbtn.startAnimation(fadeinwithmvt);
        getStartedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(splash.this, MainMenu.class));
                overridePendingTransition(R.anim.transition_in,R.anim.fade_out);
            }
        });
        }
}
