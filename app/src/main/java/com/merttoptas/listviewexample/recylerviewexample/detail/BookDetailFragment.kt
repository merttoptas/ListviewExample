package com.merttoptas.listviewexample.recylerviewexample.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.merttoptas.listviewexample.R
import com.merttoptas.listviewexample.data.BookModel

class BookDetailFragment : Fragment() {
    private lateinit var tvBookName: TextView
    private lateinit var tvAuthor: TextView
    private lateinit var tvDesc: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_book_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews(view)
    }

    private fun setupViews(view: View) {
        tvBookName = view.findViewById(R.id.tvBookName)
        tvAuthor = view.findViewById(R.id.tvAuthor)
        tvDesc = view.findViewById(R.id.tvDescription)

        arguments?.let {
            val bookData = it.getString("bookModel")

            bookData?.let { safeBookData ->
                val book = BookModel.fromJson(safeBookData)

                tvBookName.text = book.bookName
                tvAuthor.text = book.author
                tvDesc.text = book.description

            }
        }
    }
}