package com.example.javaretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private CustomAdapter adapter;
    private RecyclerView recyclerView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GetDataService service = RetrofitInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<RetroMovies>> call = service.getMovie();
        call.enqueue(new Callback<List<RetroMovies>>() {
            @Override
            public void onResponse(Call<List<RetroMovies>> call, Response<List<RetroMovies>> response) {
                generateDataList(response.body());

            }

            @Override
            public void onFailure(Call<List<RetroMovies>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDataList(List<RetroMovies> movieList){
        recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new CustomAdapter(movieList,this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}
