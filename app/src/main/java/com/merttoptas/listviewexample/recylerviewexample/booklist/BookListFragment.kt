package com.merttoptas.listviewexample.recylerviewexample.booklist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.merttoptas.listviewexample.R
import com.merttoptas.listviewexample.data.BookModel
import com.merttoptas.listviewexample.data.mockBookData
import com.merttoptas.listviewexample.data.mockBookItemType

class BookListFragment : Fragment(), BooksListener {
    private lateinit var rvBookList: RecyclerView
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_book_list, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        rvBookList = view.findViewById(R.id.rvBookList)
        setupAdapter()
    }

    private fun setupAdapter() {
        val booksAdapter = BooksAdapter(mockBookData, this@BookListFragment)

        rvBookList.adapter = BooksViewTypeAdapter(this@BookListFragment).apply {
            submitList(mockBookItemType)
        }

        rvBookList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    Toast.makeText(requireContext(), "End of list", Toast.LENGTH_SHORT).show()
                }
            }
        })

        //    rvBookList.layoutManager = androidx.recyclerview.widget.GridLayoutManager(context, 2)
    }

    override fun onClicked(book: BookModel) {
        navController.navigate(R.id.action_bookListFragment_to_bookDetailFragment, Bundle().apply {
            putString("bookModel", book.toJson())
        })
    }

    override fun onButtonClicked() {
        Toast.makeText(context, "Button Clicked", Toast.LENGTH_SHORT).show()
    }
}