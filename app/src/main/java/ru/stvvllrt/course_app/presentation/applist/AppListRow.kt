package ru.stvvllrt.course_app.presentation.applist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.stvvllrt.course_app.presentation.components.CustomIcon

@Composable
fun AppListRow(app: AppListEntry, onClick: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 12.dp, horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CustomIcon(app?.icon)
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 10.dp)
                .height(64.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = app?.name ?: "", style = MaterialTheme.typography.titleMedium)
            Text(text = app?.description ?: "", style = MaterialTheme.typography.bodyMedium, maxLines = 1)
            Text(text = app?.category ?: "", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.secondary)
        }
    }
}