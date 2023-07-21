package com.ranaturker.task3.part1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val _counterLiveData = MutableLiveData<Int>()
    val counterLiveData: LiveData<Int>
        get() = _counterLiveData

    // Değişkenimizi tutmak için bir alan oluşturalım
    private var counter = 0

    init {
        _counterLiveData.value = counter
    }

    fun incrementCounter() {
        counter++
        _counterLiveData.value = counter
    }

    fun setCounter(newValue: Int) {
        counter = newValue
        _counterLiveData.value = counter
    }

    fun getCurrentCounterValue(): Int {
        return counter
    }
}
