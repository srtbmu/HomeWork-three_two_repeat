package com.example.homework_three_two_repeat.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homework_three_two_repeat.R;

public class SecondFragment extends Fragment {
    AppCompatButton ButtonSecond;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findView();
        clickListener();
    }

    private void clickListener() {
        ButtonSecond.setOnClickListener(v ->
                navigationFragment());
    }

    private void navigationFragment() {
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.FragmentContainerView, new HumanDataFragment())
                .addToBackStack(null)
                .commit();
    }

    private void findView() {
        ButtonSecond = requireActivity().findViewById(R.id.ButtonSecond);
    }

}