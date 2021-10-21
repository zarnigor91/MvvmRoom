package uz.zn.taskalifteach.app.feature.feature.completed

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import uz.zn.taskalifteach.R
import uz.zn.taskalifteach.app.application.di.viewmodel.ProviderViewModelFactory
import uz.zn.taskalifteach.app.feature.GuideBookAdapter
import uz.zn.taskalifteach.app.feature.feature.MainRootNavController
import uz.zn.taskalifteach.app.feature.feature.alltask.AllTaskResource
import uz.zn.taskalifteach.app.feature.feature.alltask.TaskDeleteResource
import uz.zn.taskalifteach.data.model.Data
import uz.zn.taskalifteach.databinding.FragmentAllTaskBinding
import javax.inject.Inject

class CompletedFragment @Inject constructor(
    viewModelFactory: ProviderViewModelFactory
) : Fragment(R.layout.fragment_all_task), GuideBookAdapter.ListenerAction {

    private val viewModel: CompletedViewModel by viewModels { viewModelFactory }
    private lateinit var binding: FragmentAllTaskBinding
    private lateinit var taskAdapter: GuideBookAdapter

    @Inject
    lateinit var routeController: MainRootNavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAllTaskBinding.bind(view)



        taskAdapter = GuideBookAdapter(this)
        binding.rvBook.adapter = taskAdapter
        observeAllTaskList()
        observeDeleteList()

    }

    private fun observeAllTaskList() {
        viewModel.completedTaskLiveData.observe(viewLifecycleOwner) { resource ->
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

    private fun observeDeleteList() {
        viewModel.deleteAllLiveData.observe(viewLifecycleOwner) { resource ->
            Log.d("card", "" + resource)
            when (resource) {
                TaskDeleteResource.Loading -> {
                }
                is TaskDeleteResource.Success -> {
                    Toast.makeText(requireContext(), "delete from db", Toast.LENGTH_SHORT).show()
                }
                is TaskDeleteResource.Failure -> {
                }
            }
        }
    }

    override fun onUpdate(taskEntity: Data) {
        TODO("Not yet implemented")
    }

    override fun onDelete(taskEntity: Data) {
        TODO("Not yet implemented")
    }


}