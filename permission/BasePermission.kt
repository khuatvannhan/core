package com.app.core.permission

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.support.v4.content.ContextCompat.checkSelfPermission
import com.app.core.permission.model.Permissions

class BasePermission {
    private val permissions: MutableList<Permissions> = arrayListOf()

    fun onReadCalendar(action: (Int) -> Unit) {
        permissions.add(Permissions(Manifest.permission.READ_CALENDAR, action = action))
    }

    fun onWriteCalendar(action: (Int) -> Unit) {
        permissions.add(Permissions(Manifest.permission.WRITE_CALENDAR, action = action))
    }

    fun onReadContacts(action: (Int) -> Unit) {
        permissions.add(Permissions(Manifest.permission.READ_CONTACTS, action = action))
    }

    fun onWriteContacts(action: (Int) -> Unit) {
        permissions.add(Permissions(Manifest.permission.WRITE_CONTACTS, action = action))
    }

    fun onReadStorage(action: (Int) -> Unit) {
        permissions.add(
            Permissions(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                action = action
            )
        )
    }

    fun onWriteStorage(action: (Int) -> Unit) {
        permissions.add(
            Permissions(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                action = action
            )
        )
    }

    fun onRecordAudio(action: (Int) -> Unit) {
        permissions.add(Permissions(Manifest.permission.RECORD_AUDIO, action = action))
    }

    fun onCamera(action: (Int) -> Unit) {
        permissions.add(Permissions(Manifest.permission.CAMERA, action = action))
    }

    fun onAccessCoarseLocation(action: (Int) -> Unit) {
        permissions.add(
            Permissions(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                action = action
            )
        )
    }

    fun onAccessFineLocation(action: (Int) -> Unit) {
        permissions.add(
            Permissions(
                Manifest.permission.ACCESS_FINE_LOCATION,
                action = action
            )
        )
    }

    /**
     * ---------------------------------------------- check permission below -------------------------------------------
     */

    fun isOnReadCalendar(context: Context): Boolean {
        return checkSelfPermission(context, Manifest.permission.READ_CALENDAR) != PackageManager.PERMISSION_GRANTED
    }

    fun onWriteCalendar(context: Context): Boolean {
        return checkSelfPermission(context, Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED
    }

    fun onReadContacts(context: Context): Boolean {
        return checkSelfPermission(context, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED
    }

    fun isOnWriteContacts(context: Context): Boolean {
        return checkSelfPermission(context, Manifest.permission.WRITE_CONTACTS) != PackageManager.PERMISSION_GRANTED
    }

    fun isOnReadStorage(context: Context): Boolean {
        return checkSelfPermission(
            context,
            Manifest.permission.READ_EXTERNAL_STORAGE
        ) != PackageManager.PERMISSION_GRANTED
    }

    fun isOnWriteStorage(context: Context): Boolean {
        return checkSelfPermission(
            context,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        ) != PackageManager.PERMISSION_GRANTED
    }

    fun isOnRecordAudio(context: Context): Boolean {
        return checkSelfPermission(context, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED
    }

    fun isOnCamera(context: Context): Boolean {
        return checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
    }

    fun isOnAccessCoarseLocation(context: Context): Boolean {
        return checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED
    }

    fun isOnAccessFineLocation(context: Context): Boolean {
        return checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED
    }

    fun getPermissions(): MutableList<Permissions> {
        return permissions
    }

    fun clearListPermission() {
        permissions.clear()
    }
}
