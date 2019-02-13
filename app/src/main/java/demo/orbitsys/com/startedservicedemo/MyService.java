package demo.orbitsys.com.startedservicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Random;

public class MyService extends Service {
    private int mRandomNumber;
    private boolean mIsRandomGenerationOn;
    private final int MIN=0;
    private final int MAX=100;



@Override
public void onCreate(){
    super.onCreate();
    Log.i("@@@","in onCreate");
    mIsRandomGenerationOn=true;
    new Thread(new Runnable() {
        @Override
        public void run() {
            startRandomGenerator();
        }
    }).start();

}

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("@@@","in onStartcommand");
        return super.onStartCommand(intent, flags, startId);

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        Log.i("@@@","In onBind");
        return null;
    }


    public void onDestroy(){
    super.onDestroy();
    stopRandomGenerator();
    Log.i("@@@","In onDestroy");
    }

public void startRandomGenerator(){
    while (mIsRandomGenerationOn){
        try{
            Thread.sleep(1000);
            if(mIsRandomGenerationOn){
                mRandomNumber=new Random().nextInt(MAX)+MIN;
                Log.i("@@@","Thread ID : " +Thread.currentThread().getId()+",Random Number: " +mRandomNumber);

            }
        } catch (InterruptedException e) {
            Log.i("@@@","Thread Interrupted");
        }

    }
}
private void stopRandomGenerator(){
    mIsRandomGenerationOn=false;
}

}
