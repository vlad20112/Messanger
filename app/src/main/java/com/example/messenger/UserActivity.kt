package com.example.messenger

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.media.Image
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData

val list_avatar: MutableList<Int> = mutableListOf<Int>(
    R.drawable.jotaro,
    R.drawable.josuke,
    R.drawable.joseph
)
class UserActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        var img_b: ImageButton = findViewById<ImageButton>(R.id.img_but)
        img_b.setOnClickListener {
            var fr: AvatarFragment = AvatarFragment()
            fr.show(supportFragmentManager,"TAG")
        }
        var but: Button = findViewById<Button>(R.id.login_but)
        but.setOnClickListener {
            val fieldOne: EditText = findViewById<EditText>(R.id.user_field)
            val fieldTwo: EditText = findViewById<EditText>(R.id.age_field)
            val fieldThree: ImageView = findViewById<ImageView>(R.id.img_field)
            val intent: Intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name", fieldOne.text.toString())
            intent.putExtra("age",fieldTwo.text.toString())
            //передавать ИД, на который пользователь нажал
            //intent.putExtra("avatar",fieldThree.get)
            startActivity(intent)
        }

    }
}