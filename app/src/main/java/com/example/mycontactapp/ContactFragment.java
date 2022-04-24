package com.example.mycontactapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;


public class ContactFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedViewModel sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        NavController navController = Navigation.findNavController(view);
        Button button = view.findViewById(R.id.buSend);
        EditText editText = view.findViewById(R.id.etMsg);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sharedViewModel.setData(editText.getText().toString().trim());
                navController.navigate(R.id.action_contactFragment_to_contactMessageFragment);


            }


        });


    }


}





