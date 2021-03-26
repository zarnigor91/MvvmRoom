package uz.zn.taskalifteach.app.feature

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import uz.zn.taskalifteach.R
import uz.zn.taskalifteach.app.application.di.viewmodel.ProviderViewModelFactory
import uz.zn.taskalifteach.databinding.FragmentDashboardRootBinding
import javax.inject.Inject

class MainRootFragment @Inject constructor(
    viewModelFactory: ProviderViewModelFactory
) : Fragment(R.layout.fragment_dashboard_root) {
    private val viewModel: MainRootViewModel by viewModels { viewModelFactory }
    private lateinit var binding : FragmentDashboardRootBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDashboardRootBinding.bind(view)
        val navController = Navigation.findNavController(requireActivity(), R.id.dashboard_nav_host_fragment)
        binding.bottomNavigationView.setupWithNavController(navController)
    }

}