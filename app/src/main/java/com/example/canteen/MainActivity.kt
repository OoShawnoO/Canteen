package com.example.canteen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

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
                    trans1.replace(R.id.container,MyFragment())
                    trans1.commit()
                }
            }

            true
        }

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.top)
        toolbar.setNavigationIcon(R.drawable.wode)
        toolbar.setTitle("点菜app")
    }

}