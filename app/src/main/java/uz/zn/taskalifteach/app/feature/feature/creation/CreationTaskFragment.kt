package uz.zn.taskalifteach.app.feature.feature.creation

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import uz.zn.taskalifteach.R
import uz.zn.taskalifteach.app.application.di.viewmodel.ProviderViewModelFactory
import uz.zn.taskalifteach.databinding.FragmentTaskCreationBinding
import java.util.*
import javax.inject.Inject

class CreationTaskFragment @Inject constructor(
    viewModelFactory: ProviderViewModelFactory
) : Fragment(R.layout.fragment_task_creation){

    private val viewModel: CreationTaskViewModel by viewModels { viewModelFactory }
    private lateinit var binding: FragmentTaskCreationBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTaskCreationBinding.bind(view)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        binding.tvDate.setOnClickListener {
            val dpd = DatePickerDialog(requireContext(), DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                   binding.tvDate.setText("" + dayOfMonth + " " + month + ", " + year)
            }, year, month, day)
            dpd.show()
        }

         observeCardList()
        binding.btAdd.setOnClickListener {
            viewModel.setNameTask(binding.etName.text.toString())
            viewModel.setDateTask(binding.tvDate.text.toString())
            if (binding.checkbox.isChecked)
            {
                viewModel.setStatusTask(true)
            }
            else{
                viewModel.setStatusTask(false)
            }

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