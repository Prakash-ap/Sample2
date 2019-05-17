package techy.ap.sample2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    @GET("/tutorial/jsonparsetutorial.txt")
    Call<List<Population>> getAllPopulation();

}
