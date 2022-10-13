package edu.temple.colorfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ColorViewModel : ViewModel() {

    private val selectedColor : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun getColor () : LiveData<String> {
        return selectedColor
    }

    fun setColor (color: String) {
        selectedColor.value = color
    }

}