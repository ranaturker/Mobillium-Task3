package com.ranaturker.task3.part1

import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    // Private bir değişken tanımlama
    private var counter = 0

    // "incrementCounter" fonksiyonu ile sayaç değerini arttırma
    fun incrementCounter() {
        counter++
    }

    // "getCounter" fonksiyonu ile sayaç değerini integer döndürme
    fun getCounter(): Int {
        return counter
    }
}

/* Sayaç değeri, ViewModel içinde saklanarak,
  verilerin kullanıcı arayüzüyle doğrudan bağlantısını sağlayarak,
  veri değişiklikleri durumunda otomatik olarak güncellenmesini sağlar.
 */
