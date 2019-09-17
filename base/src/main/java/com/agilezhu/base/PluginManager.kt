package com.agilezhu.base

import android.app.Application
import android.content.Context
import android.content.res.AssetManager
import android.content.res.Resources
import android.os.Environment
import dalvik.system.DexClassLoader
import java.io.File

/**
 * TODO 请添加说明
 *
 * @author zhujie
 * @date 2019-09-17
 * @time 14:49
 */
class PluginManager {
    companion object {
        const val PLUGIN_PACKAGE = "com.agilezhu.plugin"
        const val PLUGIN_NAME = "plugin.apk"
        lateinit var application: Application
        val dexFile = File(Environment.getExternalStorageDirectory().toString(), PLUGIN_NAME)

        fun getInstance(): PluginManager {
            return InstanceHolder.INSTANCE
        }

        private class InstanceHolder {
            companion object {
                val INSTANCE = PluginManager()
            }
        }
    }

    fun getDexClassLoader(): DexClassLoader? {
        if (!dexFile.exists()) {
            return null
        }
        val dexOutFile = application.getDir("dex", Context.MODE_PRIVATE) ?: null
        return DexClassLoader(
            dexFile.toString(),
            dexOutFile?.absolutePath,
            null, application.classLoader
        )
    }

    fun getResources(): Resources? {
        if (!dexFile.exists()) {
            return null
        }
        val assetManager = AssetManager::class.java.newInstance()
        val addAssetPath = AssetManager::class.java.getMethod("addAssetPath", String::class.java)
        addAssetPath.invoke(assetManager, dexFile.toString())
        return Resources(
            assetManager,
            application.resources.displayMetrics,
            application.resources.configuration
        )
    }
}