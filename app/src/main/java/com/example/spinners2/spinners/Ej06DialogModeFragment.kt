package com.example.spinners2.spinners

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.spinners2.R
import com.example.spinners2.databinding.FragmentSpinnerEj06Binding
import java.util.ArrayList

class Ej06Fragment : Fragment() {
    private var _binding: FragmentSpinnerEj06Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSpinnerEj06Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /***********************************************************/


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        

        /** Spinner 1 *****************************/

        /* Selecciona el primer elemento antes de setear el escuchador, evitando que este salte en
        el momento en el que se carga de elementos */
        binding.spinner61.setSelection(0, false)

        /* Se le asigna al primer spinner el escuchador para cuando se seleciona uno de sus elementos.
		En este caso, se está definiendo el escuchador en otra clase */
        binding.spinner61.onItemSelectedListener = CustomOnItemSelectedListener()




        /** Spinner 2 *****************************/

        val arrayList: MutableList<String> = ArrayList()  // Añadimos items dinámicamente al segundo spinner
        arrayList.add("elemento 1")
        arrayList.add("elemento 2")
        arrayList.add("elemento 3")

        // El ArrayAdapter es el intermediario entre el arraylist y el AdapterView (el spinner)
        val arrayAdapter = ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1, arrayList )
        arrayAdapter.setDropDownViewResource(R.layout.item_guay)
        binding.spinner62.adapter = arrayAdapter

        /* Seteamos programáticamente un título para el spinner, que se mostrará
        ya que está definido en modo "dialog" */
        binding.spinner62.prompt = resources.getString(R.string.item_prompt)

        binding.spinner63.adapter = ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.array_paises,
            android.R.layout.simple_spinner_dropdown_item
        )

        binding.btnSubmit.setOnClickListener {
            Toast.makeText(
                requireActivity(),
                """OnClickListener : 
                Spinner 1 : ${binding.spinner61.selectedItem}
                Spinner 2 : ${binding.spinner61.selectedItem}
                """.trimIndent(),
                Toast.LENGTH_SHORT
            ).show()
        }


    }

    class CustomOnItemSelectedListener : AdapterView.OnItemSelectedListener {
        /**
         * Método de callback al que se invoca cuando se selecciona un elemento de un listado (el spinner1, en este caso)
         *
         * @param adapterView Vista que contiene los elementos, en este caso, el spinner.
         *                    (spinner es una de las clases que heredan de AdapterView: clases que utilizan adaptadores.
         *                    En general, se trata de views consistententes en listados de elementos)
         * @param view        Vista concreta del elemento (el elemento TextView que se pulsa dentro del spinner.
         * @param posicion    la posición del elemento en el adaptador
         * @param id          el id de la fila seleccionada
         */
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            Toast.makeText(
                parent?.context,
                """OnItemSelectedListener:
                ${parent?.getItemAtPosition(position)}
                ${(view as TextView).text}
                """.trimIndent(),  // Dos modos de hacer lo mismo
                Toast.LENGTH_SHORT
            ).show()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {}
    }

}