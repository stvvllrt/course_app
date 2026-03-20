package ru.stvvllrt.course_app.presentation.applist

import ru.stvvllrt.course_app.domain.applist.AppList

class AppListDomainToUiMapper {
    fun map(domain: AppList): AppListEntry {
        return AppListEntry(
            name = domain.name,
            icon = domain.icon,
            category = domain.category,
            description = domain.description
        )
    }
}

