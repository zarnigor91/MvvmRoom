package uz.zn.taskalifteach.data.provider

import android.content.Context
import uz.zn.taskalifteach.data.datasourse.provider.DatabaseProvider

class DataProvider(context: Context) {
    private val dataSourceProvider by lazy {
        DataSourceProvider(context = context)
    }

    val repositoryProvider: RepositoryProvider by lazy {
        val databaseProvider: DatabaseProvider =
            dataSourceProvider.dataBaseProvider

        return@lazy RepositoryProviderImpl(
            taskDao = databaseProvider.taskDao
        )
    }
}