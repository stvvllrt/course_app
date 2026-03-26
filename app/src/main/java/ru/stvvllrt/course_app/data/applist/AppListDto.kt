package ru.stvvllrt.course_app.data.applist
import com.google.gson.annotations.SerializedName

data class AppListDto(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("category") val category: String,
    @SerializedName("iconUrl") val icon: String
)