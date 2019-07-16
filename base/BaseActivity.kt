package com.app.core.base

import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.WindowManager
import com.app.core.permission.model.Permissions

abstract class BaseActivity<T : BaseViewModel> : AppCompatActivity() {
    private val TAG = javaClass.name

    private val listPermission: MutableList<Permissions> = arrayListOf()

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        listPermission.forEach { permissionRq ->
            var indexPermissionExists = -1
            for (i in 0 until permissions.size) {
                if (permissionRq.permission == permissions[i]) {
                    indexPermissionExists = i
                }
            }
            if (indexPermissionExists != -1) {
                Log.d(TAG, " on request permission: ${permissionRq.permission} - granted: ${grantResults[indexPermissionExists]}")
                permissionRq.action(grantResults[indexPermissionExists])
            }
        }
    }

    fun requestPermission(list: MutableList<Permissions>) {
        val listPer = arrayListOf<String>()
        list.forEach {
            it.permission?.let { it1 -> listPer.add(it1) }
        }
        ActivityCompat.requestPermissions(this, listPer.toTypedArray(), 1)
        listPermission.clear()
        listPermission.addAll(list)
    }

    fun onKeepScreen(keepScreenOn: Boolean) {
        if (keepScreenOn) {
            window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }
    }
}
