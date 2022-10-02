package com.merttoptas.listviewexample.listviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.merttoptas.listviewexample.R
import com.merttoptas.listviewexample.recylerviewexample.booklist.BooksAdapter
import com.merttoptas.listviewexample.listviewexample.adapter.UserAdapterListener
import com.merttoptas.listviewexample.data.mockBookData

class MainActivity : AppCompatActivity(), UserAdapterListener {
   // private lateinit var userListView: ListView
    private lateinit var rvBookList : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      //  rvBookList = findViewById(R.id.rvBookList)

     //   rvBookList.adapter = BooksAdapter(mockBookData)


     //   userListView = findViewById(R.id.listUsers)
        /*
            //ListView Adapter
       userListView.adapter = UserAdapter(prepareUserMockData(), this)
        //Way 2
        userListiew.setOnItemClickListener { parent, view, position, id ->
            Log.d("deneme1", "onCreate: $position")
        }
        val list = listOf<String>("Name", "Surname", "Age")

        userListView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
         */

    }

    private fun prepareUserMockData(): MutableList<UserModel> {
        val userList = mutableListOf<UserModel>()
        userList.add(UserModel(1, "John", "Doe", 20))
        userList.add(UserModel(2, "John", "Doe", 21))
        userList.add(UserModel(3, "John", "Doe", 22))
        userList.add(UserModel(4, "Name", "Surname", 23))
        userList.add(UserModel(5, "Name", "Surname", 24))
        userList.add(UserModel(6, "Name", "Surname", 25))
        userList.add(UserModel(4, "Name", "Surname", 23))
        userList.add(UserModel(5, "Name", "Surname", 24))
        userList.add(UserModel(6, "Name", "Surname", 25))
        userList.add(UserModel(5, "Name", "Surname", 24))
        userList.add(UserModel(6, "Name", "Surname", 25))

        return userList
    }

    override fun onUserClicked(userModel: UserModel) {
        Toast.makeText(this, "Clicked: ${userModel.name} - id ${userModel.id}", Toast.LENGTH_SHORT)
            .show()
    }
}