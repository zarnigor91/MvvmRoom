package uz.zn.taskalifteach.app.feature.feature.creation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import uz.zn.taskalifteach.R
import uz.zn.taskalifteach.app.application.di.viewmodel.ProviderViewModelFactory
import uz.zn.taskalifteach.app.feature.feature.alltask.AllTaskResource
import uz.zn.taskalifteach.app.feature.feature.alltask.AllTaskViewModel
import uz.zn.taskalifteach.databinding.FragmentAllTaskBinding
import uz.zn.taskalifteach.databinding.FragmentTaskCreationBinding
import javax.inject.Inject

class CreationFragment @Inject constructor(
    viewModelFactory: ProviderViewModelFactory
) : Fragment(R.layout.fragment_task_creation){

    private val viewModel: CreationViewModel by viewModels { viewModelFactory }
    private lateinit var binding: FragmentTaskCreationBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTaskCreationBinding.bind(view)


        viewModel.setNameTask(binding.etName.toString())
        viewModel.setDateTask(binding.etDate.toString())
        viewModel.setStatusTask(true)

    }

    private fun observeCardList() {
        viewModel.addTaskLiveData.observe(viewLifecycleOwner) { resource ->
            Log.d("card", "" + resource)
            when (resource) {
                AllTaskResource.Loading -> {
                }
                is AllTaskResource.Success -> {

                }
                is AllTaskResource.Failure -> {
                }
            }
        }
    }
}