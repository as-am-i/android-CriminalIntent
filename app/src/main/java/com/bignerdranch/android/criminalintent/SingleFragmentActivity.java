package com.bignerdranch.android.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by tanii_asami on 2018/01/16.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {
    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        // getSupportFragmentManager() comes from the super class
        // why should it find fragment_container?
        // because if fragment is NOT null, there's no connection between fragment and container here at this moment
        FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        // fragment should be null at first
        // because it it not created yet at first
        if (fragment == null) {
            fragment = createFragment();
            // beginTransaction() is for using .add() or other methods
            // the first parameter for add() is the container, the second is the elements to be in it
            // commit() is like commit for git
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }
}
