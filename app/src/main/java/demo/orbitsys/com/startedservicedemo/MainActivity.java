package demo.orbitsys.com.startedservicedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent serviceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        serviceIntent=new Intent(getApplicationContext(),MyService.class);
    }

    public void startService(View view) {
        startService(serviceIntent);

    }

    public void stopService(View view) {
        stopService(serviceIntent);
    }
}
