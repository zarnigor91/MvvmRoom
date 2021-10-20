package uz.zn.taskalifteach.app.application.di.module

import dagger.Module
import dagger.Provides
import uz.zn.taskalifteach.data.provider.RepositoryProvider
import uz.zn.taskalifteach.data.repository.TaskRepository
import uz.zn.taskalifteach.data.repository.source.BookRepository
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

        @JvmStatic
        @Provides
        @Singleton
        fun bookRepository(
            repositoryProvider: RepositoryProvider
        ): BookRepository = repositoryProvider.bookRepository

    }
}