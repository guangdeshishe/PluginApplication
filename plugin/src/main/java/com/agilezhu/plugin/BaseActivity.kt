package com.agilezhu.plugin

import android.app.Activity
import android.content.Intent
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
    protected lateinit var that: Activity
    private var isProxy = false

    override fun attach(context: Activity) {
        that = context
        isProxy = true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        if (!this::that.isInitialized) {
            that = this
        }
        if (!isProxy) {
            super.onCreate(savedInstanceState)
        }
    }

    override fun setContentView(layoutResID: Int) {
        if (!isProxy) {
            super.setContentView(layoutResID)
        } else {
            that.setContentView(layoutResID)
        }
    }

    override fun <T : View?> findViewById(id: Int): T {
        return if (!isProxy) {
            super.findViewById<T>(id)
        } else {
            that.findViewById<T>(id)
        }
    }

    override fun getClassLoader(): ClassLoader {
        return if (!isProxy) {
            super.getClassLoader()
        } else {
            that.classLoader
        }
    }

    override fun getLayoutInflater(): LayoutInflater {
        return if (!isProxy) {
            super.getLayoutInflater()
        } else {
            that.layoutInflater
        }
    }

    override fun getWindow(): Window {
        return if (!isProxy) {
            super.getWindow()
        } else {
            that.window
        }
    }

    override fun getWindowManager(): WindowManager {
        return if (!isProxy) {
            super.getWindowManager()
        } else {
            that.windowManager
        }
    }

    override fun startActivity(intent: Intent?) {
        if (!isProxy) {
            super.startActivity(intent)
        } else {
            that.startActivity(intent)
        }
    }

    override fun onStart() {
        if (!isProxy) {
            super.onStart()
        }
    }

    override fun onResume() {
        if (!isProxy) {
            super.onResume()
        }
    }

    override fun onPause() {
        if (!isProxy) {
            super.onPause()
        }
    }

    override fun onStop() {
        if (!isProxy) {
            super.onStop()
        }
    }

    override fun onDestroy() {
        if (!isProxy) {
            super.onDestroy()
        }
    }
}