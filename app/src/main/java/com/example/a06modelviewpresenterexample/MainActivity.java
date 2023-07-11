package com.example.a06modelviewpresenterexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.a06modelviewpresenterexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());




    }
}