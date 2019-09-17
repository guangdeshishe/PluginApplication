package com.agilezhu.plugin

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTitleView.setOnClickListener {
            //            Toast.makeText(that, "你好，我是插件", Toast.LENGTH_SHORT).show()
            val intent = Intent(that, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
