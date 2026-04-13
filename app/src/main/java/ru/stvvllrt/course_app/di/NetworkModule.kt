package ru.stvvllrt.course_app.di


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import ru.stvvllrt.course_app.data.applist.AppListApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideAppListApi(): AppListApi {
        return Retrofit.Builder()
            .baseUrl("http://185.103.109.134/") // Ваш базовый URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AppListApi::class.java)
    }
}