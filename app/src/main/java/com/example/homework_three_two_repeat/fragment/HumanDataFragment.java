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
    TextView TextViewName, TextViewSurname,TexViewAge,TextViewFloor,TextViewStudies,TextViewWork;
    String Name, Surname,Age,Floor,Studies,Work;

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
            setView();
            Name = bundle.getString("Name");
            Surname = bundle.getString("Surname");
            Age = bundle.getString("Age");
            Floor = bundle.getString("Floor");
            Studies = bundle.getString("Studies");
            Work = bundle.getString("Work");
        }
    }

    private void setView() {
        TextViewName.setText(Name);
        TextViewSurname.setText(Surname);
        TexViewAge.setText(Age);
        TextViewFloor.setText(Floor);
        TextViewStudies.setText(Studies);
        TextViewWork.setText(Work);
    }

    private void findView() {
        TextViewName = requireView().findViewById(R.id.TextViewName);
        TextViewSurname = requireView().findViewById(R.id.TextViewSurname);
        TexViewAge = requireView().findViewById(R.id.TextViewAge);
        TextViewFloor = requireView().findViewById(R.id.TextViewFloor);
        TextViewStudies = requireActivity().findViewById(R.id.TextViewStudies);
        TextViewWork = requireView().findViewById(R.id.TextViewWork);
    }
}













