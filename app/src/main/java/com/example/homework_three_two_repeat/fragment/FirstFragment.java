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
import android.widget.TextView;
import android.widget.Toast;

import com.example.homework_three_two_repeat.R;

public class FirstFragment extends Fragment {
    AppCompatButton ButtonFirst;
    EditText EditTextAge, EditTextFloor;
    String Age, Floor, Name, Surname;
    TextView ElementaryName, ElementarySurname;

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
        setValue();
    }

    private void findView() {
        ButtonFirst = requireActivity().findViewById(R.id.ButtonFirst);
        EditTextAge = requireActivity().findViewById(R.id.EditTextAge);
        EditTextFloor = requireActivity().findViewById(R.id.EditTextFloor);
        ElementaryName = requireActivity().findViewById(R.id.ElementaryName);
        ElementarySurname = requireActivity().findViewById(R.id.ElementarySurname);
    }

    private void clickListener() {
        ButtonFirst.setOnClickListener(v -> textCheck());
    }

    private void textCheck() {
        if (!EditTextAge.getText().toString().isEmpty()) {
            if (!EditTextFloor.getText().toString().isEmpty()) {
                navigationFragment();
            } else {
                Toast.makeText(getActivity(), "Вы не ввели свой пол", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getActivity(), "Вы не ввели свой возраст", Toast.LENGTH_LONG).show();
        }
    }

    private void dataTransfer() {
        Age = EditTextAge.getText().toString();
        Floor = EditTextFloor.getText().toString();
        Name = ElementaryName.getText().toString();
        Surname = ElementarySurname.getText().toString();
    }

    private void navigationFragment() {
        dataTransfer();
        Bundle bundle = new Bundle();
        bundle.putString("Age", Age);
        bundle.putString("Floor", Floor);
        bundle.putString("Name", Name);
        bundle.putString("Surname", Surname);
        SecondFragment secondFragment = new SecondFragment();
        secondFragment.setArguments(bundle);
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.FragmentContainerView, secondFragment)
                .addToBackStack(null)
                .commit();
    }

    private void setValue() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            Name = bundle.getString("Name");
            Surname = bundle.getString("Surname");
            setView();
        }
    }

    private void setView() {
        ElementaryName.setText(Name);
        ElementarySurname.setText(Surname);

    }
}