package com.johnny.hanly.beetlejuicesoundboard;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.HashMap;


public class HateFragment extends Fragment {

    View view;
    Button bGay;
    Button bWhites;
    Button bJews;
    Button bEskimos;
    Button bMidgets;
    Button bIndian;
    Button bAmish;
    Button bAnt;
    Button bLoveWomen;
    SoundPool hateSoundPool;
    HashMap<Integer, Integer> HateSoundPoolMap;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_hate, container, false);
        hateSoundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 100);
        HateSoundPoolMap = new HashMap<Integer, Integer>();
        final Vibrator x = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
        HateSoundPoolMap.put(1, hateSoundPool.load(getActivity(), R.raw.beet_gay, 1));
        HateSoundPoolMap.put(2, hateSoundPool.load(getActivity(), R.raw.beet_white, 1));
        HateSoundPoolMap.put(3, hateSoundPool.load(getActivity(), R.raw.beet_jews, 1));
        HateSoundPoolMap.put(4, hateSoundPool.load(getActivity(), R.raw.beet_eskimos, 1));
        HateSoundPoolMap.put(5, hateSoundPool.load(getActivity(), R.raw.beet_midgets, 1));
        HateSoundPoolMap.put(6, hateSoundPool.load(getActivity(), R.raw.beet_indians, 1));
        HateSoundPoolMap.put(7, hateSoundPool.load(getActivity(), R.raw.beet_amish, 1));
        HateSoundPoolMap.put(8, hateSoundPool.load(getActivity(), R.raw.beet_lovewomen, 1));


        bGay= (Button) view.findViewById(R.id.b_gay);
        bWhites = (Button) view.findViewById(R.id.b_whites);
        bJews = (Button) view.findViewById(R.id.b_jews);
        bEskimos = (Button) view.findViewById(R.id.b_eskimos);
        bMidgets= (Button) view.findViewById(R.id.b_midgets);
        bIndian= (Button) view.findViewById(R.id.b_indians);
        bAmish= (Button) view.findViewById(R.id.b_amish);
        bLoveWomen= (Button) view.findViewById(R.id.b_lovewomen);


        bWhites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(2, x);
            }
        });
        bGay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(1, x);
            }
        });
        bJews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(3, x);
            }
        });
        bEskimos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(4, x);
            }
        });
        bMidgets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(5,x);
            }
        });
        bIndian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(6,x);
            }
        });
        bAmish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(7,x);
            }
        });

        bLoveWomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(8,x);
            }
        });

return view;
    }

    public void Play(Integer integer, Vibrator vibrator) {
        AudioManager audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
        float currentVol = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVol = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float leftVol = currentVol / maxVol;
        float rightVol = currentVol / maxVol;
        for (int i = 0; i <= 10; i++) {
            hateSoundPool.stop(i);
        }
        hateSoundPool.play(integer, leftVol, rightVol, 1, 0, 1f);
        vibrator.vibrate(10);
    }
}




