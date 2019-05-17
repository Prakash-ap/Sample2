package techy.ap.sample2;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button showlist;
    //  private static String url = "https://www.androidbegin.com/tutorial/jsonparsetutorial.txt";
    private CustomAdapter customAdapter;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showlist=(Button)findViewById(R.id.btn_showlist);

        progressDialog=new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();


        GetDataService service=RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Population>> call=service.getAllPopulation();

        call.enqueue(new Callback<List<Population>>() {
            @Override
            public void onResponse(Call<List<Population>> call, Response<List<Population>> response) {
                progressDialog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Population>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();


            }

        });
        



    }

    private void generateDataList(List<Population> body) {
        recyclerView=(RecyclerView) findViewById(R.id.list);
        customAdapter=new CustomAdapter(this,body);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(customAdapter);
    }
}
