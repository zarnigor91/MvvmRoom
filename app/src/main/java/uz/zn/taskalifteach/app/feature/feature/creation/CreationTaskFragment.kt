package uz.zn.taskalifteach.app.feature.feature.creation

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import uz.zn.taskalifteach.R
import uz.zn.taskalifteach.app.application.di.viewmodel.ProviderViewModelFactory
import uz.zn.taskalifteach.databinding.FragmentTaskCreationBinding
import javax.inject.Inject

class CreationTaskFragment @Inject constructor(
    viewModelFactory: ProviderViewModelFactory
) : Fragment(R.layout.fragment_task_creation){

    private val viewModel: CreationTaskViewModel by viewModels { viewModelFactory }
    private lateinit var binding: FragmentTaskCreationBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTaskCreationBinding.bind(view)


         observeCardList()
        binding.btAdd.setOnClickListener {
            viewModel.setNameTask(binding.etName.text.toString())
            viewModel.setDateTask(binding.etDate.text.toString())
            viewModel.setStatusTask(true)
            viewModel.insertTask()
        }

    }

    private fun observeCardList() {
        viewModel.addTaskLiveData.observe(viewLifecycleOwner) { resource ->
            Log.d("card", "" + resource)
            when (resource) {
             CreationTaskResource.Loading -> {
                }
                is CreationTaskResource.Success -> {
                        Toast.makeText(requireContext(), "add to database", Toast.LENGTH_SHORT).show()
                }
                is CreationTaskResource.Failure -> {
                }
            }
        }
    }
}