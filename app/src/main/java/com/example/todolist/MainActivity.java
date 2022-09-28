package com.example.todolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //선언
    ArrayList<String> todoList;
    ArrayAdapter<String> adapter;
    ListView listView;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //초기화
        todoList = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, todoList);
        listView = findViewById(R.id.list_view);
        editText = findViewById(R.id.edit_text);

        //어뎁터 적용
        listView.setAdapter(adapter);

        //할 일 버튼 추가
        Button addBtn = findViewById(R.id.add_btn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItemTodoList();
            }
        });

        //리스트 아이템 클릭했을 때 이벤트
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                Toast.makeText(view.getContext(), "완료했습니다.", Toast.LENGTH_SHORT).show();
            }
        });

    } //OnCreate

    public void addItemTodoList(){
        //아이템 등록
        todoList.add(editText.getText().toString());
        //적용
        adapter.notifyDataSetChanged();
        //입력창 초기화
        editText.setText("");
    }
}//Main Activity