package com.agilezhu.pluginapplication

import android.app.Application
import com.agilezhu.base.PluginManager

/**
 * TODO 请添加说明
 *
 * @author zhujie
 * @date 2019-09-17
 * @time 15:04
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        PluginManager.application = this
    }
}