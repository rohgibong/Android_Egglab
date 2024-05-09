package com.example.egglab;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class LoginFragment extends Fragment {

    private EditText editTextId;
    private EditText editTextPassword;
    private Button buttonLogin;
    private Button buttonSignUp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        editTextId = view.findViewById(R.id.editTextId);
        editTextPassword = view.findViewById(R.id.editTextPassword);
        buttonLogin = view.findViewById(R.id.buttonLogin);
        buttonSignUp = view.findViewById(R.id.buttonSignUp);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToRegister();
            }
        });

        return view;
    }

    private void login() {
        String id = editTextId.getText().toString();
        String password = editTextPassword.getText().toString();

        if (id.isEmpty() || password.isEmpty()) {
            Toast.makeText(getActivity(), "아이디와 비밀번호를 입력해주세요.", Toast.LENGTH_LONG).show();
        } else {
            // 로그인 처리 로직을 여기에 추가
            // 로직 추가 시 아래 코드 삭제!!!
            Toast.makeText(getActivity(), "로그인 중 ...", Toast.LENGTH_LONG).show();
        }
    }

    private void navigateToRegister() {
        if (getActivity() != null) {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new RegisterFragment())
                    .addToBackStack(null)  // 이전 프래그먼트로 돌아갈 수 있도록 스택에 추가
                    .commit();
        }
    }
}
