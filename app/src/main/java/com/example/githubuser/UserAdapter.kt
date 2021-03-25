package com.example.githubuser

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.githubuser.databinding.ItemUserBinding

class UserAdapter constructor(private val context: Context) :
    BaseAdapter() {

    var users = arrayListOf<User>()


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if (itemView==null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)
        }
        val viewHolder = ViewHolder(itemView as View)

        val user = getItem(position) as User
        viewHolder.bind(user)
        return itemView
    }

    private inner class ViewHolder constructor(private val view: View){

        var binding = ItemUserBinding.bind(view)

        fun bind(user: User) {
            with(view) {
                binding.tvUsername.text = user.name
                binding.tvCompany.text = user.company
                binding.imgPhoto.setImageResource(user.avatar)
            }
        }
    }

    override fun getCount(): Int {
        return users.size
    }

    override fun getItem(position: Int): Any {
        return users[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }



}