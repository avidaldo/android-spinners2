package com.example.spinners2.spinners

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import com.example.spinners2.R
import com.example.spinners2.databinding.FragmentSpinnerEj03Binding

class Ej04FromResourceFragment : Fragment() {
    private var _binding: FragmentSpinnerEj03Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSpinnerEj03Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /***********************************************************/


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Creando el adaptador desde un recurso
        binding.spinner3.adapter = ArrayAdapter.createFromResource(
            requireActivity(), R.array.planetas, android.R.layout.simple_spinner_dropdown_item
        )

        binding.spinner3.onItemSelectedListener = object: OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                binding.textViewElection.text = "Elección: ${parent.selectedItem}"
                binding.textViewId.text = "Id: $id"
                binding.textViewPosition.text = "Posición: $position"
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}

        }

    }

}