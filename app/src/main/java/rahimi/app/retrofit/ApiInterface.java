package rahimi.app.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("getData.php")
    Call<List<Books>> getData();


    @POST("Register.php")
    Call<Users> Register(@Query("username") String username,
                        @Query("email") String email,
                        @Query("phone") String Phone,
                        @Query("pass") String pass);

}
