package com.example.fafij.presentation.bottomnavigation.infographics;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.fafij.R;
import com.example.fafij.databinding.FragmentInfographicsBinding;
import com.example.fafij.databinding.FragmentJournalBinding;
import com.example.fafij.databinding.FragmentSettingsBinding;
import com.example.fafij.models.data.Note;
import com.example.fafij.presentation.bottomnavigation.journal.JournalPresenter;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class InfographicsFragment extends Fragment implements InfographicsContract.InfographicsViewInterface {

    FragmentInfographicsBinding binding;
    InfographicsPresenter presenter = new InfographicsPresenter(this);
    private PieChart pieChart;

    public InfographicsFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInfographicsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        pieChart = binding.pieChart;
        setupPieChart();
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(requireActivity());
        presenter.onLoad(sp.getString("journalName", ""));
    }

    private void setupPieChart() {
        pieChart.setDrawHoleEnabled(true);
        pieChart.setUsePercentValues(true);
        pieChart.setEntryLabelTextSize(12);
        pieChart.setEntryLabelColor(Color.BLACK);
        pieChart.setCenterText("Траты по категориям");
        pieChart.setCenterTextSize(24);
        pieChart.getDescription().setEnabled(true);

        Legend l = pieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setEnabled(true);
    }

    @Override
    public void showPieChart(ArrayList<Note> notes) {

        if (notes.isEmpty()) return;


        Map<String, Long> categories = new HashMap<>();

        for (int i = 0; i < notes.size(); i++) {

            if (notes.get(i).getSum() < 0) {
                if (!categories.containsKey(notes.get(i).getCategory().getName())) {
                    categories.put(notes.get(i).getCategory().getName(), 0L);
                }
                categories.put(notes.get(i).getCategory().getName(),
                        categories.get(notes.get(i).getCategory().getName()) + Math.abs(notes.get(i).getSum()));
            }
        }
        ArrayList<PieEntry> entries = new ArrayList<>();
        List<String> keys = new ArrayList<>(categories.keySet());
        for(int i = 0; i < keys.size(); i++) {
            entries.add(new PieEntry(categories.get(keys.get(i)), keys.get(i)));
        }
        ArrayList<Integer> colors = new ArrayList<>();
        for (int color: ColorTemplate.MATERIAL_COLORS) {
            colors.add(color);
        }
        for (int color: ColorTemplate.VORDIPLOM_COLORS) {
            colors.add(color);
        }
        PieDataSet dataSet = new PieDataSet(entries, "Траты по категориям");
        dataSet.setColors(colors);
        PieData data = new PieData(dataSet);
        data.setDrawValues(true);
        data.setValueFormatter(new PercentFormatter(pieChart));
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.BLACK);
        pieChart.setData(data);
        pieChart.invalidate();
        pieChart.animateY(900, Easing.EaseInOutQuad);
    }

    @Override
    public void showToastException(String e) {
        Toast.makeText(
                requireActivity(),
                e,
                Toast.LENGTH_SHORT
        ).show();
    }
}

