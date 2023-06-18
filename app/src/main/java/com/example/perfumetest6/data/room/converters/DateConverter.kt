package com.example.perfumetest6.data.room.converters

import androidx.room.TypeConverter
import java.util.Date

open class DateConverter{
    @TypeConverter
    fun toDate(date: Long?): Date? {
       return date?.let {Date(it) }
    }

    @TypeConverter
    fun fromDate(date: Date):Long?{
        return date?.time
    }
}