package com.example.spinners2.autocompletar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.example.spinners2.R
import com.example.spinners2.databinding.FragmentAutocompletado2bBinding


/** Igual que el anterior pero controlando la visibilidad del Spinner y cargando los listados
desde recursos */

class Ej02bAutocompFragment : Fragment() {
    private var _binding: FragmentAutocompletado2bBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAutocompletado2bBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /***********************************************************/


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.actvProvincias) {
            setAdapter(
                ArrayAdapter.createFromResource(
                    requireContext(), R.array.provincias_espana,
                    android.R.layout.simple_spinner_item
                )
            )
            setOnItemClickListener { parent, view, position, id ->
                onSelectProvincia(text)
                // Accedemos al text de actvProvincias para no tener que castear view ?
            }
            doOnTextChanged { text0, start, before, count ->
                onSelectProvincia(text0!!)  // TODO: nullable?
            }

        }

    }

    private fun onSelectProvincia(provinciaString: CharSequence) {
        cargarLocalidadesSpinner(
            when (provinciaString.toString()) {
                "A Coru??a" -> R.array.ciudades_corunha
                "Lugo" -> R.array.ciudades_lugo
                "Ourense" -> R.array.ciudades_ourense
                "Pontevedra" -> R.array.ciudades_pontevedra
                else -> null
            }
        )

    }


    fun cargarLocalidadesSpinner(recurso: Int?) {
        recurso?.let {
            // A??adimos al Spinner de localidades el adaptador con el array de localidades recibido
            binding.spinnerLocalidades
                .apply {
                    adapter = ArrayAdapter.createFromResource(
                        requireContext(),
                        it,
                        android.R.layout.simple_spinner_dropdown_item
                    )
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

            showSpinnerLocalidades()

        } ?: hideSpinnerLocalidades()

    }


    fun showSelection() {
        Toast.makeText(
            requireContext(), """ 
            Provincia: ${binding.actvProvincias.text}
            Localidad: ${binding.spinnerLocalidades.selectedItem}
            """.trimIndent(), Toast.LENGTH_SHORT
        ).show()
    }

    private fun showSpinnerLocalidades() {
        binding.tvCiudades.visibility = View.VISIBLE
        binding.spinnerLocalidades.visibility = View.VISIBLE
    }

    private fun hideSpinnerLocalidades() {
        binding.spinnerLocalidades.visibility = View.GONE
        binding.tvCiudades.visibility = View.GONE
    }

}