package com.merttoptas.listviewexample.listviewexample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.merttoptas.listviewexample.R
import com.merttoptas.listviewexample.listviewexample.UserModel

/**
 * Created by merttoptas on 2.10.2022.
 */

class UserAdapter(private val userData: MutableList<UserModel>, private val listener: UserAdapterListener) :
    BaseAdapter() {
    override fun getCount(): Int {
        return userData.size
    }

    override fun getItem(position: Int): Any {
        return userData[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        if (convertView == null) {
            val userDataItem = userData[position]
            val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_user_layout, parent, false)

            val cardView = view.findViewById<CardView>(R.id.cardView)
            val tvName = view.findViewById<TextView>(R.id.tvName)
            val tvSurname = view.findViewById<TextView>(R.id.tvSurname)
            val tvAge = view.findViewById<TextView>(R.id.tvAge)

            tvName.text = userDataItem.name
            tvSurname.text = userDataItem.surname
            tvAge.text = userDataItem.age.toString()

            cardView.setOnClickListener {
                listener.onUserClicked(userDataItem)
            }

            return view
        } else {
            return convertView
        }
    }
}

interface UserAdapterListener {
    fun onUserClicked(userModel: UserModel)
}