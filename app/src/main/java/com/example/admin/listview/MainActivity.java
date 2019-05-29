package com.example.admin.listview;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView lst;
    String[] fruitname={"apple","peach","banana","watermelon","orange"};
    Integer imgid[]={R.drawable.apple,R.drawable.peach,R.drawable.banana,R.drawable.watermelon,R.drawable.orange};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lst=(ListView) findViewById(R.id.listview);

        Customlistview customlistview = new Customlistview(this,fruitname,imgid);
        lst.setAdapter(customlistview);
    }



    public class Customlistview extends ArrayAdapter<String> {

        String fruitname[];
        Integer imgid[];
        Context context;

        public Customlistview(Context c,String fruitname[],Integer imgid[]) {
            super(c, R.layout.listview_layout,fruitname);
            this.context=c;
            this.fruitname=fruitname;
            this.imgid=imgid;
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater=LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.listview_layout,parent,false);

            TextView tvName= convertView.findViewById(R.id.textview);
            ImageView tvimage=convertView.findViewById(R.id.imageView);

            tvimage.setImageResource(imgid[position]);
            tvName.setText(" "+fruitname[position]);
            return convertView;
        }

    }


}

