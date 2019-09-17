package com.agilezhu.base

import android.app.Activity
import android.os.Bundle

/**
 * 插件Activity需要实现该接口供宿主调用
 *
 * @author zhujie
 * @date 2019-09-17
 * @time 14:36
 */
interface IPluginActivity {
    fun attach(context: Activity)
    fun onCreate(savedInstanceState: Bundle?)
    fun onStart()
    fun onResume()
    fun onPause()
    fun onStop()
    fun onDestroy()
}