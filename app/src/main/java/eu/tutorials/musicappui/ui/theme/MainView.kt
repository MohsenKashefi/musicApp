package eu.tutorials.musicappui.ui.theme

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import eu.tutorials.musicappui.MainViewModel
import eu.tutorials.musicappui.R
import eu.tutorials.musicappui.Screen
import eu.tutorials.musicappui.screensInBottom
import eu.tutorials.musicappui.screensInDrawer
import eu.tutorials.musicappui.ui.theme.AccountDialog
import eu.tutorials.musicappui.ui.theme.AccountView
import eu.tutorials.musicappui.ui.theme.Browse
import eu.tutorials.musicappui.ui.theme.Home
import eu.tutorials.musicappui.ui.theme.Library
import eu.tutorials.musicappui.ui.theme.Subscription
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(){
    val viewModel: MainViewModel = viewModel()
    val controller: NavController = rememberNavController()
    val navBackStackEntry by controller.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val dialogOpen = remember{ mutableStateOf(false) }
    val currentScreen = remember{ viewModel.currentScreen.value }
    val title = remember{ mutableStateOf(currentScreen.title) }

    val bottomBar: @Composable () -> Unit = {
        if(currentScreen is Screen.DrawerScreen || currentScreen == Screen.BottomScreen.Home){
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.surface,
                tonalElevation = 8.dp
            ) {
                screensInBottom.forEach{ item ->
                    val isSelected = currentRoute == item.bRoute
                    NavigationBarItem(
                        selected = isSelected,
                        onClick = { 
                            controller.navigate(item.bRoute)
                            title.value = item.bTitle
                        },
                        icon = {
                            Icon(
                                painter = painterResource(id = item.icon),
                                contentDescription = item.bTitle,
                                tint = if(isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        },
                        label = { 
                            Text(
                                text = item.bTitle,
                                color = if(isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    )
                }
            }
        }
    }

    Scaffold(
        bottomBar = bottomBar,
        topBar = {
            TopAppBar(
                title = { 
                    Text(
                        text = title.value,
                        style = MaterialTheme.typography.headlineSmall
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface
                ),
                actions = {
                    IconButton(onClick = { /* TODO: Add search functionality */ }) {
                        Icon(
                            imageVector = Icons.Default.Search, 
                            contentDescription = "Search",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    IconButton(onClick = { /* TODO: Add more options */ }) {
                        Icon(
                            imageVector = Icons.Default.MoreVert, 
                            contentDescription = "More options",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                },
                navigationIcon = { 
                    IconButton(onClick = { /* TODO: Add profile menu */ }) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle, 
                            contentDescription = "Profile",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Navigation(navController = controller, pd = paddingValues)
        AccountDialog(dialogOpen = dialogOpen)
    }
}

@Composable
fun DrawerItem(
    selected: Boolean,
    item: Screen.DrawerScreen,
    onDrawerItemClicked : () -> Unit
){
    val backgroundColor = if (selected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surface
    val contentColor = if (selected) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurface
    
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 16.dp)
            .background(
                backgroundColor,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { onDrawerItemClicked() }
            .padding(16.dp)
    ) {
        Icon(
            painter = painterResource(id = item.icon),
            contentDescription = item.dTitle,
            tint = contentColor,
            modifier = Modifier.padding(end = 16.dp)
        )
        Text(
            text = item.dTitle,
            style = MaterialTheme.typography.bodyLarge,
            color = contentColor
        )
    }
}

@Composable
fun MoreBottomSheet(modifier: Modifier){
    Box(
        Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(MaterialTheme.colorScheme.surface)
    ){
        Column(
            modifier = modifier.padding(16.dp), 
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Row(
                modifier = modifier.padding(16.dp),
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
            ){
                Icon(
                    modifier = Modifier.padding(end = 16.dp),
                    painter = painterResource(id = R.drawable.baseline_settings_24),
                    contentDescription = "Settings",
                    tint = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "Settings", 
                    fontSize = 20.sp, 
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            Row(
                modifier = modifier.padding(16.dp),
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.padding(end = 16.dp),
                    painter = painterResource(id = R.drawable.ic_baseline_share_24),
                    contentDescription = "Share",
                    tint = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "Share",
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            Row(
                modifier = modifier.padding(16.dp),
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.padding(end = 16.dp),
                    painter = painterResource(id = R.drawable.ic_help_green),
                    contentDescription = "Help",
                    tint = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "Help", 
                    fontSize = 20.sp, 
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

@Composable
fun Navigation(navController: NavController, pd:PaddingValues){
    NavHost(
        navController = navController as NavHostController,
        startDestination = Screen.DrawerScreen.Account.route, 
        modifier = Modifier.padding(pd)
    ){
        composable(Screen.BottomScreen.Home.bRoute){
            Home()
        }
        composable(Screen.BottomScreen.Browse.bRoute){
            Browse()
        }
        composable(Screen.BottomScreen.Library.bRoute){
            Library()
        }
        composable(Screen.DrawerScreen.Account.route){
            AccountView()
        }
        composable(Screen.DrawerScreen.Subscription.route){
            Subscription()
        }
    }
}