package com.merttoptas.listviewexample.recylerviewexample.booklist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.merttoptas.listviewexample.R
import com.merttoptas.listviewexample.data.BookModel

/**
 * Created by merttoptas on 2.10.2022.
 */

class BooksAdapter(
    private val bookList: MutableList<BookModel>,
    private val listener: BooksListener
) :
    RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_book_list, parent, false)
        return BooksViewHolder(view)
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.bind(bookList[position], listener)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    class BooksViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvId = view.findViewById<TextView>(R.id.tvId)
        private val tvBookName = view.findViewById<TextView>(R.id.tvBookName)
        private val tvTitle = view.findViewById<TextView>(R.id.tvTitle)

        fun bind(book: BookModel, listener: BooksListener) {
            tvId.text = book.id
            tvTitle.text = book.author
            tvBookName.text = book.bookName

            itemView.setOnClickListener {
                listener.onClicked(book)
            }

        }
    }
}

interface BooksListener {
    fun onClicked(book: BookModel)
}