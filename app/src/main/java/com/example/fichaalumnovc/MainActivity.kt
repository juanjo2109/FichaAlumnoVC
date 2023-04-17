package com.example.fichaalumnovc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ScrollView
import androidx.core.view.doOnAttach
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val scope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scrollView = findViewById<ScrollView>(R.id.scrollview)

        scrollView.doOnAttach {
            beginToScroll(scrollView)
        }
    }

    private fun beginToScroll(scrollView: ScrollView) {
        scope.launch {
            val scrollUnits = 18
            while (scrollView.canScrollVertically(1)) {
                scrollView.smoothScrollBy(0, scrollUnits)
                delay(100)
            }
        }
    }

}