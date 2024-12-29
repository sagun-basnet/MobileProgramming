package com.example.listwithfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class StudentDetailFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle b){
        View v = inflater.inflate(R.layout.list_fragment_activity, container, false);

        TextView frgRoll = v.findViewById(R.id.frgRoll);
        TextView frgName = v.findViewById(R.id.frgName);
        TextView frgAddress = v.findViewById(R.id.frgAddress);

        Bundle args = getArguments();
        if(args != null){
            frgRoll.setText(String.valueOf(args.getInt("roll")));
            frgName.setText(args.getString("name"));
            frgAddress.setText(args.getString("address"));
        }

        return v;
    }
}
