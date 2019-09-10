package com.example.observerpatter;

import android.os.Handler;

import java.util.Observable;

public class UserDataRepository extends Observable {
    private String mFullName;
    private int mAge;
    private static UserDataRepository INSTANCE = null;


    public UserDataRepository() {
        getNewDataFromRemote();
    }

    /**
     * Simulate network actions
     */
    private void getNewDataFromRemote() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setUserData("Juan flores", 102);
            }
        }, 1000);
    }

    public static UserDataRepository getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new UserDataRepository();
        }

        return INSTANCE;
    }

    public void setUserData(String fullName, int age) {
        mFullName = fullName;
        mAge = age;
        setChanged();
        notifyObservers();
    }

    public String getFullName() {
        return mFullName;
    }

    public int getAge() {
        return mAge;
    }
}
