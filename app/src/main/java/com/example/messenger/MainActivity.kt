package com.example.messenger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.*
import java.util.ArrayList

var database: FirebaseDatabase = FirebaseDatabase.getInstance()
var myRef: DatabaseReference = database.getReference("mesage")
lateinit var user_data: Face
lateinit var request : Face
lateinit var message_list: MutableList<String>
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*Блок добавления*/
        var butter: Button = findViewById<Button>(R.id.but)
        butter.setOnClickListener {
            var txt: EditText = findViewById(R.id.message_field)
            var perem: String = txt.text.toString()
           myRef.setValue(perem)
        }
        myRef.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(p0: DataSnapshot) {
                //Добавить кусок кода, в котором будет происходить обновление списка с сообщениями
                Log.d("DatabaseMessage", p0.getValue().toString())
            }
        })

    }
}