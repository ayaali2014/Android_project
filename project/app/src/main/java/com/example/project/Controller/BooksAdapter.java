package com.example.project.Controller;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.Details;
import com.example.project.DetailsView;
import com.example.project.FeedActivity;
import com.example.project.Model.Book;
import com.example.project.R;

import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.MyViewholder>{

    private List<Book> bookList;
    private Context context;


    public BooksAdapter(List bookList, Context context) {
        this.bookList = bookList;
        this.context = context;
    }

    public BooksAdapter(List<Book> bookList) {
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.book_list_row,parent,false);
        return new MyViewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        Book book=bookList.get(position);
        holder.title.setText(book.getTitle());
        holder.desc.setText(book.getDesc());
        holder.rate.setText(book.getRate());
        holder.cost.setText(book.getCost());
        holder.image.setImageResource(book.getImage());
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title,desc,rate,cost;
        private ImageView image;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title=itemView.findViewById(R.id.title);
            desc=itemView.findViewById(R.id.desc);
            rate=itemView.findViewById(R.id.rate);
            cost=itemView.findViewById(R.id.cost);
            image=itemView.findViewById(R.id.imageView);


        }

        @Override
        public void onClick(View view) {
            int position=getAdapterPosition();
            Book  books=bookList.get(position);
            Intent intent=new Intent(context, DetailsView.class);
            intent.putExtra("Book", (Parcelable) books);
            context.startActivity(intent);
        }
    }
}

