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

class CounterFragment : Fragment() {
    private lateinit var counterTextView: TextView
    private lateinit var incrementButton: Button
    private lateinit var viewModelSwitch: Switch

    // Viewmodel bağlantısı
    private val viewModel: CounterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_counter, container, false)
        counterTextView = view.findViewById(R.id.counterTextView)
        incrementButton = view.findViewById(R.id.incrementButton)
        viewModelSwitch = view.findViewById(R.id.viewModelSwitch)

        // ViewModel ile LiveData'yı gözlemleyerek sayaç değerini güncelleyelim
        viewModel.counterLiveData.observe(viewLifecycleOwner) { count ->
            counterTextView.text = count.toString()
        }

        // Butona tıklama olayını ViewModel'a bağlayalım
        incrementButton.setOnClickListener {
            viewModel.incrementCounter()
        }

        // Switch'in değişikliklerini dinleyerek ViewModel ve UI Controller arasında geçiş yapalım
        viewModelSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // ViewModel tarafını aktifleştir
                viewModel.setCounter(viewModel.getCurrentCounterValue())
            } else {
                // UI Controller tarafını aktifleştir
                viewModel.setCounter(counterTextView.text.toString().toInt())
            }
        }

        return view
    }
}

