package ru.stvvllrt.course_app.data.applist


import retrofit2.http.GET
import retrofit2.http.Path
import ru.stvvllrt.course_app.data.appdetails.AppDetailsDto

interface AppListApi {
    @GET("catalog")
    suspend fun getApps(): List<AppListDto>
    @GET("catalog/{id}")

    suspend fun getAppDetails(
        @Path("id") appId: String
    ): AppDetailsDto
}
