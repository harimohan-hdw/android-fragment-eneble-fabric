package com.reproducerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.facebook.react.ReactApplication;
import com.facebook.react.ReactFragment;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.defaults.DefaultReactNativeHost;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.soloader.SoLoader;

import java.util.List;

public class MainActivity2 extends AppCompatActivity implements ReactApplication, DefaultHardwareBackBtnHandler {
    private MainApplication mainApplication;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainApplication = (MainApplication) getApplication();
        SoLoader.init(this, false);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Fragment reactNativeFragment = new ReactFragment.Builder()
                        .setComponentName("ReproducerApp")
                        .setLaunchOptions(getLaunchOptions("test message"))
                        .build();

                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.reactNativeFragment, reactNativeFragment)
                        .commit();

            }
        });
    }

    private Bundle getLaunchOptions(String message) {
        Bundle initialProperties = new Bundle();
        initialProperties.putString("message", message);
        return initialProperties;
    }
//    private final ReactNativeHost mReactNativeHost = new DefaultReactNativeHost(MainActivity2.this) {
//        @Override
//        public boolean getUseDeveloperSupport() {
//            return BuildConfig.DEBUG;
//        }
//
//        protected List<ReactPackage> getPackages() {
//            List<ReactPackage> packages = new PackageList(this).getPackages();
//            // Packages that cannot be autolinked yet can be added manually here
//            return packages;
//        }
//    };

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mainApplication.getReactNativeHost();
    }

    @Override
    public void invokeDefaultOnBackPressed() {

    }
}