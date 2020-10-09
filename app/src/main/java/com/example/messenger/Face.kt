package com.example.messenger

import android.graphics.Bitmap

class Face(name: String, age: Int, avatar: Bitmap) {
    private var mName: String = name
    private var mAge: Int = age
    private var mAvatar: Bitmap = avatar
    fun setName(a: String) {
        mName = a
    }
    fun getName(): String = mName
    fun setAge(a: Int)
    {
        mAge = a
    }
    fun getAge(): Int = mAge
    fun getAvatar(): Bitmap = mAvatar
    fun getAvatar(a: Bitmap) {
        mAvatar = a
    }
}