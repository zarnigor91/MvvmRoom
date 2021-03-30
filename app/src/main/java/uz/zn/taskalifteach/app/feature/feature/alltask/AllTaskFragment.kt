package uz.zn.taskalifteach.app.feature.feature.alltask

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import uz.zn.taskalifteach.R
import uz.zn.taskalifteach.app.application.di.viewmodel.ProviderViewModelFactory
import uz.zn.taskalifteach.app.feature.TaskAdapter
import uz.zn.taskalifteach.databinding.FragmentAllTaskBinding
import javax.inject.Inject

class AllTaskFragment @Inject constructor(
    viewModelFactory: ProviderViewModelFactory
) : Fragment(R.layout.fragment_all_task) {

    private val viewModel: AllTaskViewModel by viewModels { viewModelFactory }
    private lateinit var binding: FragmentAllTaskBinding
    private lateinit var taskAdapter: TaskAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAllTaskBinding.bind(view)

        taskAdapter = TaskAdapter(requireContext())
        binding.recyclerView.adapter = taskAdapter
        observeCardList()
        viewModel.getAllTaskList()
    }

    private fun observeCardList() {
        viewModel.taskAllLiveData.observe(viewLifecycleOwner) { resource ->
            Log.d("card", "" + resource)
            when (resource) {
                AllTaskResource.Loading -> {
                }
                is AllTaskResource.Success -> {
                    taskAdapter.updateTask(resource.values)
                }
                is AllTaskResource.Failure -> {
                }
            }
        }
    }


}