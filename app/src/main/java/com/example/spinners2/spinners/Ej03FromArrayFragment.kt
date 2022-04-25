package com.example.spinners2.spinners

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.spinners2.R
import com.example.spinners2.databinding.FragmentSpinnerEj03Binding

class Ej03FromArrayFragment : Fragment() {
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

        /* Partimos de un array. Lógicamente, en un caso real no tendría sentido definir un
         * array a base de literales hardcodeados. Sirve de ejemplo, pero este método para cargar
         * spinners solo tendría sentido si el array se carga en tiempo de ejecución */
        val arrayPlanets = arrayOf(
            "Mercurio", "Venus", "Tierra", "Marte", "Júpiter", "Saturno", "Urano", "Neptuno"
        )

        /* El ArrayAdapter la abstracción intermedia que relaciona el array con el listado de elementos
        * del spinner */
        val arrayAdapter = ArrayAdapter(
            requireActivity(),
            /* El segundo parámetro es el layout con el diseño del elemento cuando está seleccionado */
            //android.R.layout.simple_list_item_1,
            R.layout.item_guay,
            /* El último parámetro pasa el listado de los elemento a adaptar, en este caso en un array de Strings */
            arrayPlanets
        )

        // Asignación del layout de cada elemento cuando se despliega la lista
        arrayAdapter.setDropDownViewResource(
            //android.R.layout.simple_spinner_dropdown_item
            R.layout.chachi_spinner_item
        )

        // Utilizando un adaptador podemos cargar los elementos dinámicamente en el spinner
        binding.spinner3.adapter = arrayAdapter

        binding.spinner3.setSelection(0, false)

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
