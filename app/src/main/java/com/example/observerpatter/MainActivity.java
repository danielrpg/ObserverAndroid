package com.example.observerpatter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {

    private Observable mUserDataRepository;
    private TextView mTextViewUserFullName;
    private TextView mTextViewUserAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewUserAge = findViewById(R.id.text_view_user_age);
        mTextViewUserFullName = findViewById(R.id.text_view_full_name);

        mUserDataRepository = UserDataRepository.getInstance();
        mUserDataRepository.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        if(observable instanceof UserDataRepository) {
            UserDataRepository userDataRepository = (UserDataRepository) observable;
            mTextViewUserAge.setText(String.valueOf(userDataRepository.getAge()));
            mTextViewUserFullName.setText(userDataRepository.getFullName());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUserDataRepository.deleteObserver(this);
    }
}
