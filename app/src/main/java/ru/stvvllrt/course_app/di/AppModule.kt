
package ru.stvvllrt.course_app.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.stvvllrt.course_app.data.applist.AppListRepositoryImpl
import ru.stvvllrt.course_app.domain.applist.AppListRepository
import ru.stvvllrt.course_app.presentation.applist.AppListDomainToUiMapper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAppListRepository(
        impl: AppListRepositoryImpl
    ): AppListRepository
}

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    @Singleton
    fun provideAppListMapper(): AppListDomainToUiMapper {
        return AppListDomainToUiMapper()
    }
}