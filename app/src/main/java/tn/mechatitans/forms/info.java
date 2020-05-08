package tn.mechatitans.forms;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class info extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
        Animation fadeinwithmvt = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadeinwithmvt);
        Animation fadeinwithdownmvt = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadeinwithdownmvt);
        Button homescreen = (Button) findViewById(R.id.goback);
        Button facebookpage = (Button)findViewById(R.id.facebookpage);
        TextView h1 = (TextView) findViewById(R.id.h1);
        TextView h2 = (TextView) findViewById(R.id.h2);
        ImageView mecha = (ImageView) findViewById(R.id.mecha);
        TextView desc = (TextView) findViewById(R.id.mechadescription);
        h1.startAnimation(fadeinwithdownmvt);
        h2.startAnimation(fadeinwithdownmvt);
        mecha.startAnimation(fadeinwithdownmvt);
        desc.startAnimation(fadeinwithdownmvt);
        facebookpage.startAnimation(fadeinwithmvt);
        homescreen.startAnimation(fadeinwithmvt);
        final PackageManager pm = info.this.getPackageManager();
        homescreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(info.this,MainMenu.class));
                overridePendingTransition(R.anim.transition_out,R.anim.fade_out);
            }
        });
        facebookpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(newFacebookIntent(pm,"https://www.facebook.com/mecha.titans"));
            }
        });
    }
    public static Intent newFacebookIntent(PackageManager pm, String url) {
        Uri uri = Uri.parse(url);
        try {
            ApplicationInfo applicationInfo = pm.getApplicationInfo("com.facebook.katana", 0);
            if (applicationInfo.enabled) {
                uri = Uri.parse("fb://facewebmodal/f?href=" + url);
            }
        } catch (PackageManager.NameNotFoundException ignored) {
        }
        return new Intent(Intent.ACTION_VIEW, uri);
    }
}
