package uz.zn.taskalifteach.app.feature.feature.alltask

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import uz.zn.taskalifteach.R
import uz.zn.taskalifteach.app.application.di.viewmodel.ProviderViewModelFactory
import uz.zn.taskalifteach.app.feature.GuideBookAdapter
import uz.zn.taskalifteach.app.feature.feature.MainRootNavController
import uz.zn.taskalifteach.data.model.Data
import uz.zn.taskalifteach.databinding.FragmentDashboardBinding

import javax.inject.Inject

class AllTaskFragment @Inject constructor(
    viewModelFactory: ProviderViewModelFactory
) : Fragment(R.layout.fragment_dashboard), GuideBookAdapter.ListenerAction {

    private val viewModel: AllTaskViewModel by viewModels { viewModelFactory }
    private lateinit var binding: FragmentDashboardBinding
    private lateinit var taskAdapter: GuideBookAdapter

    @Inject
    lateinit var routeController: MainRootNavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDashboardBinding.bind(view)
        taskAdapter = GuideBookAdapter(this)
        binding.rvBook.layoutManager =
            GridLayoutManager(requireContext(), 1, GridLayoutManager.VERTICAL, false)
        binding.rvBook.adapter  = taskAdapter
        observeAllTaskList()
        observeDeleteList()
        viewModel.getAllTaskList()
    }

    override fun onStart() {
        super.onStart()
        observeAllTaskList()
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

    override fun onUpdate(taskEntity: Data) {
        TODO("Not yet implemented")
    }

    override fun onDelete(taskEntity: Data) {
        TODO("Not yet implemented")
    }


}