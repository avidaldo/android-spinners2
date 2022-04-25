package com.example.spinners2.spinners

import android.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.spinners2.databinding.FragmentSpinnerEj03Binding
import java.util.ArrayList

class Ej05FromArrayListFragment : Fragment() {
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

        val planetas: MutableList<String> = ArrayList()
        planetas.add("Mercurio")
        planetas.add("Venus")
        planetas.add("Tierra")
        planetas.add("Marte")
        planetas.add("Júpiter")
        planetas.add("Saturno")
        planetas.add("Urano")
        planetas.add("Neptuno")

        val adapter = ArrayAdapter(requireActivity(), R.layout.simple_spinner_item, planetas)

        binding.spinner3.adapter = adapter

        binding.spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>, view: View, position: Int, id: Long
            ) {
                binding.tvResultado.text = """OnItemSelectedListener:
                parent.selectedItem = ${parent.selectedItem}
                parent?.getItemAtPosition(position) = ${parent.getItemAtPosition(position)}
                (view as TextView).text = ${(view as TextView).text}
                position = $position
                id = $id
                """.trimIndent()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

    }

}