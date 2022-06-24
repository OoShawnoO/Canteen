package com.example.canteen

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class SelectFragment : Fragment() {

    val dishItems = arrayListOf<Dish>()
    private var duration = 0
    private var finished = false

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

         val video = view.findViewById<VideoView>(R.id.video).apply{
             var uri = Uri.parse("android.resource://${BuildConfig.APPLICATION_ID}/${R.raw.video}")
             this.setVideoURI(uri)
             this.setOnPreparedListener { this@SelectFragment.duration = it.duration}
             this.setOnCompletionListener {
                 finished = true
             }
             this.setOnInfoListener { mp, what, extra ->
                 false
             }
         }
        video.start()



        initData()
        val recycler = view.findViewById<RecyclerView>(R.id.dish_recycler)
        recycler.layoutManager = LinearLayoutManager(activity)
        var dish = DishAdapter(dishItems)
        recycler.adapter = dish
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