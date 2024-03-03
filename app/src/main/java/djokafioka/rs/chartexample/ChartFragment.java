package djokafioka.rs.chartexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;


public class ChartFragment extends Fragment
{

    private BarChart mBarChart;
    private PieChart mPieChart;
    private ArrayList<Growth> mGrowthList;

    public ChartFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_chart, container, false);

        mBarChart = (BarChart) v.findViewById(R.id.bar_chart);
        mPieChart = (PieChart) v.findViewById(R.id.pie_chart);

        mGrowthList = new ArrayList<>();

        createDataForChart();

        getGrowthChart(getArguments().getString("method", "bar"));

        return v;
    }

    private void getGrowthChart(String method)
    {
        if (method.equals("bar"))
        {
            List<BarEntry> barEntries = new ArrayList<>();

            for(Growth growth : mGrowthList)
            {
                barEntries.add(new BarEntry(growth.getYear(), growth.getGrowthRate()));
            }

            BarDataSet barDataSet = new BarDataSet(barEntries, "Growth"); //Second parameter is a description for the legend
            //barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);

            BarData barData = new BarData(barDataSet);
            barData.setBarWidth(0.9f);

            mBarChart.setVisibility(View.VISIBLE);
            mBarChart.animateY(2000); //in ms
            mBarChart.setData(barData);
            mBarChart.setFitBars(true);

            Description description = new Description();
            description.setText("Growth Rate per Year");

            mBarChart.setDescription(description);
            mBarChart.setTouchEnabled(true);
            mBarChart.setDragEnabled(true);
            mBarChart.setScaleEnabled(true);
            //Sve moze da se vidi na GitHub strani za MPAndroid charts u wiki stranama

            mBarChart.invalidate();

        }
        else if (method.equals("pie"))
        {
            List<PieEntry> pieEntries = new ArrayList<>();

            for(Growth growth : mGrowthList)
            {
                pieEntries.add(new PieEntry(growth.getGrowthRate(), String.valueOf(growth.getYear()))); //Second parameter has to be a String value
            }

            PieDataSet pieDataSet = new PieDataSet(pieEntries, "Growth per year"); //Second parameter is a description for the legend
            pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

            PieData pieData = new PieData(pieDataSet);

            mPieChart.setVisibility(View.VISIBLE);
            mPieChart.animateXY(2000, 2000); //in ms
            mPieChart.setData(pieData);

            Description description = new Description();
            description.setText("Growth Rate per Year");

            mPieChart.setDescription(description);

            mPieChart.invalidate();
        }
    }

    private void createDataForChart()
    {
        Float j = (float) 10;
        for(int i = 2010; i < 2019; i++)
        {
            Growth growth = new Growth();
            growth.setYear(i);
            growth.setGrowthRate((float) i / (float) 40 + j);
            mGrowthList.add(growth);
            j += 2;
        }
    }

}
