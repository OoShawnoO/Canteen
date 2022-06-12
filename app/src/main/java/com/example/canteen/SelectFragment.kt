package com.example.canteen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class SelectFragment : Fragment() {

    val dishItems = arrayListOf<Dish>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        val recycler = view.findViewById<RecyclerView>(R.id.dish_recycler)
        recycler.layoutManager = LinearLayoutManager(activity)
        recycler.adapter = DishAdapter(dishItems)
        val manager = activity?.supportFragmentManager
        val trans = manager?.beginTransaction()
        trans?.replace(R.id.sidemenu,SideMenuFragment())
        trans?.commit()


    }

    fun initData(){
        dishItems.add(Dish().apply {
            name = "虾虾"
            content = "很好吃的虾"
            description = "非常好评"
            Image = R.drawable.meishi
            price = "$30.0元"
        })
        dishItems.add(Dish().apply {
            name = "虾虾"
            content = "很好吃的虾"
            description = "非常好评"
            Image = R.drawable.meishi
            price = "$30.0元"
        })
        dishItems.add(Dish().apply {
            name = "虾虾"
            content = "很好吃的虾"
            description = "非常好评"
            Image = R.drawable.meishi
            price = "$30.0元"
        })
        dishItems.add(Dish().apply {
            name = "虾虾"
            content = "很好吃的虾"
            description = "非常好评"
            Image = R.drawable.meishi
            price = "$30.0元"
        })
        dishItems.add(Dish().apply {
            name = "虾虾"
            content = "很好吃的虾"
            description = "非常好评"
            Image = R.drawable.meishi
            price = "$30.0元"
        })
        dishItems.add(Dish().apply {
            name = "虾虾"
            content = "很好吃的虾"
            description = "非常好评"
            Image = R.drawable.meishi
            price = "$30.0元"
        })



    }

    companion object {

    }
}