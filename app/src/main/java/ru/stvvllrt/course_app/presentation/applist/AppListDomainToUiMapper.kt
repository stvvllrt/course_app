package ru.stvvllrt.course_app.presentation.applist

import ru.stvvllrt.course_app.domain.applist.AppList
import javax.inject.Inject

class AppListDomainToUiMapper @Inject constructor(){
    fun map(domain: AppList): AppListEntry {
        return AppListEntry(
            id = domain.id,
            name = domain.name,
            icon = domain.icon,
            category = domain.category,
            description = domain.description
        )
    }
}

