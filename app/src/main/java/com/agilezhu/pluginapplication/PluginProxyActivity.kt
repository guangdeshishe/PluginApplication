package com.agilezhu.pluginapplication

import android.app.Activity
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.agilezhu.base.IPluginActivity
import com.agilezhu.base.PluginManager

/**
 * 代理插件Activity
 *
 * @author zhujie
 * @date 2019-09-17
 * @time 14:25
 */
class PluginProxyActivity : AppCompatActivity() {

    var pluginActivity: IPluginActivity? = null

    companion object {
        private const val PLUGIN_ACTIVITY_NAME_KEY = "plugin_activity_name_key"
        fun open(context: Activity, pluginActivityName: String) {
            val intent = Intent(context, PluginProxyActivity::class.java)
            intent.putExtra(PLUGIN_ACTIVITY_NAME_KEY, pluginActivityName)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val pluginActivityName = intent.getStringExtra(PLUGIN_ACTIVITY_NAME_KEY)
        val clazz = classLoader.loadClass(pluginActivityName)
        pluginActivity = clazz.newInstance() as? IPluginActivity
        pluginActivity?.attach(this)
        pluginActivity?.onCreate(savedInstanceState)
    }

    override fun getClassLoader(): ClassLoader {
        return PluginManager.getInstance().getDexClassLoader() ?: super.getClassLoader()
    }

    override fun getResources(): Resources {
        return PluginManager.getInstance().getResources() ?: super.getResources()
    }

    override fun onStart() {
        super.onStart()
        pluginActivity?.onStart()
    }

    override fun onResume() {
        super.onResume()
        pluginActivity?.onResume()
    }

    override fun onPause() {
        super.onPause()
        pluginActivity?.onPause()
    }

    override fun onStop() {
        super.onStop()
        pluginActivity?.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        pluginActivity?.onDestroy()
    }
}