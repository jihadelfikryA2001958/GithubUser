package com.example.githubuser

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.example.githubuser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var adapter: UserAdapter

    private lateinit var binding: ActivityMainBinding

    private lateinit var dataUsername: Array<String>
    private lateinit var dataName: Array<String>
    private lateinit var dataPhoto: TypedArray
    private lateinit var dataCompany: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var dataFollowers: Array<String>
    private lateinit var dataRepository: Array<String>

    private var gitusers = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        adapter = UserAdapter(this)
        binding.lvGitUser.divider = null
        binding.lvGitUser.adapter = adapter

        prepare()
        addItem()

        binding.lvGitUser.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                val moveUser = User(
                    username = gitusers[position].username,
                    name = gitusers[position].name,
                    avatar = gitusers[position].avatar,
                    company = gitusers[position].company,
                    location = gitusers[position].location,
                    following = gitusers[position].following,
                    followers = gitusers[position].followers,
                    repository = gitusers[position].repository
                )

                val moveToDetail = Intent(this, DetailUser::class.java)
                moveToDetail.putExtra(DetailUser.EXTRA_USER, moveUser)
                this.startActivity(moveToDetail)
            }

    }

    private fun addItem() {
        for (position in dataName.indices) {
            val user = User(
                dataUsername[position],
                dataName[position],
                dataPhoto.getResourceId(position, -1),
                dataCompany[position],
                dataLocation[position],
                dataFollowing[position],
                dataFollowers[position],
                dataRepository[position]
            )
            gitusers.add(user)
        }
        adapter.gitusers = gitusers
    }

    private fun prepare() {
        dataName = resources.getStringArray(R.array.data_name)
        dataUsername = resources.getStringArray(R.array.data_username)
        dataCompany = resources.getStringArray(R.array.data_company)
        dataPhoto = resources.obtainTypedArray(R.array.data_avatar)
        dataLocation = resources.getStringArray(R.array.data_location)
        dataRepository = resources.getStringArray(R.array.data_repository)
        dataFollowers = resources.getStringArray(R.array.data_followers)
        dataFollowing = resources.getStringArray(R.array.data_following)
    }

}