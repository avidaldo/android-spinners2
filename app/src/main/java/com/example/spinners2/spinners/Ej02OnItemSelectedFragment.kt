package com.example.spinners2.spinners

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import com.example.spinners2.databinding.FragmentSpinnerEj02Binding

class Ej02OnItemSelectedFragment : Fragment() {
    private var _binding: FragmentSpinnerEj02Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSpinnerEj02Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /***********************************************************/


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* Selecciona el primer elemento antes de setear el escuchador, evitando que este salte en
        el momento en el que se carga de elementos */
        //binding.spinner2.setSelection(0,false)

        /* Seteamos un escuchador para el evento de cambio de evento seleccionado
        en el spinner. */
        binding.spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                binding.textViewElection.text = "Elección: ${(view as TextView).text}"
                //binding.textViewElection.text = "Elección: ${parent.selectedItem}"  // Otro modo de acceder
                binding.textViewId.text = "Id: $id"
                binding.textViewPosition.text = "Posición: $position"
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }


    }
}