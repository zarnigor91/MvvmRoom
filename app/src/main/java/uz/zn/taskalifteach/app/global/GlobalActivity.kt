package uz.zn.taskalifteach.app.global

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.newtest.app.di.fragment.ProviderFragmentFactory
import com.example.newtest.app.di.viewmodel.ProviderViewModelFactory
import me.vponomarenko.injectionmanager.IHasComponent
import me.vponomarenko.injectionmanager.x.XInjectionManager
import uz.zn.taskalifteach.app.global.di.GlobalDaggerComponent
import javax.inject.Inject

class GlobalActivity : AppCompatActivity(), IHasComponent<GlobalDaggerComponent> {

    @Inject
    fun setFragmentFactory(fragmentFactory: ProviderFragmentFactory) {
        supportFragmentManager.fragmentFactory = fragmentFactory
    }

    @Inject lateinit var viewModelFactory: ProviderViewModelFactory

    private val globalViewModel: GlobalViewModel by viewModels { viewModelFactory }

    private val binding by lazy { ActivityGlobalBinding.inflate(layoutInflater) }

    override fun getComponent(): GlobalDaggerComponent =
        GlobalDaggerComponent.create(XInjectionManager.findComponent())

    override fun onCreate(savedInstanceState: Bundle?) {
        XInjectionManager.bindComponent(this).inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}