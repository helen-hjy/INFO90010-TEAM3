
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartGestureListener;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    private  LineChart lineChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lineChart = (LineChart) findViewById(R.id.linechart);

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

    }
}