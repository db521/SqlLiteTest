package zhang.sqllitetest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    private MyOpenHelper oh;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        oh = new MyOpenHelper(MainActivity.this, "person.db", null, 3);
        db = oh.getWritableDatabase();


        final List<People> peopleList;
        Cursor cursor = db.rawQuery("select * from people", null);
        peopleList = new ArrayList<People>();


        while (cursor.moveToNext()) {
            String name = cursor.getString(1);
            String phone = cursor.getString(2);
            int salary = cursor.getInt(3);
            //new出对象来,然后把数据放到新创建的peoplelist数组里面去
            People p = new People(name, phone, salary);
            peopleList.add(p);

        }
        ListView listView= (ListView) findViewById(R.id.lv);
        //这是就是MV里的C,控制层
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 5;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView textView=new TextView(MainActivity.this);
                textView.setText("你好吗");
                textView.setTextSize(19);
                return null;
            }
        });


    }
    }

//    public void click(View view) {
////        db.execSQL("insert into people(name,phone,salary) values(?,?,?)",new Object[]{"张三","1380001","13000"});
////
////        db.close();
//        //存一个对象方便用
//        ContentValues values = new ContentValues();
//        for (int i = 0; i < 50; i++) {
//            values.clear();
//            values.put("name", "张三" + i);
//            values.put("phone", "13801" + i + i);
//            values.put("salary", "130" + i);
//            db.insert("people", null, values);
//        }
//    }

//    public void click_forloop(View view) {
//        List<People> peopleList;
//        Cursor cursor = db.rawQuery("select * from people", null);
//        peopleList = new ArrayList<People>();
//        while (cursor.moveToNext()) {
//            String name = cursor.getString(1);
//            String phone = cursor.getString(2);
//            int salary = cursor.getInt(3);
//            //new出对象来,然后把数据放到新创建的peoplelist数组里面去
//            People p = new People(name, phone, salary);
//            peopleList.add(p);
//
//        }
//        //这里的写法就是把textview对象放到linearlayout里面
//        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
//
//        //for循环的写法:类型 实例:实例集合
//        for (People p : peopleList) {
//            TextView tv = new TextView(this);
//            //p.tostring是调用的people里面的方法
//            tv.setText(p.toString());
//            ll.addView(tv);
//        }
//    }
