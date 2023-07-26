package com.ranaturker.task3.part1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ranaturker.task3.R
import com.ranaturker.task3.databinding.FragmentCounterBinding

class CounterFragment : Fragment() {

    // Sayaç değişkeni olan "counter" tanımlama
    private var counter = 0

    // ViewModel sınıfının nesnesi "viewModel"ı oluşturma
    private val viewModel: CounterViewModel by viewModels()

    // ViewBinding için değişken "binding" oluşturma
    private lateinit var binding: FragmentCounterBinding

    // Fragment oluşturulduğunda çağrılan onCreateView() fonksiyonu
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // ViewBinding kullanarak fragment_counter.xml layout'u ile bağlama
        binding = FragmentCounterBinding.inflate(layoutInflater)
        return binding.root
    }

    // Fragment oluşturulduğunda çağrılan onViewCreated() fonksiyonu
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notViewModel()
        // viewModelSwitch adlı switch bileşeninin durumunu dinleme
        binding.viewModelSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                // Switch açıldıysa, ViewModel kullanarak sayaç işlemlerini yapacak metodu çağırma
                useViewModel()
            } else {
                // Switch kapalıysa, ViewModel kullanmadan sayaç işlemlerini yapacak metodu çağırma
                notViewModel()
            }
        }
    }

    // ViewModel kullanarak sayaç işlemlerini yapacak metod
    fun useViewModel() = with(binding) {
        // ViewModel'den sayaç değerini alma
        counter = viewModel.getCounter()

        // TextView'e güncel sayaç değerini atama
        counterTextView.text = counter.toString()

        // Arttırma butonuna tıklandığında ViewModel ile sayaç değerini arttırma
        incrementButton.setOnClickListener {
            viewModel.incrementCounter()

            // Arttırılan yeni sayaç değerini alma ve TextView'e atama
            counter = viewModel.getCounter()
            counterTextView.text = counter.toString()
        }
    }

    // ViewModel kullanmadan sayaç işlemlerini yapacak metod.
    fun notViewModel() = with(binding) {
        // TextView'e mevcut sayaç değerini atama
        counterTextView.text = counter.toString()

        // Arttırma butonuna tıklandığında sayaç değerini arttırma
        incrementButton.setOnClickListener {
            ++counter

            // Yeni arttırılmış sayaç değerini TextView'e atama
            counterTextView.text = counter.toString()
        }
    }
}


