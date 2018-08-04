package com.example.user.myapplication;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class MainActivity extends AppCompatActivity {

    private Button btn;
    private WifiManager wifi_manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void hotspot(View view) {

        wifi_manager = (WifiManager) this.getApplicationContext().getSystemService(MainActivity.this.WIFI_SERVICE);
        btn = (Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0)
            {

                WifiConfiguration wifi_configuration = null;
                wifi_manager.setWifiEnabled(false);

                try
                {
                    //USE REFLECTION TO GET METHOD "SetWifiAPEnabled"
                    Method method=wifi_manager.getClass().getMethod("setWifiApEnabled", WifiConfiguration.class, boolean.class);
                    method.invoke(wifi_manager, wifi_configuration, true);
                }
                catch (NoSuchMethodException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                catch (IllegalArgumentException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                catch (IllegalAccessException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                catch (InvocationTargetException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });



    }
}
