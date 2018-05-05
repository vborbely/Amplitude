package com.anysolutions.amplitude;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.amplitude.api.Amplitude;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private MyAmplitudeClient myAmplitudeClient;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myAmplitudeClient = MyAmplitudeClient.getInstance("9d9ff2d49d2d7ec20eb41f815fb27b56");
        myAmplitudeClient.enableForegroundTracking(getApplication());

        myAmplitudeClient.logEvent("Hello World");
    }

    public void clicked(View view) {
        Amplitude.getInstance().logEvent("BTN_CLICKED");
    }
}
