package com.example.canteen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.concurrent.thread


class SetFragment : Fragment() {
    val setItems = arrayListOf<Set>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_set, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    fun initData(){
        setItems.add(Set().apply {
            name = "烧烤"
            price = "$10.0"
            count = 5
            Image = R.drawable.meishi
        })
        setItems.add(Set().apply {
            name = "烧烤"
            price = "$10.0"
            count = 5
            Image = R.drawable.meishi
        })
        setItems.add(Set().apply {
            name = "烧烤"
            price = "$10.0"
            count = 5
            Image = R.drawable.meishi
        })
        setItems.add(Set().apply {
            name = "烧烤"
            price = "$10.0"
            count = 5
            Image = R.drawable.meishi
        })
    }

    companion object {
    }
}