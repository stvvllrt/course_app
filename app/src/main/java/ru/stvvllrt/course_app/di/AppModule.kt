package ru.stvvllrt.course_app.di

import android.app.Application
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.stvvllrt.course_app.data.appdetails.AppDetailsRepositoryImpl
import ru.stvvllrt.course_app.data.appdetails.local.AppDatabase
import ru.stvvllrt.course_app.data.appdetails.local.AppDetailsDao
import ru.stvvllrt.course_app.data.applist.AppListRepositoryImpl
import ru.stvvllrt.course_app.domain.appdetails.AppDetailsRepository
import ru.stvvllrt.course_app.domain.applist.AppListRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindAppDetailsRepository(
        impl: AppDetailsRepositoryImpl
    ): AppDetailsRepository

    @Binds
    @Singleton
    abstract fun bindAppListRepository(
        impl: AppListRepositoryImpl
    ): AppListRepository

    companion object {
        @Provides
        @Singleton
        fun provideDatabase(app: Application): AppDatabase {
            return Room.databaseBuilder(
                app,
                AppDatabase::class.java,
                AppDatabase.DATABASE_NAME
            ).build()
        }

        @Provides
        @Singleton
        fun provideAppDetailsDao(database: AppDatabase): AppDetailsDao {
            return database.appDetailsDao()
        }
    }
}