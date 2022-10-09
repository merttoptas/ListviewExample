package com.merttoptas.listviewexample.recylerviewexample.booklist


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.merttoptas.listviewexample.R
import com.merttoptas.listviewexample.data.BookModel

/**
 * Created by merttoptas on 8.10.2022.
 */

class BooksDiffutilAdapter(private val listener: BooksListener) :
    ListAdapter<BookModel, BooksDiffutilAdapter.BooksViewHolder>(BooksDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_book_list, parent, false)
        return BooksViewHolder(view)
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    class BooksDiffUtil : DiffUtil.ItemCallback<BookModel>() {
        override fun areItemsTheSame(oldItem: BookModel, newItem: BookModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: BookModel,
            newItem: BookModel
        ): Boolean {
            return oldItem == newItem
        }
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