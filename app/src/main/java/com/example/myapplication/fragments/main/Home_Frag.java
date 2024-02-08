package com.example.myapplication.fragments.main;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.example.myapplication.MyAdapter;
import com.example.myapplication.R;
import com.example.myapplication.Settings;

public class Home_Frag extends Fragment {
    // Variables
    private TextView textStatName;
    private TextView textStatNumber;
    private TextView tempText;
    private ListView listView;
    private int i;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Initialization
        View view = inflater.inflate(R.layout.home_layout, container, false);
        textStatName = view.findViewById(R.id.text_Home_StatName);
        textStatNumber = view.findViewById(R.id.text_Home_StatNumber);
        Button btnStatCycle = view.findViewById(R.id.btnStatCycle);
        listView = (ListView) view.findViewById(R.id.mainlist);
        MyAdapter myAdapter= new MyAdapter(getContext());
        listView.setAdapter(myAdapter);
        textStatName =view.findViewById(R.id.text_Home_StatName);
        textStatNumber =view.findViewById(R.id.text_Home_StatNumber);
        cycleStat();
        // Listeners
        btnStatCycle.setOnClickListener(v -> {
            ++i;
            cycleStat();
        });
        return view;
    }
    // Methods
    private void cycleStat(){
        //Checks if outside of array if it cycles to the begining
        if(i==Settings.trackedUserStats.length){
            i = 0;
        }
        textStatNumber.setText(String.valueOf(Settings.trackedUserStats[i][1]));
        textStatName.setText(String.valueOf(Settings.trackedUserStats[i][0]));
    }
}
