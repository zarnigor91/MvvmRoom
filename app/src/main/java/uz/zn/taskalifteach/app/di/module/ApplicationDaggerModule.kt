package com.example.newtest.app.di.module


import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ApplicationDaggerModule {

    @Provides
    @Singleton
    fun provideNetProvider(): INetProvider {
        return NetProviderImpl()
    }

    @Provides
    @Singleton
    fun provideNetService(netProvider: INetProvider): INetService {
        return netProvider.netService
    }

    @Provides
    @Singleton
    fun provideNewsRepository(netService: INetService): INewsRepository {
        return  NewsRepositoryImpl(netService)
    }
}
