package com.cs4540.sci_cafe.utils
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import android.annotation.SuppressLint
import java.util.*

@SuppressLint("SimpleDateFormat")
fun convertLongToDateString(date: Date): String {
    return SimpleDateFormat("yyyy/dd/MM")
        .format(date).toString()
}