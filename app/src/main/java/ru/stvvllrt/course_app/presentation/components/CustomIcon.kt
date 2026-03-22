package ru.stvvllrt.course_app.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun CustomIcon(imageSrc: String?, modifier: Modifier = Modifier){
    AsyncImage(
        model = imageSrc,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(64.dp)
            .clip(RoundedCornerShape(12.dp))
    )
}
