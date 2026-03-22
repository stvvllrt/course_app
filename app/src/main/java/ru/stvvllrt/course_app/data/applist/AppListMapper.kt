package ru.stvvllrt.course_app.data.applist

import ru.stvvllrt.course_app.domain.applist.AppList

class AppListMapper{
    fun toDomain(dto: AppListDto): AppList = AppList(
        name = dto.name,
        category = dto.category,
        icon = dto.icon,
        description = dto.description,
    )
}
