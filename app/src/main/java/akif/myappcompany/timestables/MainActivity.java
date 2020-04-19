package akif.myappcompany.timestables;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    ListView timesTablesListView;

    public void generateTimesTable(int timesTableNumber)
    {
        ArrayList<String> timesTableContent = new ArrayList<>();

        for(int i = 1; i <= 100 ; i++)
            timesTableContent.add(Integer.toString(timesTableNumber * i));
        ArrayAdapter timesTableAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , timesTableContent );

        timesTablesListView.setAdapter(timesTableAdapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTableSeekBar = (SeekBar) findViewById(R.id.timesTableSeekBar);

        timesTablesListView = findViewById(R.id.timesTablesListView);

        int max = 20;
        int startingPosition = 10;
        timesTableSeekBar.setMax(max);
        timesTableSeekBar.setMin(1);
        timesTableSeekBar.setProgress(startingPosition);

        generateTimesTable(startingPosition);
        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                Log.i("Seekbar Value: ",Integer.toString(progress));

                generateTimesTable(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
