package ru.stvvllrt.course_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.stvvllrt.course_app.ui.theme.Course_appTheme

class SideActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val text = intent.getStringExtra("text") ?: ""
        enableEdgeToEdge()
        setContent {
            Course_appTheme {
                Column(modifier = Modifier.fillMaxSize(),verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally){
                    SideScreen(text)
                }
            }
        }
    }
}

@Composable
fun SideScreen(text: String){
    Text(R.string.second_activity.toString())
    Text(text="Ваш текст: $text")
}
