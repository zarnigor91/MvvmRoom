package uz.zn.taskalifteach.app.feature.feature.alltask

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.alifteachtask.data.model.TaskEntity
import uz.zn.taskalifteach.R
import uz.zn.taskalifteach.app.application.di.viewmodel.ProviderViewModelFactory
import uz.zn.taskalifteach.app.feature.TaskAdapter
import uz.zn.taskalifteach.app.feature.feature.MainRootNavController
import uz.zn.taskalifteach.databinding.FragmentAllTaskBinding
import javax.inject.Inject

class AllTaskFragment @Inject constructor(
    viewModelFactory: ProviderViewModelFactory
) : Fragment(R.layout.fragment_all_task), TaskAdapter.ListenerAction {

    private val viewModel: AllTaskViewModel by viewModels { viewModelFactory }
    private lateinit var binding: FragmentAllTaskBinding
    private lateinit var taskAdapter: TaskAdapter

    @Inject
    lateinit var routeController: MainRootNavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAllTaskBinding.bind(view)



        taskAdapter = TaskAdapter(this)
        binding.recyclerView.adapter = taskAdapter
        observeAllTaskList()
        observeDeleteList()
        viewModel.getAllTaskList()
    }

    private fun observeAllTaskList() {
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

    override fun onUpdate(taskEntity: TaskEntity) {
        viewModel.openTaskEditFragment(taskEntity)
        Toast.makeText(requireContext(), "UpdateTaskFragment",  Toast.LENGTH_SHORT).show()
    }

    override fun onDelete(taskEntity: TaskEntity) {
       viewModel.deleteTask(taskEntity)
    }

    private fun observeDeleteList() {
        viewModel.taskAllLiveData.observe(viewLifecycleOwner) { resource ->
            Log.d("card", "" + resource)
            when (resource) {
                AllTaskResource.Loading -> {
                }
                is AllTaskResource.Success -> {
                    Toast.makeText(requireContext(), "delete from db", Toast.LENGTH_SHORT).show()
                }
                is AllTaskResource.Failure -> {
                }
            }
        }
    }


}