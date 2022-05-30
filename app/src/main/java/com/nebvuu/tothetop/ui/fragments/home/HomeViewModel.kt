package com.nebvuu.tothetop.ui.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nebvuu.tothetop.R

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    private val _test = MutableLiveData<String>().apply {
        value = "This is test"
    }


    private val _image = MutableLiveData<Int>().apply {
        value = R.drawable.profile_user
    }

    val text: LiveData<String> = _text
    val textTest: LiveData<String> = _test

    val image:LiveData<Int> = _image
}