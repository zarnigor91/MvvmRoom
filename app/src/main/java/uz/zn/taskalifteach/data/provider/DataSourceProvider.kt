package uz.zn.taskalifteach.data.provider

import android.content.Context
import uz.zn.taskalifteach.data.datasourse.provider.DatabaseProvider
import uz.zn.taskalifteach.data.datasourse.provider.DatabaseProviderImpl

internal class DataSourceProvider(
    private val context: Context
    ) {

    val dataBaseProvider : DatabaseProvider by lazy {
        DatabaseProviderImpl(context)
    }
}