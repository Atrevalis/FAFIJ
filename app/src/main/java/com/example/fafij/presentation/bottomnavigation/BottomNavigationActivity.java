package com.example.fafij.presentation.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.fafij.R;
import com.example.fafij.databinding.ActivityAddjournalBinding;
import com.example.fafij.databinding.ActivityBottomnavigationBinding;
import com.example.fafij.presentation.bottomnavigation.categories.CategoriesFragment;
import com.example.fafij.presentation.bottomnavigation.infographics.InfographicsFragment;
import com.example.fafij.presentation.bottomnavigation.journal.JournalFragment;
import com.example.fafij.presentation.bottomnavigation.settings.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigationActivity extends AppCompatActivity {

    ActivityBottomnavigationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBottomnavigationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        BottomNavigationView bottomNavigationView = binding.bottomNavigationView;
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationListener);
    }

    @SuppressLint("NonConstantResourceId")
    private final BottomNavigationView.OnNavigationItemSelectedListener navigationListener =
            menuItem -> {
                Fragment selectedFragment = null;
                switch (menuItem.getItemId()) {
                    case R.id.fragment_journal:
                        selectedFragment = new JournalFragment();
                        break;
                    case R.id.fragment_categories:
                        selectedFragment = new CategoriesFragment();
                        break;
                    case R.id.fragment_infographics:
                        selectedFragment = new InfographicsFragment();
                        break;
                    case R.id.fragment_settings:
                        selectedFragment = new SettingsFragment();
                        break;
                }
                assert selectedFragment != null;
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).commit();

                return true;
            };
}