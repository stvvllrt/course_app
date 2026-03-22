package ru.stvvllrt.course_app.presentation.applist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CathalogColumn(
    navController: NavController,
    apps: List<AppListEntry>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
            .background(color = MaterialTheme.colorScheme.surface)
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(apps) { app ->
            AppListRow(
                app = app,
                onClick = {
                    navController.navigate("details/${app.name}")
                }
            )
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 16.dp),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.outlineVariant
            )
        }
    }
}