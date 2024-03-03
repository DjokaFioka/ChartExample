package djokafioka.rs.chartexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openBarChart(View view)
    {
        Intent intent = new Intent(this, ChartActivity.class);
        intent.putExtra("method", "bar");
        startActivity(intent);
    }

    public void openPieChart(View view)
    {
        Intent intent = new Intent(this, ChartActivity.class);
        intent.putExtra("method", "pie");
        startActivity(intent);
    }
}
