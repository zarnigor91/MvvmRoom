package uz.zn.taskalifteach.app.application.di.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import javax.inject.Inject
import javax.inject.Provider

class ProviderFragmentFactory @Inject constructor(
    private val providersMap: Map<Class<out Fragment>, @JvmSuppressWildcards Provider<Fragment>>
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        val fragmentClass: Class<out Fragment> = loadFragmentClass(classLoader, className)
        val provider: Provider<Fragment> =
            providersMap[fragmentClass] ?: return super.instantiate(classLoader, className)
        return provider.get()
    }
}