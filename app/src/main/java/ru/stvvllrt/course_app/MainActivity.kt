package ru.stvvllrt.course_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.stvvllrt.course_app.ui.theme.Course_appTheme
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.NavType

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

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "catalog") {
        composable("catalog") {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.primary),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppHeader()
                CathalogColumn(navController)
            }
        }

        composable(
            route = "details/{appName}",
            arguments = listOf(navArgument("appName") { type = NavType.StringType })
        ) { backStackEntry ->
            val appName = backStackEntry.arguments?.getString("appName")
            val app = Data.appList.find { it.name == appName }
            if (app != null) {
                AppDetailsContent(
                    content = app,
                    onBackClick = { navController.popBackStack() },
                    onShareClick = {},
                    onInstallClick = {},
                    onDeveloperClick = {},
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.surface)
                        .statusBarsPadding()
                )
            } else {
                Text("Приложение не найдено")
            }
        }
    }
}
@Composable
fun CathalogColumn(navController: androidx.navigation.NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart =28.dp, topEnd = 28.dp))
            .background(color = MaterialTheme.colorScheme.surface)
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(Data.appList) { app ->
            AppRowCard(
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
@Composable
fun AppHeader(){
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
                .padding(10.dp),
        )
        CathalogButton(onClick = {})
        }
    }

@Composable
fun CathalogButton(onClick: () -> Unit){
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

@Composable
fun AppRowCard(app: Data.Apps? = null, onClick: () -> Unit = {}) {
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

@Composable
fun CustomSvgIcon(
    modifier: Modifier = Modifier,
    imageSrc: String,
    contentDescription: String? = null
) {
    val context = LocalContext.current
    AsyncImage(
        model = ImageRequest.Builder(context)
            .data(imageSrc)
            .decoderFactory(SvgDecoder.Factory())
            .build(),
        contentDescription = contentDescription,
        modifier = modifier,
        contentScale = ContentScale.Fit
        )
}

@Preview
@Composable
fun MainScreenPreview(){
    Course_appTheme {
        MainScreen()
    }
}
