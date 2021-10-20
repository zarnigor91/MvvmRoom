package uz.zn.taskalifteach.data.provider

import android.content.Context
import uz.zn.taskalifteach.data.datasourse.provider.DatabaseProvider
import uz.zn.taskalifteach.data.datasourse.provider.DatabaseProviderImpl

class DataProvider(context: Context) {

    private val dataSourceProvider by lazy {
        DataSourceProviderImpl(context)
    }

    private val databaseProvider by lazy {
        DatabaseProviderImpl(context = context)
    }


    val repositoryProvider: RepositoryProvider by lazy {
        RepositoryProviderImpl(
            taskDao = databaseProvider.taskDao,
            postApi = dataSourceProvider.restProvider.postApi
        )
    }

}