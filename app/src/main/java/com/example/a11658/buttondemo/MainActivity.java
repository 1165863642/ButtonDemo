package com.example.a11658.buttondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button2, button3, button4, button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //匿名内部类实现点击事件
                Toast.makeText(MainActivity.this, "匿名内部类的点击事件", Toast.LENGTH_SHORT).show();
            }
        });

        button3.setOnClickListener(new MyListener());
        button4.setOnClickListener(this);
        button5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, "长按事件", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    public void doClick(View view) {
        //xml通过onClick实现点击事件
        Toast.makeText(this, "xml点击实现", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        //继承方式
        Toast.makeText(this, "继承点击", Toast.LENGTH_SHORT).show();
    }

    class MyListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            //自定义方式
            Toast.makeText(MainActivity.this, "自定义点击事件", Toast.LENGTH_SHORT).show();
        }
    }
}
