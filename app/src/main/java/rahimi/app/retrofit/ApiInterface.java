package rahimi.app.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("getData.php")
    Call<List<Books>> getData();

}
