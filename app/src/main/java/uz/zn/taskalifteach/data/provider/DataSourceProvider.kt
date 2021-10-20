package uz.zn.taskalifteach.data.provider

import android.content.Context
import uz.zn.taskalifteach.data.datasourse.provider.DatabaseProvider
import uz.zn.taskalifteach.data.datasourse.provider.DatabaseProviderImpl
import uz.zn.taskalifteach.data.network.RestProvider

interface DataSourceProvider {

    val restProvider: RestProvider

}