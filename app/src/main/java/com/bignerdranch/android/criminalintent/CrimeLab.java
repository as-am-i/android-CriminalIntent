package com.bignerdranch.android.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by tanii_asami on 2018/01/16.
 */

public class CrimeLab {
    // why static?
    // because only static innstace can be acceessed in static method
    private static CrimeLab sCrimeLab;

    private List<Crime> mCrimes;

    // singleton
    private CrimeLab(Context context) {
        // mCrimes holds an ArrayList
        mCrimes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0); // Every other one
            mCrimes.add(crime);
        }
    }

    // get() method should be static
    // to be called in any other classes without an instance
    public static CrimeLab get(Context context) {
        // call the constructor to create an instance if it does'nt exist yet
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        // simply returns the instance if it already exists
        return sCrimeLab;
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {
        for (Crime crime : mCrimes) {
            if (crime.getID().equals(id)) {
                return crime;
            }
        }
        return null;
    }
}
