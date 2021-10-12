
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

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    private  LineChart lineChart;
    private String item;
    private int quantity;
    private int x = 0;
    List<TestDataBean> user1_recipt1 = new ArrayList<>();
    List<TestDataBean> user1_shoppinglist1 = new ArrayList<>();
    List<TestDataBean> user1_recipt2 = new ArrayList<>();
    List<TestDataBean> user1_shoppinglist2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // read the data
        user1_recipt1 = readCsv(this.getFilesDir().getAbsolutePath() + File.separator + "user1_recipt" + ".csv");
        user1_shoppinglist1 = readCsv(this.getFilesDir().getAbsolutePath() + File.separator + "user1_shoppingList" + ".csv");
        user1_recipt2 = readCsv(this.getFilesDir().getAbsolutePath() + File.separator + "user1_recipt_2" + ".csv");
        user1_shoppinglist2 = readCsv(this.getFilesDir().getAbsolutePath() + File.separator + "user1_shoppingList_2" + ".csv");

        for (int i = 0; i < user1_recipt1.size(); i++){
            x = user1_recipt1.get(i).getQuantity();
            x+=x;
        }
        System.out.print(x);

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

    private ArrayList<TestDataBean> readCsv(String path) {
        ArrayList<TestDataBean> readerArr = new ArrayList<>();
        File file = new File(path);
        FileInputStream fileInputStream;
        Scanner in;
        try {
            fileInputStream = new FileInputStream(file);
            in = new Scanner(fileInputStream, "UTF-8");
            in.nextLine();
            while (in.hasNextLine()) {
                String[] lines = in.nextLine().split(",");
                item = lines[0];
                quantity = Integer.parseInt(lines[1]);
                TestDataBean bean = new TestDataBean(item, quantity);
                readerArr.add(bean);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return readerArr;
    }
}