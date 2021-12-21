package com.applications.preferencemanagement

import android.content.Context
import android.content.res.TypedArray
import android.os.Bundle
import android.util.AttributeSet
import androidx.preference.DialogPreference


class TimePreference(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) :
    DialogPreference(context, attrs, defStyleAttr, defStyleRes) {


    private var mTime = 0
    private val mDialogLayoutResId: Int = R.layout.pref_dialog_time

    init {

    }

    fun getTime(): Int {    return mTime    }

    fun setTime(someTime: Int) {
        mTime = someTime
        persistInt(someTime)
    }

    override fun onGetDefaultValue(a: TypedArray, index: Int): Any {
        // Default value from attribute. Fallback value is set to 0.
        return a.getInt(index, 0)
    }

    override fun onSetInitialValue(
        restorePersistedValue: Boolean,
        defaultValue: Any
    ) {
        // Read the value. Use the default value if it is not possible.
        setTime(if (restorePersistedValue) getPersistedInt(mTime) else defaultValue as Int)
    }

    override fun getDialogLayoutResource(): Int {
        return mDialogLayoutResId
    }

}