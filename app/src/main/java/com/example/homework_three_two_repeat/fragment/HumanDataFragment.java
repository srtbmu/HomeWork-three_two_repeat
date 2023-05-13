package com.example.homework_three_two_repeat.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.homework_three_two_repeat.R;

public class HumanDataFragment extends Fragment {
    TextView TextViewName, TextViewSurname;
    String Name, Surname;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_human_data, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findView();
        setValue();
    }

    private void setValue() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            Name = bundle.getString("Name");
            Surname = bundle.getString("Surname");
            TextViewName.setText(Name);
            TextViewSurname.setText(Surname);
        }
    }

//    private void setView() {
//        TextViewName.setText(Name);
//        TextViewSurname.setText(Surname);
//    }

    private void findView() {
        TextViewName = requireView().findViewById(R.id.TextViewName);
        TextViewSurname = requireView().findViewById(R.id.TextViewSurname);
    }
}













