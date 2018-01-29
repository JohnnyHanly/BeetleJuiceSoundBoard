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

import java.util.ArrayList;


public class InsultsFragment extends Fragment {
ArrayList<MediaPlayer>InsultMedia= new ArrayList<MediaPlayer>();
  View view;
  Button bTakeyou;
  Button bEskimos;
  Button bJews;
  Button bWhites;
  Button bBadHands;
  Button bIsTough;

  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
      view= inflater.inflate(R.layout.fragment_insults, container,false);






      bTakeyou= (Button) view.findViewById(R.id.b_takeyou);
      bEskimos= (Button) view.findViewById(R.id.b_eskimos);
      bJews= (Button) view.findViewById(R.id.b_jews);
      bWhites= (Button) view.findViewById(R.id.b_whites);
      bBadHands= (Button) view.findViewById(R.id.b_killaguy);
      bIsTough= (Button) view.findViewById(R.id.b_tough);

      final MediaPlayer m_takeyou= MediaPlayer.create(getActivity(),R.raw.beet_takeyoulikeaman);
      final MediaPlayer m_eskimos= MediaPlayer.create(getActivity(), R.raw.beet_eskimos);
      final MediaPlayer m_whites= MediaPlayer.create(getActivity(),R.raw.beet_white);
      final MediaPlayer m_jews= MediaPlayer.create(getActivity(),R.raw.beet_jews);
      final MediaPlayer m_badHands= MediaPlayer.create(getActivity(),R.raw.beet_killaguy);
      final MediaPlayer m_isTough= MediaPlayer.create(getActivity(),R.raw.beet_imistough);
      InsultMedia.add(m_takeyou);
      InsultMedia.add(m_eskimos);
      InsultMedia.add(m_whites);
      InsultMedia.add(m_jews);
      InsultMedia.add(m_badHands);
      InsultMedia.add(m_isTough);

      bTakeyou.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Play(m_takeyou);
          }
      });
     bEskimos.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Play(m_eskimos);
         }
     });
     bJews.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Play(m_jews);
         }
     });
     bWhites.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Play(m_whites);
         }
     });
     bBadHands.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Play(m_badHands);
         }
     });
     bIsTough.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Play(m_isTough);
         }
     });


      return view;

  }public void Play(MediaPlayer mediaPlayer) {


        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        mediaPlayer.start();
    }


}
