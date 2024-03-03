package com.example.myapplication;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Vector;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private Vector<Vector<Object>> data;
    LayoutInflater inflater;
    public MyAdapter(Context context) {
        this.context = context;
        this.data = Settings.getCurrentStat();
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup container) {
        convertView = inflater.inflate(R.layout.customlistview, container, false);
        TextView time = convertView.findViewById(R.id.listLabelTime);
        TextView exercise = convertView.findViewById(R.id.listLabelExe);
        TextView measurment = convertView.findViewById(R.id.listLabelMeasurment);
        time.setText(String.valueOf(data.get(position).get(1)));
        exercise.setText(String.valueOf(data.get(position).get(0)));
        measurment.setText(String.valueOf(data.get(position).get(2)));
        return convertView;
    }
}