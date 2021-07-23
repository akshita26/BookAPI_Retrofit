package com.example.bookapi_retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.bookapi_retrofit.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    TextView t1,t2,t3;
    ImageView img;
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    ActivityMainBinding am;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.editTextTextPersonName);
        t1=findViewById(R.id.textView);
        t2=findViewById(R.id.textView2);
        img=findViewById(R.id.imageView);
        recyclerView=findViewById(R.id.recyid);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    public void getet(View view) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.googleapis.com/books/v1/").addConverterFactory(GsonConverterFactory.create()).build();
        Api api = retrofit.create(Api.class);
        Call<Allbooks> call = api.getBook("volumes?q="+e1.getText().toString());

        ProgressDialog dialog = new ProgressDialog(MainActivity.this);
        dialog.setMessage("please wait...");
        dialog.show();

        call.enqueue(new Callback<Allbooks>() {
            @Override
            public void onResponse(Call<Allbooks> call, Response<Allbooks> response) {
                dialog.dismiss();
                Allbooks allbooks = response.body();
                List<Itemss> itemss;
                itemss=allbooks.getItems();

                myAdapter=new MyAdapter(itemss,getApplicationContext());
                recyclerView.setAdapter(myAdapter);

            }

            @Override
            public void onFailure(Call<Allbooks> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}