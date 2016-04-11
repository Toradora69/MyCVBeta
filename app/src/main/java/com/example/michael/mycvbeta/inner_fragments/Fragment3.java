package com.example.michael.mycvbeta.inner_fragments;


import android.app.Dialog;
import android.app.FragmentManager;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.michael.mycvbeta.R;
import com.example.michael.mycvbeta.dialogs.GreenbyteIconDialog;


/**
 * Created by Michael on 16-03-2016.
 */
public class Fragment3 extends Fragment {
    ImageView greenbytelogo;
    private final static int MAX_VOLUME = 100;
    private final static int soundVolume = 20;
    TextView furtherInfotv;
    Button backbutton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tabfragment_3,container, false );
        final MediaPlayer mp = MediaPlayer.create(getContext().getApplicationContext(), R.raw.japbell);
        final float volume = (float) (1 - (Math.log(MAX_VOLUME - soundVolume) / Math.log(MAX_VOLUME)));
        mp.setVolume(volume,volume);

        furtherInfotv = (TextView)v.findViewById(R.id.furtherinfoId);
        furtherInfotv.setTypeface(Typeface.DEFAULT_BOLD);


         greenbytelogo = (ImageView)v.findViewById(R.id.greenbyteInfoId);
        greenbytelogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              //  Toast.makeText(getContext(), "msg msg", Toast.LENGTH_LONG).show();
                mp.start();
                final Dialog dialog = new Dialog(getContext(),R.style.cust_dialog);
                dialog.setContentView(R.layout.greenbyte_dialog);


                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(dialog.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.MATCH_PARENT;
                dialog.show();
                dialog.getWindow().setAttributes(lp);

                dialog.show();

                backbutton = (Button)dialog.findViewById(R.id.backbutton);
                backbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });



            }
        });
        return v;
    }
}
