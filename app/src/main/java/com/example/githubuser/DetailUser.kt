package com.example.githubuser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.githubuser.databinding.ActivityDetailUserBinding

class DetailUser : AppCompatActivity() {

    private lateinit var binding: ActivityDetailUserBinding

    companion object {
        const val EXTRA_USER = "EXTRA_USER"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val actionbar = supportActionBar
        actionbar!!.title = "Detail User"
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val users = intent.getParcelableExtra<User>(EXTRA_USER) as User

        binding.imgPhotoDetail.setImageResource(users.avatar)
        binding.tvNameDetail.text = users.name.toString()
        binding.tvUsernameDetail.text = "@"+users.username.toString()
        binding.tvCompanyDetail.text = users.company
        binding.tvLocationDetail.text = "Located at "+users.location
        binding.tvFollowingDetail.text = users.following+"\nFollowing"
        binding.tvFollowersDetail.text = users.followers+"\nFollowers"
        binding.tvRepositoryDetail.text = users.repository+"\nRepositories"

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}