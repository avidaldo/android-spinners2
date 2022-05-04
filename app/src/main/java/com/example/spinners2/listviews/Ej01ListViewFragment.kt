package com.example.spinners2.listviews

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.spinners2.R
import com.example.spinners2.databinding.FragmentListviewEj01Binding

class Ej01ListViewFragment : Fragment() {
    private var _binding: FragmentListviewEj01Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListviewEj01Binding.inflate(inflater, container, false)
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
        val adapter = ArrayAdapter.createFromResource(
            requireContext(), R.array.planetas, R.layout.item_guay
        ).apply { setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) }

        binding.lista01
            .apply { this.adapter = adapter }
            .apply {
                setOnItemClickListener { _, view, _, _ ->
                    showNotification("Click en ${(view as TextView).text}")
                }
            }
            .apply {
                setOnItemLongClickListener { parent, view, position, id ->
                    showNotification(
                        """OnItemSelectedListener:
                            ${parent.selectedItem}
                            ${parent.getItemAtPosition(position)}
                            ${(view as TextView).text}
                            position = $position
                            id = $id
                            """.trimIndent()
                    )
                    true
                }
            }
    }

    private fun showNotification(mensaje: String) {
        AlertDialog.Builder(requireContext()).setMessage(mensaje).setTitle(R.string.dialog_title)
            .create().show()
    }

}