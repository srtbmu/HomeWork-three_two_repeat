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

public class SecondFragment extends Fragment {
    AppCompatButton ButtonSecond;
    EditText EditTextStudies, EditTextWork;
    String Studies, Work, Age, Floor, Name, Surname;
    TextView ElementarySurname, ElementaryName, FirstAge, FirstFloor;

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
        setValue();
    }

    private void findView() {
        ButtonSecond = requireActivity().findViewById(R.id.ButtonSecond);
        EditTextStudies = requireActivity().findViewById(R.id.EditTextStudies);
        EditTextWork = requireActivity().findViewById(R.id.EditTextWork);
        ElementaryName = requireActivity().findViewById(R.id.ElementaryName);
        ElementarySurname = requireActivity().findViewById(R.id.ElementarySurname);
        FirstAge = requireActivity().findViewById(R.id.FirstAge);
        FirstFloor = requireActivity().findViewById(R.id.FirstFloor);
    }

    private void clickListener() {
        ButtonSecond.setOnClickListener(v ->
                textCheck());
    }

    private void textCheck() {
        if (!EditTextStudies.getText().toString().isEmpty()) {
            if (!EditTextWork.getText().toString().isEmpty()) {
                navigationFragment();
            } else {
                Toast.makeText(getActivity(), "Вы не ввели свой адрес работы", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getActivity(), "Вы не ввели свой адрес учебы", Toast.LENGTH_LONG).show();
        }
    }

    private void dataTransfer() {
        Studies = EditTextStudies.getText().toString();
        Work = EditTextWork.getText().toString();
        Name = ElementaryName.getText().toString();
        Surname = ElementarySurname.getText().toString();
        Age = FirstAge.getText().toString();
        Floor = FirstFloor.getText().toString();
    }

    private void navigationFragment() {
        dataTransfer();
        Bundle bundle = new Bundle();
        bundle.putString("Studies", Studies);
        bundle.putString("Work", Work);
        bundle.putString("Name", Name);
        bundle.putString("Surname", Surname);
        bundle.putString("Age", Age);
        bundle.putString("Floor", Floor);
        HumanDataFragment humanDataFragment = new HumanDataFragment();
        humanDataFragment.setArguments(bundle);
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.FragmentContainerView, humanDataFragment)
                .addToBackStack(null)
                .commit();
    }

    private void setValue() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            Name = bundle.getString("Name");
            Surname = bundle.getString("Surname");
            Age = bundle.getString("Age");
            Floor = bundle.getString("Floor");
            setView();
        }
    }

    private void setView() {
        ElementaryName.setText(Name);
        ElementarySurname.setText(Surname);
        FirstAge.setText(Age);
        FirstFloor.setText(Floor);
    }

}