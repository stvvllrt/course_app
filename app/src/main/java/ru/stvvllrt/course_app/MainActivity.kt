package ru.stvvllrt.course_app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.stvvllrt.course_app.ui.theme.Course_appTheme
import androidx.core.net.toUri

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Course_appTheme {
                Column(modifier = Modifier.fillMaxSize(),verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally){
                    MainScreen(
                        onSideButtonClick = { text ->
                            val intent = Intent(this@MainActivity, SideActivity::class.java)
                            intent.putExtra("text", text)
                            startActivity(intent)
                    },
                        onDialButtonClick = { text ->
                            val uri = "tel:$text".toUri()
                            val intent = Intent(Intent.ACTION_DIAL, uri)
                            startActivity(intent)
                        },
                        onShareButtonClick = { text ->
                            val intent = Intent(Intent.ACTION_SEND)
                            intent.type = "text/plain"
                            intent.putExtra(Intent.EXTRA_TEXT, text)
                            startActivity(Intent.createChooser(intent, "Поделиться через"))
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    onSideButtonClick: (String) -> Unit,
    onDialButtonClick: (String) -> Unit,
    onShareButtonClick: (String) -> Unit
) {
    val context = LocalContext.current
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(R.string.empty_input.toString()) },
        modifier = Modifier.fillMaxWidth()
    )
    Button(onClick = {
        if (text.isBlank()) {
            Toast.makeText(
                context,
                R.string.empty_error.toString(),
                Toast.LENGTH_SHORT
            ).show()
        } else {
            onSideButtonClick(text)
        }
    }) {
        Text(R.string.open_label_button.toString())
    }
    Button(onClick = {
        val number = text.trim()
        when {
            number.isEmpty() -> {
                Toast.makeText(
                    context,
                    R.string.empty_error.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
            !isValidPhone(number) -> {
                Toast.makeText(
                    context,
                    R.string.number_error.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
            else -> {
                onDialButtonClick(number)
            }
    }}) {
        Text(R.string.dial_label_button.toString())
    }
    Button(onClick = {
        if (text.isBlank()) {
            Toast.makeText(
                context,
                R.string.empty_error.toString(),
                Toast.LENGTH_SHORT
            ).show()
        } else {
            onShareButtonClick(text)
        }
    }) {
        Text(R.string.share_label_button.toString())
    }
}

fun isValidPhone(number: String): Boolean {
    val cleaned = number.trim()
    return cleaned.length in 5..20 &&
            Patterns.PHONE.matcher(cleaned).matches()
}