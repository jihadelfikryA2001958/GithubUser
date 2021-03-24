package com.example.githubuser

import android.content.res.TypedArray
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubuser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var rvUser: RecyclerView

    private lateinit var adapter: UserAdapter
    private lateinit var binding: ActivityMainBinding

    private lateinit var dataName: Array<String>
    private lateinit var dataUsername: Array<String>
    private lateinit var dataPhoto: TypedArray
    private lateinit var dataCareer: Array<String>

    private var users: ArrayList<User> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUser = findViewById(R.id.rv_list)
        val userAdapter = UserAdapter(users)
        rvUser.adapter = userAdapter
        rvUser.layoutManager = LinearLayoutManager(this)

        dataName = resources.getStringArray(R.array.data_name)
        dataUsername = resources.getStringArray(R.array.data_username)
        dataCareer = resources.getStringArray(R.array.data_career)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)

        for (position in dataName.indices) {
            val user = User(
                dataUsername[position],
                dataName[position],
                dataPhoto.getResourceId(position, -1),
                dataCareer[position]
            )
            users.add(user)
        }
    }
}

        //prepare()
        //addItem()

        /*recyclerView.setOnClickListener{
            val moveIntent = Intent(this, DetailUser::class.java)
            moveIntent.putExtra(DetailUser.EXTRA_NAME, dataName)
            moveIntent.putExtra(DetailUser.EXTRA_USERNAME, dataUsername)

            //moveIntent.put(DetailUser.EXTRA_PHOTO, dataPhoto)
            startActivity(moveIntent)
        } //AdapterView.OnItemClickListener { _, _, position, _ ->
            //val moveIntent = Intent(this, DetailUser::class.java)
            //moveIntent.putExtra(DetailUser.EXTRA_NAME, dataName)
            //moveIntent.putExtra(DetailUser.EXTRA_USERNAME, dataUsername)

            //moveIntent.put(DetailUser.EXTRA_PHOTO, dataPhoto)
            //startActivity(moveIntent)
        }
    }

    /*private fun prepare() {
        var dataName = resources.getStringArray(R.array.data_name)
        var dataUsername = resources.getStringArray(R.array.data_username)
        var dataCareer = resources.getStringArray(R.array.data_career)
        var dataPhoto = resources.obtainTypedArray(R.array.data_photo)
    }

    private fun addItem() {
        for (position in dataName.indices){
            val user = User(
                dataUsername[position],
                dataName[position],
                dataPhoto.getResourceId(position, -1),
                dataCareer[position]
            )
            users.add(user)
        }
        adapter.users= users
    }*/