package com.example.johnnyhanly.beetlejuicesoundboard;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class ClassicFragment extends Fragment {
View view;
Button bAge;
Button bWeight;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view= inflater.inflate(R.layout.fragment_classic,container,false);


        bAge= (Button) view.findViewById(R.id.b_age);
        bWeight=(Button) view.findViewById(R.id.b_weight);
        final MediaPlayer m_age= MediaPlayer.create(getActivity(),R.raw.beetage);
        final MediaPlayer m_weight= MediaPlayer.create(getActivity(),R.raw.beetweight);
        bAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_age.start();
            }
        });
         bWeight.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                m_weight.start();
             }
         });


        return view;
    }
    }

