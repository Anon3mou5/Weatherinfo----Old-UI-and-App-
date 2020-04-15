package com.example.weatherinfo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.Timer;
import java.util.TimerTask;

public class activity2 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);

    }
}
       // ////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        ViewPager2 v = findViewById(R.id.View2);
//        v.setAdapter(new second(getApplicationContext(),R.layout.s));
//        Button b = findViewById(R.id.button2);
//        Timer t = new Timer();
////        MainActivity j = new MainActivity();
////        MainActivity.Mytimer k = j.new Mytimer();
//     //   MainActivity.Mytimer k = new MainActivity().new Mytimer();
//        t.scheduleAtFixedRate(new Mytimer(),2000,4000);
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                EditText t = findViewById(R.id.textView);
//                String city = t.getText().toString();
//                if (city.matches("")) {
//                    Toast.makeText(getApplicationContext(), "Enter Location pls", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
//                    Log.d("something",city);
//                     i.putExtra("city",city);
//                     startActivity(i);
//                }
//            }
//        }
//        );
//    }
//    public class Mytimer extends TimerTask {
//        public void run() {
//            ViewPager2 v = findViewById(R.id.View2);
//            if (v.getCurrentItem() == 0) {
//                v.setCurrentItem(1);
//            } else if (v.getCurrentItem() == 1) {
//                v.setCurrentItem(2);
//            } else if (v.getCurrentItem() == 2) {
//                v.setCurrentItem(3);
//            } else if (v.getCurrentItem() == 3) {
//                v.setCurrentItem(0);
//            } else {
//                v.setCurrentItem(0);
//            }
//        }
//    }
//}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////