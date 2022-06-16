package com.example.canteen

import android.annotation.SuppressLint
import android.content.ContentValues
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

lateinit var utils:DBUtils
lateinit var adapter:SetAdapter

private var toUpdate:Set? =null
class SetAdapter: RecyclerView.Adapter<SetAdapter.SetViewHolder>() {
    val data = arrayListOf<Set>()

    inner class SetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var id: TextView? = null
        var name: TextView? = null
        var count: TextView? = null
        var price: TextView? = null
        var img: ImageView? = null
        var btnDelete: ImageView? = null

        fun render(set: Set) {
            id?.text = set.id.toString()
            name?.text = set.name
            count?.text = set.count.toString()
            price?.text = set.price
            img?.setImageResource(set.Image)
            btnDelete?.setOnClickListener {
                val db = utils.writableDatabase
                db.delete(Set.TABLE, "id = ?", arrayOf(set.id.toString()))
                adapter.itemDeleted(set.id)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SetViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.set_item, parent, false)
        return SetViewHolder(view).apply {
            id = view.findViewById(R.id.id)
            name = itemView.findViewById<TextView>(R.id.SetName)
            count = itemView.findViewById<TextView>(R.id.SetCount)
            price = itemView.findViewById<TextView>(R.id.SetPrice)
            img = itemView.findViewById<ImageView>(R.id.SetImage)
        }
    }

    override fun onBindViewHolder(holder: SetViewHolder, position: Int) {
        holder.render(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(arr: ArrayList<Set>) {
        data.addAll(arr)

        notifyDataSetChanged()
    }

    fun addItem(item: Set) {
        data.add(0, item)
        notifyItemInserted(0)
    }

    fun replaceItem(id: Int?, item: Set) {
        val idx = findIdx(id)
        if (idx >= 0) {
            data.set(idx, item)
            notifyItemChanged(idx)
        }

    }

    private fun findIdx(id: Int?): Int {
        var idx = -1
        data.forEachIndexed { index, todo ->
            if (todo.id == id) {
                idx = index
            }
        }
        return idx
    }

    fun itemDeleted(id: Int?) {
        val idx = findIdx(id)
        if (idx >= 0) {
            data.removeAt(idx)
            notifyItemRemoved(idx)
        }
    }
}


class MainActivity : AppCompatActivity() {
    var mListener:(()->Unit)? = null
    operator fun invoke(name1: String,price1: String,count1: Int,image1: Int){
        saveInDb(name1,price1,count1,image1)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = supportFragmentManager
        val trans = manager.beginTransaction()
        trans.replace(R.id.container,HomeFragment())
        trans.commit()

        findViewById<BottomNavigationView>(R.id.bottom).setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menu_select -> {
                    val trans1 = manager.beginTransaction()
                    trans1.replace(R.id.container,SelectFragment())
                    trans1.commit()
                }
                R.id.menu_home -> {
                    val trans1 = manager.beginTransaction()
                    trans1.replace(R.id.container,HomeFragment())
                    trans1.commit()
                }
                R.id.menu_my -> {
                    val trans1 = manager.beginTransaction()
                    trans1.replace(R.id.container,CustomerFragment())
                    trans1.commit()
                }
            }

            true
        }
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.top)
        toolbar.setNavigationIcon(R.drawable.small)
        toolbar.setTitle("点菜app")


        val shopcar = findViewById<FloatingActionButton>(R.id.shopcar)
        shopcar.setOnClickListener{
            val set = findViewById<RecyclerView>(R.id.set_recyler)
            if(set.visibility== View.VISIBLE){
                set.visibility = View.GONE
            }
            else{
                set.visibility = View.VISIBLE
            }
        }
        init()

    }

    fun init(){
        utils = DBUtils(this,"set.db",1)
        adapter = SetAdapter()
        val recycler = findViewById<RecyclerView>(R.id.set_recyler)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
        readInDb()
        val container = findViewById<FragmentContainerView>(R.id.container)
        container.setOnClickListener{
            Log.d("@@@@","AAAAAAA")
            saveInDb(
                "鸡肉","$20",1,R.drawable.meishi2
            )
        }
    }

    @SuppressLint("Range")
    private fun readInDb() {
        val db = utils.readableDatabase
        val cursor = db.query(Set.TABLE,null,null,null,null,null,
            "${Set.COL_ID} asc ")
        val arr = arrayListOf<Set>()
        if(cursor.moveToFirst()){
            do{
                arr.add(
                    Set().apply {
                        id = cursor.getInt(cursor.getColumnIndex(Set.COL_ID))
                        name = cursor.getString(cursor.getColumnIndex(Set.COL_NAME))
                        price = cursor.getString(cursor.getColumnIndex(Set.COL_PRICE))
                        count = cursor.getInt(cursor.getColumnIndex(Set.COL_COUNT))
                        Image = cursor.getInt(cursor.getColumnIndex(Set.COL_IMAGE))
                    }
                )
            }while (cursor.moveToNext())
        }
        adapter.setData(arr)

        cursor.close()
    }

    private fun saveInDb(name1:String,price1:String,count1:Int,image1:Int) {
        val db = utils.writableDatabase
        val item = Set().apply {
            name = name1
            price = price1
            count = count1
            Image = image1
        }
        val values = ContentValues().apply {
            put(Set.COL_IMAGE,item.Image)
            put(Set.COL_COUNT,item.count)
            put(Set.COL_PRICE,item.price)
            put(Set.COL_NAME,item.name)
        }
        var rs = -1
        if(toUpdate != null){
            item.id = toUpdate?.id

            rs = db.update(Set.TABLE,values,"id = ?", arrayOf(toUpdate?.id.toString()))
            if(rs != -1 ){
                adapter.replaceItem(toUpdate?.id,item)
                toUpdate = null
            }
        }else{
            rs = db.insert(Set.TABLE,null,values).toInt()
            if(rs != -1 ){
                item.id = rs
                adapter.addItem(item)
            }
        }

    }
    
}

