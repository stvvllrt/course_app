package ru.stvvllrt.course_app.presentation.applist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.stvvllrt.course_app.data.local.Data
import ru.stvvllrt.course_app.presentation.components.CustomSvgIcon

@Composable
fun AppHeader(onLogoClick: () -> Unit){
    Row(modifier = Modifier
        .background(color = MaterialTheme.colorScheme.primary)
        .fillMaxWidth()
        .height(80.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically){
        CustomSvgIcon(
            imageSrc = Data.RuStoreIcon,
            contentDescription = "RS Logo" ,
            modifier = Modifier
                .height(55.dp)
                .padding(10.dp)
                .clickable { onLogoClick() }
        )
        CatalogButton(onClick = {})
    }
}