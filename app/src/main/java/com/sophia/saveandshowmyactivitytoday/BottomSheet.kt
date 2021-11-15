package com.sophia.saveandshowmyactivitytoday

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.sophia.saveandshowmyactivitytoday.adapter.CheckAdapter
import com.sophia.saveandshowmyactivitytoday.database.TodoDatabase
import com.sophia.saveandshowmyactivitytoday.database.getTodoDatabase
import com.sophia.saveandshowmyactivitytoday.databinding.LayoutBottomSheetBinding
import com.sophia.saveandshowmyactivitytoday.entity.Check
import com.sophia.saveandshowmyactivitytoday.viewmodel.TodoViewModel
import com.sophia.saveandshowmyactivitytoday.viewmodel.TodoViewModelFactory

class BottomSheet(private var adapter: CheckAdapter) : BottomSheetDialogFragment() {

    private var _binding: LayoutBottomSheetBinding? = null
    val binding: LayoutBottomSheetBinding
        get() = _binding!!

    private lateinit var db: TodoDatabase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LayoutBottomSheetBinding.inflate(inflater, container, false)
        db = getTodoDatabase(requireContext())
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerview()

    }

    private fun initRecyclerview() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }


    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        dialog.dismiss()
    }

}