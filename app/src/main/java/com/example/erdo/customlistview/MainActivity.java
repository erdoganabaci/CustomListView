package com.example.erdo.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String names[]={"İl Seçiniz","Otopark Durumu"};
    String namesValue[]={"tümü","tümü"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView=findViewById(R.id.listView);
        CustomAdapter customAdapter =new CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (names[position].equalsIgnoreCase("İl Seçiniz")){
                    Toast.makeText(MainActivity.this,"İl Seçimini Yapınız",Toast.LENGTH_LONG).show();
                }
                else if (names[position].equalsIgnoreCase("Otopark Durumu")){
                    Toast.makeText(MainActivity.this,"Otopark Durumunu Seçiniz",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    class CustomAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return names.length;
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
        public View getView(int position, View view, ViewGroup parent) {
            view =getLayoutInflater().inflate(R.layout.custom_filterlistview,null);
            TextView textViewFilterCity=view.findViewById(R.id.textViewFilterCity);
            TextView textViewFilterContent=view.findViewById(R.id.textViewFilterContent);


            textViewFilterCity.setText(names[position]);
            textViewFilterContent.setText(namesValue[position]);
            return view;
        }
    }
}
