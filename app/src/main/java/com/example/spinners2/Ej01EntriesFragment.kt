package com.example.spinners2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.spinners2.databinding.FragmentSpinnerEj01Binding

class Ej01EntriesFragment : Fragment() {
    private var _binding: FragmentSpinnerEj01Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSpinnerEj01Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /***********************************************************/


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSeleccion.setOnClickListener {
            binding.textViewElection.text = binding.spinner.selectedItem.toString()
            binding.textViewId.text = binding.spinner.selectedItemId.toString()
            binding.textViewPosition.text = binding.spinner.selectedItemPosition.toString()
        }
    }
}