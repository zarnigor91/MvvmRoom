package uz.zn.taskalifteach.app.feature.feature.edit

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import uz.zn.taskalifteach.R
import uz.zn.taskalifteach.app.application.di.viewmodel.ProviderViewModelFactory
import uz.zn.taskalifteach.app.feature.feature.creation.CreationTaskResource
import uz.zn.taskalifteach.app.feature.feature.creation.CreationTaskViewModel
import uz.zn.taskalifteach.databinding.FragmentEditTaskBinding
import uz.zn.taskalifteach.databinding.FragmentTaskCreationBinding
import javax.inject.Inject

class UpdateTaskFragment @Inject constructor(
    viewModelFactory: ProviderViewModelFactory
) : Fragment(R.layout.fragment_edit_task){

    private val viewModel: UpdateTaskViewModel by viewModels { viewModelFactory }
    private lateinit var binding: FragmentEditTaskBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEditTaskBinding.bind(view)

        observeCardList()
        binding.btUpdate.setOnClickListener {
            viewModel.setNameTask(binding.etName.text.toString())
            viewModel.setDateTask(binding.etDate.text.toString())
            viewModel.setStatusTask(true)
            viewModel.upDateTask(binding.etName.text.toString(),binding.etDate.text.toString(),true )
        }
    }

    private fun observeCardList() {
        viewModel.updateTaskLiveData.observe(viewLifecycleOwner) { resource ->
            Log.d("card", "" + resource)
            when (resource) {
               UpdateTaskResource.Loading -> {
                }
                is UpdateTaskResource.Success -> {
                    Toast.makeText(requireContext(), "update to db", Toast.LENGTH_SHORT).show()
                }
                is UpdateTaskResource.Failure -> {
                }
            }
        }
    }
}