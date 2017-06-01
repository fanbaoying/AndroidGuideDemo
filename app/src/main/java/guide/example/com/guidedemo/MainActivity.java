package guide.example.com.guidedemo;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

//    声明一个viewpage控件
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
    }

//    监听按钮的点击事件
    public void jump(View view){

        Intent intent = new Intent(MainActivity.this,NewActivity.class);
        startActivity(intent);
    }
}
