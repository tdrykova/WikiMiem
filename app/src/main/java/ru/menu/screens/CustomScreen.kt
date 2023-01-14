package ru.menu.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import kotlinx.coroutines.launch
import ru.menu.R
import ru.menu.navigation.NavRoute
import ru.menu.ui.theme.*

@Composable
fun CustomScreen(navController: NavController) {
        val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
        val scope = rememberCoroutineScope()

        var screenText by remember { mutableStateOf(NavRoute.Main.title) }
        fun changeScreenText(text: String) { screenText = text }

        Scaffold(
                topBar = {
                        TopAppBar(
                                title = {
                                        Text(text = "МИЭМ Wiki")
                                },
                                backgroundColor = Color.Black,
                                contentColor = Color.White,
                                elevation = 12.dp
                        )
                },
                scaffoldState = scaffoldState,
                floatingActionButton = { DrawerFAB(scope = scope, scaffoldState = scaffoldState) },
                drawerContent = {
                        Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController,
                                changeScreenText = ::changeScreenText)
                }
        ) {
                Text(text = screenText)
        }
}

@Composable
fun DrawerFAB(scope: CoroutineScope, scaffoldState: ScaffoldState) {
        Column(
                modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 40.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.Start
        ) {
                FloatingActionButton(
                        onClick = {
                                scope.launch {
                                        scaffoldState.drawerState.open()
                                }
                        },
                        backgroundColor = blueColor,
                        contentColor = Color.White
                ) {
                        Icon(
                                painterResource(id = R.drawable.ic_burger),
                                ""
                        )
                }
        }
}

@Composable
fun Drawer(scope: CoroutineScope, scaffoldState: ScaffoldState, navController: NavController, changeScreenText: (text: String) -> Unit) {
        var changeMenu by remember { mutableStateOf(false) }
        val itemsMainMenu = listOf(
                NavRoute.DigitalMIEM,
                NavRoute.ProjectActivities,
                NavRoute.DigestsMIEM,
                NavRoute.Administration,
                NavRoute.Departments,
                NavRoute.EducationalPrograms,
                NavRoute.Laboratories,
                NavRoute.ResourceCenters,
                NavRoute.Library,
                NavRoute.ProjectOffice,
                NavRoute.ProjectSchool,
                NavRoute.ProjectDocumentation,
                NavRoute.CourseMaterials,
                NavRoute.AdditionalMaterials,
                NavRoute.Tracks,
                NavRoute.StudentCouncilMIEM,
                NavRoute.Movement,
                NavRoute.PortfolioOfStudents,
                NavRoute.PortfolioOfEmployees,
                NavRoute.Statistics,
                NavRoute.Educational,
                NavRoute.Project,
                NavRoute.Other,
                NavRoute.OperatingInstructions
        )

        val itemsReview = listOf(
                NavRoute.Drafts,
                NavRoute.Groups,
                NavRoute.Digests,
                NavRoute.Documentation,
                NavRoute.People,
                NavRoute.DepartmentsReview,
                NavRoute.ProjectsReview,
                NavRoute.Studies,
                NavRoute.HomePage,
                NavRoute.Contacts
        )

        Column(
                modifier = Modifier
                        .background(color = darkBlue)
                        .fillMaxHeight()
                        .verticalScroll(rememberScrollState())
        ) {
                Row(
                        modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .background(brightBlue),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                ) {

                        Button(
                                onClick = {
                                        navController.navigate(NavRoute.Home.route)
                                        Log.d("@@@", "Home")
                                },
                                colors = ButtonDefaults.buttonColors(backgroundColor = backgroundBlue)
                        ) {
                                Image(
                                        painter = painterResource(id = R.drawable.ic_home),
                                        contentDescription = ""
                                )
                        }

                        Button(
                                onClick = {
                                        Log.d("MainActivity", "Change menu")
                                        changeMenu = !changeMenu
                                },
                                colors = ButtonDefaults.buttonColors(backgroundColor = backgroundBlue)
                        ) {
                                Row(
                                        modifier = Modifier
                                                .background(backgroundBlue),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.Center
                                ) {
                                        Image(
                                                painter = if (changeMenu)
                                                        painterResource(id = R.drawable.navigation)
                                                        else painterResource(id = R.drawable.review_tree),
                                                contentDescription = "",
                                                colorFilter = ColorFilter.tint(Color.White),
                                                modifier = Modifier
                                                        .padding(end = 10.dp)
                                        )
                                        Text(text = if (changeMenu) "Главное меню" else "Обзор", color = Color.White, textAlign = TextAlign.Center)
                                }
                        }
                }

                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                var itemText = ""

                if (changeMenu) {
                        itemsReview.forEach { item ->
                                DrawerItem(item = item, selected = currentRoute == item.route, onItemClick = {
                                        changeScreenText(item.title)
                                        scope.launch {
                                                scaffoldState.drawerState.close()
                                        }
                                })
                        }
                } else {
                        itemsMainMenu.forEach { item ->
                                itemText = when(item.title) {
                                        NavRoute.DigitalMIEM.title -> "Документация"
                                        NavRoute.Administration.title -> "Подразделения"
                                        NavRoute.ProjectOffice.title -> "Проекты"
                                        NavRoute.CourseMaterials.title -> "Учеба"
                                        NavRoute.StudentCouncilMIEM.title -> "Общественные организации"
                                        NavRoute.PortfolioOfStudents.title -> "Люди"
                                        NavRoute.Educational.title -> "Группы"
                                        NavRoute.OperatingInstructions.title -> "Помощь по Wiki"
                                        else -> ""
                                }

                                if (item.title == NavRoute.DigitalMIEM.title ||
                                        item.title == NavRoute.Administration.title ||
                                        item.title == NavRoute.ProjectOffice.title ||
                                        item.title == NavRoute.CourseMaterials.title ||
                                        item.title == NavRoute.StudentCouncilMIEM.title ||
                                        item.title == NavRoute.PortfolioOfStudents.title ||
                                        item.title == NavRoute.Educational.title ||
                                        item.title == NavRoute.OperatingInstructions.title
                                ) {
                                        Text(
                                                text = itemText,
                                                color = textGray,
                                                fontWeight = FontWeight.Bold,
                                                modifier = Modifier.padding(start = 10.dp, top = 15.dp, bottom = 5.dp)
                                        )
                                }

                                DrawerItem(item = item, selected = currentRoute == item.route, onItemClick = {
                                        changeScreenText(item.title)
                                        scope.launch {
                                                scaffoldState.drawerState.close()
                                        }

                                })
                                if (item.title == NavRoute.DigestsMIEM.title ||
                                        item.title == NavRoute.Library.title ||
                                        item.title == NavRoute.ProjectDocumentation.title ||
                                        item.title == NavRoute.Tracks.title ||
                                        item.title == NavRoute.Movement.title ||
                                        item.title == NavRoute.Statistics.title ||
                                        item.title == NavRoute.Other.title
                                ) {
                                        Divider(
                                                color = textGray,
                                                thickness = (0.5).dp,
                                                modifier = Modifier.padding(top = 10.dp)
                                        )
                                }

                        }
                }

        }
}

@Composable
fun DrawerItem(item: NavRoute, selected: Boolean, onItemClick: (NavRoute) -> Unit) {
        val background = if (selected) R.color.grey else android.R.color.transparent
        Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onItemClick(item) }
                        .height(45.dp)
                        .background(colorResource(id = background))
                        .padding(start = 10.dp)
        ) {
                item.icon?.let { painterResource(id = it) }?.let {
                        Image(
                                painter = it,
                                contentDescription = item.title,
                                colorFilter = ColorFilter.tint(Color.White),
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                        .height(24.dp)
                                        .width(24.dp)
                        )
                }
                Spacer(modifier = Modifier.width(7.dp))
                Text(
                        text = item.title,
                        fontSize = 16.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                )
        }
}
