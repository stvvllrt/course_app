package ru.stvvllrt.course_app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.stvvllrt.course_app.presentation.theme.Course_appTheme
import ru.stvvllrt.course_app.presentation.applist.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Course_appTheme {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally){
                    MainScreen()
                }
            }
        }
    }
}
