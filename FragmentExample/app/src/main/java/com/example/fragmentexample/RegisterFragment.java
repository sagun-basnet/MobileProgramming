package com.example.fragmentexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RegisterFragment extends Fragment {
    Button btnRegister, btnRegisterReset;
    EditText editName, editPhone, editPass;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.register_fragment,container, false);
        editName = v.findViewById(R.id.editRegisterName);
        editPhone = v.findViewById(R.id.editRegisterPhone);
        editPass = v.findViewById(R.id.editRegisterPassword);
        btnRegister = v.findViewById(R.id.btnRegister);
        btnRegisterReset = v.findViewById(R.id.btnRegisterReset);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnRegisterReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editName.setText("");
                editPhone.setText("");
                editPass.setText("");
            }
        });


        return v;
    }
}
