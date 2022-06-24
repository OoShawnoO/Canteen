package com.example.canteen

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
val CateenItem = arrayListOf<Cateen>()
/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        val recycler = view.findViewById<RecyclerView>(R.id.cateen_recycler)
        recycler.layoutManager = LinearLayoutManager(activity)
        recycler.adapter = CateenAdapter(CateenItem)
    }

    fun initData(){
        CateenItem.add(Cateen().apply {
            name = "西南大学食堂"
            content = "非常的好吃"
            distance = "0.12km"
            state = "正在营业"
            Image = R.drawable.meishi
        })
        CateenItem.add(Cateen().apply {
            name = "天生丽街喵喵烤肉"
            content = "非常的好吃"
            distance = "0.48km"
            state = "正在营业"
            Image = R.drawable.meishi2
        })
        CateenItem.add(Cateen().apply {
            name = "北木川"
            content = "非常的好吃"
            distance = "0.33km"
            state = "正在营业"
            Image = R.drawable.meishi3
        })
        CateenItem.add(Cateen().apply {
            name = "东北人家饺子馆"
            content = "非常的好吃"
            distance = "1.12km"
            state = "正在营业"
            Image = R.drawable.meishi4
        })
        CateenItem.add(Cateen().apply {
            name = "晓秧锅"
            content = "非常的好吃"
            distance = "2.13km"
            state = "正在营业"
            Image = R.drawable.meishi
        })

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}