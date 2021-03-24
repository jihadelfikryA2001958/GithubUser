package com.example.githubuser

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailUser : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)
        val actionbar = supportActionBar
        actionbar!!.title = "Detail User"

        val names : TextView = findViewById(R.id.tv_nameDetail)
        val usernames :TextView= findViewById(R.id.tv_username)
        val companies: TextView= findViewById(R.id.tv_company)
        val photos: ImageView = findViewById(R.id.img_photoDetail)

        //val tName = intent.getStringExtra(EXTRA_NAME)
        //val tUsername = intent.getStringExtra(EXTRA_USERNAME)
        //val tCompany = intent.getStringExtra(EXTRA_COMPANY)
        //val tPhoto = intent.getIntExtra(EXTRA_PHOTO, 0)

        /*names.text = tName
        usernames.text = tUsername
        companies.text = tCompany
        Glide.with(this)
            .load(tPhoto)
            .apply(RequestOptions())
            .into(photos)*/

        val user = intent.getParcelableExtra<User>("EXTRA_USER") as User
    }
    companion object {
        //const val EXTRA_NAME = "extra_name"
        //const val EXTRA_USERNAME = "extra_username"
        //const val EXTRA_COMPANY = "extra_company"
        //const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_USER = "extra_user"
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}