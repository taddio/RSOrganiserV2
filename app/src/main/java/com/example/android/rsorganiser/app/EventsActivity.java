package com.example.android.rsorganiser.app;

import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

//Array if options --> Array Adapter --> ListView

// List View: {views: event_title_items.xml}

public class EventsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        populateListView();
        registerClickCallBack();
    }

    private void populateListView() {
        //Create List of items
        String[] eventTitles = {"Economics Discussion Group", "ComSoc", "MedSoc", "Charity Committee Meeting"};

        //Build Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,                       // Context for the activity
                R.layout.event_title_items, // Layout to use (create)
                eventTitles);               // Items to be displayed

        //Configure the list view
        ListView list = (ListView) findViewById(R.id.EventListView);
        list.setAdapter(adapter);
    }

    private void registerClickCallBack() {
        ListView list = (ListView) findViewById(R.id.EventListView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> paret, View viewClicked, int position, long id) {
                TextView textView = (TextView) viewClicked;
                String message = "You clicked #" + position + ", which is string: " + textView.getText().toString(); // Shows position of item in list and string name
                Toast.makeText(EventsActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });

    }
}
