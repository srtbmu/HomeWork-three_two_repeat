package com.example.homework_three_two_repeat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.homework_three_two_repeat.fragment.ElementaryFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddingFragment();
    }

    private void AddingFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.FragmentContainerView, new ElementaryFragment())
                .commit();
    }
}