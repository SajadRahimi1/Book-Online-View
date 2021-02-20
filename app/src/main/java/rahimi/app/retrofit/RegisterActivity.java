package rahimi.app.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    TextView txt_login;
    TextInputEditText username_edt,email_edt,pass_edt,phone_edt;
    Button btn_register;
    @Override
  public void onBackPressed() {
        startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
        finish();
    }


    ApiInterface request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        request = ApiClient.getApiClient("http://192.168.10.1/retrofit/").create(ApiInterface.class);
        txt_login = findViewById(R.id.txt_login);
        username_edt = findViewById(R.id.username_editText);
        email_edt = findViewById(R.id.email_editText);
        pass_edt = findViewById(R.id.password_editText);
        phone_edt = findViewById(R.id.phone_editText);
        btn_register = findViewById(R.id.btn_register);



        txt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                finish();
            }
        });


        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUser();
            }
        });





    }

    private void getUser() {
        String username = username_edt.getText().toString(), email = email_edt.getText().toString(),
                phone = phone_edt.getText().toString(), pass = pass_edt.getText().toString();

        Call<Users> call = request.Register(username,email,phone,pass);

        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                if(response.body().getResponse().equals("USER_REGISTERED")){
                    Toast.makeText(RegisterActivity.this, "This Account Registered Before", Toast.LENGTH_LONG).show();
                }else if(response.body().getResponse().equals("SUCCESS")){
                    Toast.makeText(RegisterActivity.this, "Successful to Register", Toast.LENGTH_LONG).show();
                }else if(response.body().getResponse().equals("WRONG")){
                    Toast.makeText(RegisterActivity.this, "Connection Not Established", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}