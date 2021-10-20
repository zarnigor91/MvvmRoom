package uz.zn.taskalifteach.data.provider

import android.content.Context
import uz.zn.taskalifteach.data.network.RestProvider
import uz.zn.taskalifteach.data.network.RestProviderImpl



 class DataSourceProviderImpl(context: Context) : DataSourceProvider {

   override val restProvider: RestProvider by lazy {
        RestProviderImpl()
    }

}