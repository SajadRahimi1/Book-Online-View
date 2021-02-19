package rahimi.app.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class DetailBookActivity extends AppCompatActivity {

    public static final String ID = "id";

    String id;
    Bundle bundle;
    TextView book_name, Author, Published, Genre, describe, price;
    ImageView bookImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_book);

        book_name = findViewById(R.id.detail_name_book);
        Author = findViewById(R.id.detail_author);
        Published = findViewById(R.id.detail_published);
        price = findViewById(R.id.txt_price);
        Genre = findViewById(R.id.detail_genre);
        describe = findViewById(R.id.detail_describe);
        id = getIntent().getStringExtra(ID);
        bookImage = findViewById(R.id.detail_bookImg);
        bundle = getIntent().getExtras();
        Toast.makeText(this, id, Toast.LENGTH_LONG).show();


        book_name.setText(bundle.getString("bookName"));
        Author.setText(Author.getText() + bundle.getString("bookAuthor"));
        Published.setText(Published.getText() + bundle.getString("bookPublished"));
        Genre.setText(Genre.getText() + bundle.getString("bookGenre"));
        price.setText(bundle.getString("bookPrice"));
        describe.setText(bundle.getString("bookDescribe"));
        Picasso.get().load(bundle.getString("imgSrc")).into(bookImage);

    }
}