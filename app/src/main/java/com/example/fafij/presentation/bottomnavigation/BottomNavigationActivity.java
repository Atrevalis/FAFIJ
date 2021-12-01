package com.example.fafij.presentation.bottomnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.fafij.R;

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

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.journal_fragment, R.id.categories_fragment, R.id.infographics_fragment, R.id.settings_fragment)
                .build();
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        assert navHostFragment != null;
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController);
    }
}