package com.example.asus.myapplication;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.concurrent.TimeUnit;

import asia.ivity.android.marqueeview.MarqueeView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;


    private Handler mHandler;
   final int handleMessage1=1;
   final int handleMessage2 = 2;
   final int handleMessage3 = 3;

    boolean ifOnFirstTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d("Log", "Main activity 1");

        startMoveAnimationOne();
        startMoveAnimationTwo();
        startMoveAnimation3();
        startMoveAnimation4();


        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case handleMessage1:
//                        textView.setText("Text 1");
                        textView.setText(Html.fromHtml(getString(R.string.my_text1)));
                        break;
                    case handleMessage2:
//                        textView.setText("Text 22222222");
                        textView.setText(Html.fromHtml(getString(R.string.my_text2)));
                        break;
                    case handleMessage3:
//                        textView.setText("Text 333");
                        textView.setText(Html.fromHtml(getString(R.string.my_text3)));
                        break;
                }
            }
        };
        ifOnFirstTime = true;
        startTextChanges();
        Log.d("Log", "Main activity 2");

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        final MenuItem alertMenuItem = menu.findItem(R.id.itemNew);
        FrameLayout frameLayout = (FrameLayout) alertMenuItem.getActionView();
        textView = (TextView) frameLayout.findViewById(R.id.textViewMenu);
        textView.setText(Html.fromHtml(getString(R.string.my_text1)));


        return super.onPrepareOptionsMenu(menu);
    }

    private  void startTextChanges () {

        Log.d("Log", "Main activity 3");



        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int time = 1; time <= time+1; time++) {

                    try {

                        if (ifOnFirstTime){
                            ifOnFirstTime=false;
                            mHandler.sendEmptyMessageDelayed(handleMessage2, 5000);
                            mHandler.sendEmptyMessageDelayed(handleMessage3, 10000);
                            TimeUnit.SECONDS.sleep(10);


                        }else { mHandler.sendEmptyMessageDelayed(handleMessage1, 5000);
                                mHandler.sendEmptyMessageDelayed(handleMessage2, 10000);
                                mHandler.sendEmptyMessageDelayed(handleMessage3, 15000);
                                 TimeUnit.SECONDS.sleep(15);}


                        if (time==16)time=0;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        t.start();
        Log.d("Log", "Main activity 4");

    }

    public  void startMoveAnimationOne(){

        final MarqueeView mv = (MarqueeView) findViewById(R.id.marqueeView100);
        mv.setPauseBetweenAnimations(200);
        mv.setSpeed(10);
        Log.d("Log","2");

        getWindow().getDecorView().post(new Runnable() {
            @Override
            public void run() {
                mv.startMarquee();
            }
        });
    }

    public  void startMoveAnimationTwo(){

        final MarqueeView2 mv2 = (MarqueeView2) findViewById(R.id.marqueeView102);
        mv2.setPauseBetweenAnimations(200);
        mv2.setSpeed(10);
        Log.d("Log","2");

        getWindow().getDecorView().post(new Runnable() {
            @Override
            public void run() {
                mv2.startMarquee();
            }
        });
    }

    public  void startMoveAnimation3() {

        final MarqueeView mv3 = (MarqueeView) findViewById(R.id.marqueeView103);
        mv3.setPauseBetweenAnimations(200);
        mv3.setSpeed(10);
        Log.d("Log", "2");

        getWindow().getDecorView().post(new Runnable() {
            @Override
            public void run() {
                mv3.startMarquee();
            }
        });
    }
    public  void startMoveAnimation4() {

        final MarqueeView2 mv2 = (MarqueeView2) findViewById(R.id.marqueeView104);
        mv2.setPauseBetweenAnimations(200);
        mv2.setSpeed(10);
        Log.d("Log", "2");

        getWindow().getDecorView().post(new Runnable() {
            @Override
            public void run() {
                mv2.startMarquee();
            }
        });


    }


}
