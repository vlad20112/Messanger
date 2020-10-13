package com.example.messenger.Logic

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.messenger.Adapters.AvatarAdapter
import com.example.messenger.R
import java.lang.IllegalStateException

/**
 * A fragment representing a list of Items.
 */
var listIm: MutableList<Int> = mutableListOf(
    R.drawable.jotaro,
    R.drawable.josuke,
    R.drawable.joseph
)
var seqList: Array<CharSequence> = arrayOf("jotaro","joseph","josuke")
class AvatarFragment : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var root = inflater.inflate(R.layout.fragment_item,container, false)
        var avatar: ImageView = root.findViewById(R.id.img_field)

        return root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            var recyclerView: RecyclerView
            var viewAdapter: RecyclerView.Adapter<*>
            var viewManager: RecyclerView.LayoutManager

            viewManager = LinearLayoutManager(it)
            viewAdapter = AvatarAdapter(listIm)
            val builder = AlertDialog.Builder(it)
                .setTitle("Выбор аватарки")
                .setItems(seqList, object : DialogInterface.OnClickListener{
                    override fun onClick(p0: DialogInterface?, p1: Int) {

                        when(p1)
                        {
                            0 -> {

                                Toast.makeText(it,"First message",Toast.LENGTH_LONG).show()
                            }
                            1 -> {
                                Toast.makeText(it,"Second message",Toast.LENGTH_LONG).show()
                            }
                            2 -> {
                                Toast.makeText(it,"Third message",Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                })
                .setPositiveButton("Yes", DialogInterface.OnClickListener{ dialogInterface, i ->  })
                .setNegativeButton("No",DialogInterface.OnClickListener { dialogInterface, i ->  })
            builder.create()
        } ?: throw IllegalStateException("Ne fartanulo")
    }

    override fun onAttach(context: Context) {

        super.onAttach(context)
    }
}