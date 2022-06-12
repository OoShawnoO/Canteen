package com.example.canteen

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    
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

        val manager1 = supportFragmentManager
        val trans1 = manager.beginTransaction()
        trans1.replace(R.id.Set,SetFragment())
        trans1.commit()

        val shopcar = findViewById<FloatingActionButton>(R.id.shopcar)
        shopcar.setOnClickListener{
            val set = findViewById<FragmentContainerView>(R.id.Set)
            if(set.visibility== View.VISIBLE){
                set.visibility = View.GONE
            }
            else{
                set.visibility = View.VISIBLE
            }
        }
    }

}