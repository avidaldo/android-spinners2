package com.example.spinners2.autocompletar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.spinners2.databinding.FragmentAutocompletado2aBinding

class Ej02aAutocompFragment : Fragment() {
    private var _binding: FragmentAutocompletado2aBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAutocompletado2aBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /***********************************************************/

    // Array de las provincias
    val arrayProvincias = arrayOf(
        "A Coruña", "Almería", "Alicante", "León", "Lugo", "Ourense", "Palencia", "Pontevedra"
    )

    // Arrays de las localidades
    val arrayCorunha = arrayOf("Arteixo", "La Coruña", "Ferrol", "Betanzos")
    val arrayPontevedra = arrayOf("Vigo", "Baiona", "Cangas", "Moaña")
    val arrayLugo = arrayOf("Abadín", "Burela", "Foz", "Guitiriz")
    val arrayOurense = arrayOf("Allariz", "Barbadás", "Carballiño", "Verín")


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.actvProvincias
            .apply {
                setAdapter(
                    ArrayAdapter(
                        requireContext(), android.R.layout.simple_spinner_item, arrayProvincias
                    )
                )
            }
            .apply {
                threshold = 1
            }
            .apply {
                setOnItemClickListener { parent, view, position, id ->
                    onSelectProvincia(text.toString())
                }
            }

    }

    private fun onSelectProvincia(provinciaString: String) {
        cargarLocalidadesSpinner(
            when (provinciaString) {
                "A Coruña" -> arrayCorunha
                "Lugo" -> arrayLugo
                "Ourense" -> arrayOurense
                "Pontevedra" -> arrayPontevedra
                else -> null
            }
        )

    }


    fun cargarLocalidadesSpinner(array: Array<String>?) {
        array?.let {
            // Añadimos al Spinner de localidades el adaptador con el array de localidades recibido
            binding.spinnerLocalidades
                .apply {
                    adapter =
                        ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, it)
                }
                .apply {
                    onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {

                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View,
                                position: Int,
                                id: Long
                            ) = showSelection()

                            override fun onNothingSelected(parent: AdapterView<*>?) {}
                        }
                }

        } ?: showEmpty()

    }

    fun showSelection() {
        Toast.makeText(
            requireContext(), """ 
            Provincia: ${binding.actvProvincias.text}
            Localidad: ${binding.spinnerLocalidades.selectedItem}
            """.trimIndent(), Toast.LENGTH_SHORT
        ).show()
    }

    private fun showEmpty() =
        Toast.makeText(requireContext(), "Aún no se han definido localidades", Toast.LENGTH_SHORT)
            .show()

}