package ru.stvvllrt.course_app.presentation.applist

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CatalogButton(onClick: () -> Unit){
    IconButton(
        onClick = onClick,
        modifier = Modifier.size(64.dp)
    ){
        Icon(
            imageVector = Icons.Outlined.Settings,
            contentDescription = "Settings",
            tint = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.size(32.dp)
        )
    }
}