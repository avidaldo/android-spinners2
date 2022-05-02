package com.example.spinners2.autocompletar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.spinners2.R
import com.example.spinners2.databinding.FragmentAutocompletado1Binding

class Ej01AutocompFragment : Fragment() {
    private var _binding: FragmentAutocompletado1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAutocompletado1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /***********************************************************/


    private val arrayNombres = resources.getStringArray(R.array.nombres)
    private val listaNombres = listOf(*arrayNombres)
    /* El operador * (spread operador) convierte un array en varargs (múltiples argumentos)
    para funciones que reciben un número variable de argumentos.
    https://stackoverflow.com/questions/39389003/kotlin-asterisk-operator-before-variable-name-or-spread-operator-in-kotlin
     */


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter1 = ArrayAdapter( // Cargando desde el Array
            requireContext(), android.R.layout.select_dialog_item, arrayNombres
        )

        val adapter2 = ArrayAdapter( // Cargando desde la lista
            requireContext(), android.R.layout.select_dialog_item, listaNombres
        )

        // Si el array de elementos no se va a generar dinámicamente, tiene más sentido leerlo de un recurso
        val adapter3 = ArrayAdapter(
            requireContext(), android.R.layout.select_dialog_item, resources.getStringArray(R.array.nombres)
        )

        //, para lo cual, mejor, existe un método específico:
        val adapter = ArrayAdapter.createFromResource(
            requireContext(), R.array.nombres, android.R.layout.select_dialog_item
        )

        // Para definir el threshold programáticamente (normalmente se hace en el layout, como en este caso)
        // binding.actvProvincias.threshold = 2

        // Añadimos el Adaptador al autoCompleteTextView
        binding.actvProvincias.setAdapter(adapter)

        /* Listener sobre la elección de una de las opciones.
        En AutoCompleteTextView se utiliza OnItemClickListener, en Spinners OnItemSelectedListener */
        binding.actvProvincias.setOnItemClickListener { _, view, _, _ ->
            Toast.makeText(
                requireContext(),
                //"Has elegido el nombre ${binding.autoCompleteTextView.text}",
                "Has elegido el nombre ${(view as TextView).text}",
                Toast.LENGTH_LONG
            ).show()
        }


    }
}