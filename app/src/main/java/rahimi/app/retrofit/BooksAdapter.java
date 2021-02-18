package rahimi.app.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.myViewHolder> {


    Context context;
    List<Books> data;

    public BooksAdapter(Context context, List<Books> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_books , parent,false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.txt_book_name.setText(data.get(position).getName());
        holder.txt_author_name.setText(data.get(position).getAuthor());
        holder.txt_price.setText(data.get(position).getPrice());
        Picasso.get().load(data.get(position).getLink_img()).into(holder.img_books);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView txt_book_name, txt_author_name, txt_price;
        ImageView img_books;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_book_name = itemView.findViewById(R.id.name_book);
            txt_author_name = itemView.findViewById(R.id.author_name);
            txt_price = itemView.findViewById(R.id.txt_price);
            img_books = itemView.findViewById(R.id.img_books);
        }
    }
}
