package com.example.a06modelviewpresenterexample;

import android.graphics.Color;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a06modelviewpresenterexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements IViewPresenter {
    private PasswordPresenter passwordPresenter;

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        passwordPresenter = new PasswordPresenter(this);

        initListener();

    }

    private void initListener() {
        binding.btPasswordCheck.setOnClickListener(v -> {
            CharSequence s = binding.etPassword.getText();
            passwordPresenter.evaluatePassword(s.toString());
        });
    }

    @Override
    public void showEmptyPassword() {
        binding.clLayout.setBackgroundColor(Color.WHITE);
        binding.tvResult.setText(R.string.please_enter_your_password);
        binding.tvResult.setTextColor(Color.BLACK);
        binding.tvTitle.setTextColor(Color.BLACK);
        binding.etPassword.onEditorAction(EditorInfo.IME_ACTION_DONE);
    }

    @Override
    public void showWeakPassword() {
        binding.clLayout.setBackgroundColor(Color.RED);
        binding.tvResult.setText(R.string.your_password_is_weak);
        binding.tvResult.setTextColor(Color.WHITE);
        binding.tvTitle.setTextColor(Color.WHITE);
        binding.etPassword.onEditorAction(EditorInfo.IME_ACTION_DONE);
    }

    @Override
    public void showMediumPassword() {
        binding.clLayout.setBackgroundColor(Color.BLUE);
        binding.tvResult.setText(R.string.you_can_do_better);
        binding.tvResult.setTextColor(Color.WHITE);
        binding.tvTitle.setTextColor(Color.WHITE);
        binding.etPassword.onEditorAction(EditorInfo.IME_ACTION_DONE);
    }

    @Override
    public void showStrongPassword() {
        binding.clLayout.setBackgroundColor(Color.GREEN);
        binding.tvResult.setText(R.string.your_password_is_strong);
        binding.tvResult.setTextColor(Color.WHITE);
        binding.tvTitle.setTextColor(Color.WHITE);
        binding.etPassword.onEditorAction(EditorInfo.IME_ACTION_DONE);
    }

    @Override
    public void showErrorMessage() {
        binding.clLayout.setBackgroundColor(Color.BLACK);
        binding.tvResult.setText(R.string.unknown_error);
        binding.tvResult.setTextColor(Color.WHITE);
        binding.tvTitle.setTextColor(Color.WHITE);
        binding.etPassword.onEditorAction(EditorInfo.IME_ACTION_DONE);
    }
}
