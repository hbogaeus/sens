package se.sensco.sens;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "se.sensco.sens.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the listview in the layout
        final ListView listView = (ListView) findViewById(R.id.listview);

        // Create and populate a list of Sensors
        ArrayList<Sensor> list = new ArrayList<>();

        Random random = new Random();
        int temp;
        String name;

        for (int i = 0; i < 10; i++) {
            temp = random.nextInt(30);
            name = "Cool name";
            Sensor sensor = new Sensor(temp, name);
            list.add(sensor);
        }

        // Create an adaptor from the list using our SensorAdapter
        SensorAdapter adapter = new SensorAdapter(this, list);

        // Attach the adaptor to the listView
        listView.setAdapter(adapter);
    }

    private class SensorAdapter extends ArrayAdapter<Sensor> {

        public SensorAdapter(Context context, List<Sensor> objects) {
            super(context, 0, objects);
        }

        // Bad implementation
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Sensor sensor = getItem(position);

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_sensor, parent, false);
            }

            TextView sensor_name = (TextView) convertView.findViewById(R.id.sensor_name);
            TextView sensor_temp = (TextView) convertView.findViewById(R.id.sensor_temp);

            sensor_name.setText(sensor.getName());
            sensor_temp.setText(String.valueOf(sensor.getTemp()));

            return convertView;
        }
    }
}

