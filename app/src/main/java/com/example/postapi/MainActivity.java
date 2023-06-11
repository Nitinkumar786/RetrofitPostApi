package com.example.postapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private JsonApi jsonApi;
    private com.example.postapi.JsonApi JsonApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         textView=findViewById(R.id.textview);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonApi = retrofit.create(JsonApi.class);
        createPost();
    }

    private void createPost() {
        Post post = new Post(22, 10, "New Title","New Text");
        Call<Post> call = JsonApi.createPost(post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()){
                    textView.setText("code"+response.code());
                    return;
                }
                Post postResponse = response.body();
                String content ="";

                content += "Code:" + response.code() + "\n";
                content += "ID:" + postResponse.getId() + "\n";
                content += "UserID:" + postResponse.getUserId() + "\n";
                content += "Title:" + postResponse.getTitle() + "\n";
                content += "Text:" + postResponse.getText() + "\n\n";
                textView.setText(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

}