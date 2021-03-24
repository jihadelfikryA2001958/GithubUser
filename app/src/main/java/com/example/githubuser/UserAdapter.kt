package com.example.githubuser

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UserAdapter(private val listUser: ArrayList<User>) :
    RecyclerView.Adapter<UserAdapter.ListViewHolder>() {

    //private lateinit var binding: ItemUserBinding
    //private lateinit var bindiing: ActivityDetailUserBinding
    //internal var users = arrayListOf<User>()

    //private lateinit var onClick: (User) -> Unit

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvUsername: TextView = itemView.findViewById(R.id.tv_username)
        var tvCompany: TextView = itemView.findViewById(R.id.tv_company)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_photo)

        fun bind(user: User) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(user.avatar)
                    .into(imgPhoto)
                tvUsername.text = user.username
                tvCompany.text = user.company
            }

            /*itemView.setOnClickListener {
                onClick(user)
            }*/
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_user, viewGroup, false)
        return ListViewHolder(view)
    }

    var users = arrayListOf<User>()

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listUser[position])
        val user = listUser[position]

        val uUser = holder.itemView.context

        holder.itemView.setOnClickListener {

            val moveData = User(
                listUser[position].username,
                listUser[position].name,
                listUser[position].avatar,
                listUser[position].company
            )

            val intent = Intent(uUser, DetailUser::class.java)
            intent.putParcelableArrayListExtra(DetailUser.EXTRA_USER, ArrayList<User>())
            uUser.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listUser.size
    }
    /*}(){
     internal var users = arrayListOf<User>()

     override fun getCount(): Int {
         return users.size
     }

     override fun getItem(i: Int): Any {
         return users[i]
     }

     override fun getItemId(i: Int): Long {
         return i.toLong()
     }

     //override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
       //  var itemView=view
         //if (itemView==null){
           //  itemView=LayoutInflater.from(context).inflate(R.layout.item_user, viewGroup, false)
         //}

         //val viewHolder = ViewHolder(itemView as View)
         //val user = getItem(position) as User
         //viewHolder.bind(user)
         //return itemView
     }

     //private inner class ViewHolder internal constructor(view: View){
       //  private val binding = ItemUserBinding.bind(view)

         //internal fun bind(user:User){
           //  binding.tvUsername.setText(user.username)
             //binding.tvCompany.setText(user.company)
             //binding.imgPhoto.setImageResource(user.avatar)
         //}




     }*/
}