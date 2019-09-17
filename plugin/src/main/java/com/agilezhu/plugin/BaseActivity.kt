package com.agilezhu.plugin

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.agilezhu.base.IPluginActivity

/**
 * TODO 请添加说明
 *
 * @author zhujie
 * @date 2019-09-17
 * @time 16:19
 */
open class BaseActivity : AppCompatActivity(), IPluginActivity {
    protected var that: Activity? = null

    override fun attach(context: Activity) {
        that = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        if (that == null) {
            super.onCreate(savedInstanceState)
        }
    }

    override fun setContentView(layoutResID: Int) {
        if (that == null) {
            super.setContentView(layoutResID)
        } else {
            that!!.setContentView(layoutResID)
        }
    }

    override fun <T : View?> findViewById(id: Int): T {
        return if (that == null) {
            super.findViewById<T>(id)
        } else {
            that!!.findViewById<T>(id)
        }
    }

    override fun getClassLoader(): ClassLoader {
        return if (that == null) {
            super.getClassLoader()
        } else {
            that!!.classLoader
        }
    }

    override fun getLayoutInflater(): LayoutInflater {
        return if (that == null) {
            super.getLayoutInflater()
        } else {
            that!!.layoutInflater
        }
    }

    override fun getWindow(): Window {
        return if (that == null) {
            super.getWindow()
        } else {
            that!!.window
        }
    }

    override fun getWindowManager(): WindowManager {
        return if (that == null) {
            super.getWindowManager()
        } else {
            that!!.windowManager
        }
    }

    override fun onStart() {
        if (that == null) {
            super.onStart()
        }
    }

    override fun onResume() {
        if (that == null) {
            super.onResume()
        }
    }

    override fun onPause() {
        if (that == null) {
            super.onPause()
        }
    }

    override fun onStop() {
        if (that == null) {
            super.onStop()
        }
    }

    override fun onDestroy() {
        if (that == null) {
            super.onDestroy()
        }
    }
}