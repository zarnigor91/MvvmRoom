package uz.zn.taskalifteach.app.application.di.module

import dagger.Module
import dagger.Provides
import uz.zn.taskalifteach.data.provider.RepositoryProvider
import uz.zn.taskalifteach.data.repository.TaskRepository
import javax.inject.Singleton

@Module(includes = [ApplicationDaggerModuleRepository.Provider::class])
object ApplicationDaggerModuleRepository {

    @Module
    object Provider {
        @JvmStatic
        @Provides
        @Singleton
        fun TaskRepository(
            repositoryProvider: RepositoryProvider
        ): TaskRepository = repositoryProvider.taskRepository

    }
}