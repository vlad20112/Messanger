package com.example.messenger

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import java.lang.IllegalStateException

/**
 * A fragment representing a list of Items.
 */
var listIm: MutableList<Int> = mutableListOf(
    R.drawable.jotaro,
    R.drawable.josuke,
    R.drawable.joseph
)
class AvatarFragment : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var root = inflater.inflate(R.layout.fragment_item,container, false)

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
                .setNegativeButton("No",DialogInterface.OnClickListener { dialogInterface, i ->  })
            builder.create()
        } ?: throw IllegalStateException("Ne fartanulo")
    }
}