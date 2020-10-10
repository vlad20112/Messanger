package com.example.messenger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import java.util.ArrayList
import java.util.zip.Inflater

var database: FirebaseDatabase = FirebaseDatabase.getInstance()
var myRef: DatabaseReference = database.getReference("mesage")
lateinit var user_data: Face
lateinit var request : Face
lateinit var name: String
lateinit var age: String
lateinit var message_list: MutableList<String>

lateinit var recyclerView: RecyclerView
lateinit var recyclerAdapter: RecyclerView.Adapter<*>
lateinit var viewManager: RecyclerView.LayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*Блок добавления*/
        message_list= mutableListOf()
        name = "Human"
        age = "44"

        viewManager = LinearLayoutManager(this)
        recyclerAdapter = MessageAdapter(message_list, name, age)

        var butter: Button = findViewById<Button>(R.id.but)
        butter.setOnClickListener {
            var txt: EditText = findViewById(R.id.message_field)
            var perem: String = txt.text.toString()
            message_list.add(txt.text.toString())
           myRef.push().setValue(perem)
        }
        myRef.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(p0: DataSnapshot) {
                recyclerView = findViewById<RecyclerView>(R.id.message_list).apply {
                    layoutManager = viewManager
                    adapter = recyclerAdapter
                }
                //Добавить кусок кода, в котором будет происходить обновление списка с сообщениями
                Log.d("DatabaseMessage", p0.getValue().toString())
            }
        })
        myRef.addChildEventListener(object: ChildEventListener{
            override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                val msg: String = p0.getValue().toString()
                message_list.add(msg)
            }

            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onChildChanged(p0: DataSnapshot, p1: String?) {
                TODO("Not yet implemented")
            }

            override fun onChildMoved(p0: DataSnapshot, p1: String?) {
                TODO("Not yet implemented")
            }

            override fun onChildRemoved(p0: DataSnapshot) {
                TODO("Not yet implemented")
            }
        })

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        var b: Bundle? = data?.extras
        //name = b?.get("name").toString()
        //age = b?.get("age").toString()
        super.onActivityResult(requestCode, resultCode, data)
    }
}