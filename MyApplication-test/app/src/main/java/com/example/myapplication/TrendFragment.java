package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class TrendFragment extends Fragment {
    private View view;
    private LineChart lineChart;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_trend, container, false);
        lineChart = view.findViewById(R.id.trend);

        ArrayList<Entry> yValues = new ArrayList<>();

        yValues.add(new Entry(0,60));
        yValues.add(new Entry(1,49));
        yValues.add(new Entry(2,42));

        LineDataSet set1 = new LineDataSet(yValues,"non-overbuying quantity");
        set1.setLineWidth(3f);
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);
        LineData lineData = new LineData(dataSets);

        //set text style
        lineData.setValueTextSize(15f);
        lineData.setValueTextColor(Color.BLACK);

        //set chart
        lineChart.setData(lineData);
        lineChart.setScaleEnabled(true);
        lineChart.setDragEnabled(true);
        lineChart.getDescription().setText(" ");

        //set x-axis style
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE);
        xAxis.setDrawGridLines(false);
        //add label to x-axis
        ArrayList<String> xLabel = new ArrayList<>();
        for (int i = 1; i <= yValues.size(); i++){
            xLabel.add("Day"+i);
        }
        xAxis.setGranularityEnabled(true);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xLabel));


        // Inflate the layout for this fragment
        return view;
    }
}