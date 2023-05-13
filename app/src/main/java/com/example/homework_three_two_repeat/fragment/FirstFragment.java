package com.example.homework_three_two_repeat.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.homework_three_two_repeat.R;

import java.util.jar.Attributes;


public class FirstFragment extends Fragment {
    AppCompatButton ButtonFirst;
    EditText EditTextAge,EditTextFloor;
    String Age,Floor;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findView();
        clickListener();
    }

    private void findView() {
        ButtonFirst = requireActivity().findViewById(R.id.ButtonFirst);
        EditTextAge = requireActivity().findViewById(R.id.EditTextAge);
        EditTextFloor = requireActivity().findViewById(R.id.EditTextFloor);
    }

    private void dataTransfer(){
        Age = EditTextAge.getText().toString();
        Floor = EditTextFloor.getText().toString();
    }

    private void clickListener() {
        ButtonFirst.setOnClickListener(v ->
                navigationFragment()
        );
    }

    private void navigationFragment() {
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.FragmentContainerView, new SecondFragment())
                .addToBackStack(null)
                .commit();
    }
}