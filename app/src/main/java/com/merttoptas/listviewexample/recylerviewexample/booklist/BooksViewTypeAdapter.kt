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
import com.merttoptas.listviewexample.data.BooksItemType
import java.lang.IllegalArgumentException

/**
 * Created by merttoptas on 8.10.2022.
 */


class BooksViewTypeAdapter(private val listener: BooksListener) :
    ListAdapter<BooksItemType, RecyclerView.ViewHolder>(BooksDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (getItem(viewType).type) {
            BooksItemType.BOOK -> {
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_book_list, parent, false)
                BooksViewHolder(view)
            }
            BooksItemType.BUTTON -> {
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_button, parent, false)
                ButtonViewHolder(view)
            }
            else -> throw  IllegalArgumentException("Unknown view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItem(position).type) {
            BooksItemType.BOOK -> (holder as BooksViewHolder).bind(
                getItem(position) as BooksItemType.BookData,
                listener
            )
            BooksItemType.BUTTON -> (holder as ButtonViewHolder).bind(listener)
        }
    }

    class BooksDiffUtil : DiffUtil.ItemCallback<BooksItemType>() {
        override fun areItemsTheSame(oldItem: BooksItemType, newItem: BooksItemType): Boolean {
            return oldItem.type == newItem.type
        }

        override fun areContentsTheSame(
            oldItem: BooksItemType,
            newItem: BooksItemType
        ): Boolean {
            return if (oldItem.type == BooksItemType.BOOK && newItem.type == BooksItemType.BOOK)
                oldItem == newItem
            else if (oldItem.type == BooksItemType.BUTTON && newItem.type == BooksItemType.BUTTON)
                oldItem == newItem
            else false
        }
    }

    class BooksViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvId = view.findViewById<TextView>(R.id.tvId)
        private val tvBookName = view.findViewById<TextView>(R.id.tvBookName)
        private val tvTitle = view.findViewById<TextView>(R.id.tvTitle)

        fun bind(book: BooksItemType.BookData, listener: BooksListener) {
            tvId.text = book.id
            tvTitle.text = book.author
            tvBookName.text = book.bookName

            itemView.setOnClickListener {
                //  listener.onClicked(book)
            }

        }
    }

    class ButtonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(listener: BooksListener) {
            itemView.setOnClickListener {
                listener.onButtonClicked()
            }

        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}