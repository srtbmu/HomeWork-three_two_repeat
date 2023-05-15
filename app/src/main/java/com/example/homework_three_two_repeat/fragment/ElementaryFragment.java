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
import android.widget.Toast;

import com.example.homework_three_two_repeat.R;

public class ElementaryFragment extends Fragment {
    AppCompatButton ButtonElementary;
    EditText EditTextName, EditTextSurname;
    String Name, Surname;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_elementary, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findView();
        clickListener();
    }

    private void findView() {
        ButtonElementary = requireActivity().findViewById(R.id.ButtonElementary);
        EditTextName = requireActivity().findViewById(R.id.EditTextName);
        EditTextSurname = requireActivity().findViewById(R.id.EditTextSurname);
    }

    private void clickListener() {
        ButtonElementary.setOnClickListener(v -> textCheck());
    }

    private void textCheck() {
        if (!EditTextName.getText().toString().isEmpty()) {
            if (!EditTextSurname.getText().toString().isEmpty()) {
                navigationFragment();
            } else {
                Toast.makeText(getActivity(), "Вы не ввели свое фамиле", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getActivity(), "Вы не ввели свое имя", Toast.LENGTH_LONG).show();
        }
    }

    private void dataTransfer() {
        Name = EditTextName.getText().toString();
        Surname = EditTextSurname.getText().toString();
    }

    private void navigationFragment() {
        dataTransfer();
        Bundle bundle = new Bundle();
        bundle.putString("Name", Name);
        bundle.putString("Surname", Surname);
        FirstFragment firstFragment = new FirstFragment();
        firstFragment.setArguments(bundle);
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.FragmentContainerView, firstFragment)
                .commit();
    }
}