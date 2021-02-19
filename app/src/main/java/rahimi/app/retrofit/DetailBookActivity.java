package rahimi.app.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class DetailBookActivity extends AppCompatActivity {

    public static final String ID = "id11";

    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_book);

        id = getIntent().getStringExtra(ID);
        Toast.makeText(this, id, Toast.LENGTH_LONG).show();
    }
}