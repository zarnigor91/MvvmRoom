package uz.zn.taskalifteach.app.feature

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import uz.zn.taskalifteach.R
import uz.zn.taskalifteach.app.application.di.viewmodel.ProviderViewModelFactory
import uz.zn.taskalifteach.databinding.FragmentMainRootBinding
import javax.inject.Inject

class MainRootFragment @Inject constructor(
    viewModelFactory: ProviderViewModelFactory
) : Fragment(R.layout.fragment_main_root), Toolbar.OnMenuItemClickListener {

    private val viewModel: MainRootViewModel by viewModels { viewModelFactory }
    private lateinit var binding: FragmentMainRootBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainRootBinding.bind(view)
        val navController =
            Navigation.findNavController(requireActivity(), R.id.dashboard_nav_host_fragment)
        binding.apply {
            bottomNavigationView.setupWithNavController(navController)
            toolbar.apply {
                inflateMenu(R.menu.menu_main_screen)
                setOnMenuItemClickListener(this@MainRootFragment)
            }
        }
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.action_add -> {
                // TODO: 3/30/21 add oynaga utish kerak
                true
            }
            else -> false
        }
    }
}