package ru.menu

import android.graphics.Color.blue
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColor
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import ru.menu.ui.theme.MenuTheme
val blueColor = Color(0xFF1976D2)
val darkBlue = Color(0xFF2F4256)
val brightBlue = Color(0xFF1565C0)
val backgroundBlue = Color(0xFF1976d2)
val textGray = Color(0xFFCAC5C5)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
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
            contentColor = Color.White) {
            Icon(
                painterResource(id = R.drawable.ic_burger),
                ""
            )
        }
    }
}

@Composable
fun MainScreen() {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()

    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButton = {DrawerFAB(scope = scope, scaffoldState = scaffoldState)},
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        }
    ) {
        Navigation(navController = navController)
    }
}

@Composable
fun Drawer(scope: CoroutineScope, scaffoldState: ScaffoldState, navController: NavController) {
    val items = listOf(
        NavigationItem.DigitalMIEM,
        NavigationItem.ProjectActivities,
        NavigationItem.DigestsMIEM,
        NavigationItem.Administration,
        NavigationItem.Departments,
        NavigationItem.EducationalPrograms,
        NavigationItem.Laboratories,
        NavigationItem.ResourceCenters,
        NavigationItem.Library,
        NavigationItem.ProjectOffice,
        NavigationItem.ProjectSchool,
        NavigationItem.ProjectDocumentation,
        NavigationItem.CourseMaterials,
        NavigationItem.AdditionalMaterials,
        NavigationItem.Tracks,
        NavigationItem.StudentCouncilMIEM,
        NavigationItem.Movement,
        NavigationItem.PortfolioOfStudents,
        NavigationItem.PortfolioOfEmployees,
        NavigationItem.Statistics,
        NavigationItem.Educational,
        NavigationItem.Project,
        NavigationItem.Other,
        NavigationItem.OperatingInstructions
    )
    
    Column(
        modifier = Modifier
            .background(color = darkBlue)
            .width(320.dp)
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

            Button(onClick = {
                Log.d("MainActivity", "Home")
                /* TODO */
            },
                colors = ButtonDefaults.buttonColors(backgroundColor = backgroundBlue)
            ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_home),
                        contentDescription = ""
                    )
                }

            Button(onClick = {
                Log.d("MainActivity", "Обзор")
                /* TODO */
            },
                colors = ButtonDefaults.buttonColors(backgroundColor = backgroundBlue)
            ) {
                Row(modifier = Modifier
                    .background(backgroundBlue),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.review_tree),
                        contentDescription = "",
                        colorFilter = ColorFilter.tint(Color.White),
                        modifier = Modifier
                            .padding(end = 10.dp)
                    )
                    Text(text = "Обзор", color = Color.White, textAlign = TextAlign.Center)
                }
            }
        }

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEachIndexed { index, item ->
            if (item.title == NavigationItem.DigitalMIEM.title) {
                Text(text = "Документация", color = textGray, fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 10.dp, top = 15.dp, bottom = 5.dp))
            }
            if (item.title == NavigationItem.Administration.title) {
                Text(text = "Подразделения", color = textGray, fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 10.dp, top = 15.dp, bottom = 5.dp))
            }
            if (item.title == NavigationItem.ProjectOffice.title) {
                Text(text = "Проекты", color = textGray, fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 10.dp, top = 15.dp, bottom = 5.dp))
            }
            if (item.title == NavigationItem.CourseMaterials.title) {
                Text(text = "Учеба", color = textGray, fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 10.dp, top = 15.dp, bottom = 5.dp))
            }
            if (item.title == NavigationItem.StudentCouncilMIEM.title) {
                Text(text = "Общественные организации", color = textGray, fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 10.dp, top = 15.dp, bottom = 5.dp))
            }
            if (item.title == NavigationItem.PortfolioOfStudents.title) {
                Text(text = "Люди", color = textGray, fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 10.dp, top = 15.dp, bottom = 5.dp))
            }
            if (item.title == NavigationItem.Educational.title) {
                Text(text = "Группы", color = textGray, fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 10.dp, top = 15.dp, bottom = 5.dp))
            }
            if (item.title == NavigationItem.OperatingInstructions.title) {
                Text(text = "Помощь по Wiki", color = textGray, fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 10.dp, top = 15.dp, bottom = 5.dp))
            }
            DrawerItem(item = item, selected = currentRoute == item.route, onItemClick = {
                navController.navigate(item.route) {
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
                scope.launch {
                    scaffoldState.drawerState.close()
                }

            })
            if (item.title == NavigationItem.DigestsMIEM.title ||
                item.title == NavigationItem.Library.title ||
                item.title == NavigationItem.ProjectDocumentation.title ||
                item.title == NavigationItem.Tracks.title ||
                item.title == NavigationItem.Movement.title ||
                item.title == NavigationItem.Statistics.title ||
                item.title == NavigationItem.Other.title){
                Divider(color = textGray, thickness = (0.5).dp, modifier = Modifier.padding(top = 10.dp))
            }

        }
    }
}

@Composable
fun DrawerItem(item: NavigationItem, selected: Boolean, onItemClick: (NavigationItem) -> Unit) {
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
        Image(
            painter = painterResource(id = item.icon),
            contentDescription = item.title,
            colorFilter = ColorFilter.tint(Color.White),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(24.dp)
                .width(24.dp)
        )
        Spacer(modifier = Modifier.width(7.dp))
        Text(
            text = item.title,
            fontSize = 16.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Home Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ReviewScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Review Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun DigitalMIEMScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "DigitalMIEM Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ProjectActivitiesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "ProjectActivities Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun DigestsMIEMScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "DigestsMIEM Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun AdministrationScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Administration Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun DepartmentsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Departments Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun EducationalProgramsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "EducationalPrograms Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun LaboratoriesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Laboratories Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ResourceCentersScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "ResourceCenters Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun LibraryScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Library Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ProjectOfficeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "ProjectOffice Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ProjectSchoolScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "ProjectSchool Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ProjectDocumentationScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "ProjectDocumentation Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun CourseMaterialsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "CourseMaterials Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun AdditionalMaterialsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "AdditionalMaterials Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun TracksScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Tracks Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun StudentCouncilMIEMScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "StudentCouncilMIEM Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun MovementScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Movement Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun PortfolioOfStudentsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "PortfolioOfStudents Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun PortfolioOfEmployeesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "PortfolioOfEmployees Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun StatisticsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Statistics Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun EducationalScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Educational Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ProjectScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Project Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun OtherScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Other Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun OperatingInstructionsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "OperatingInstructions Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {

        composable(NavigationItem.Home.route) {
            HomeScreen()
        }
        composable(NavigationItem.Review.route) {
            ReviewScreen()
        }

        composable(NavigationItem.DigitalMIEM.route) {
            DigitalMIEMScreen()
        }
        composable(NavigationItem.ProjectActivities.route) {
            ProjectActivitiesScreen()
        }
        composable(NavigationItem.DigestsMIEM.route) {
            DigestsMIEMScreen()
        }

        composable(NavigationItem.Administration.route) {
            AdministrationScreen()
        }
        composable(NavigationItem.Departments.route) {
            DepartmentsScreen()
        }
        composable(NavigationItem.EducationalPrograms.route) {
            EducationalProgramsScreen()
        }
        composable(NavigationItem.Laboratories.route) {
            LaboratoriesScreen()
        }
        composable(NavigationItem.ResourceCenters.route) {
            ResourceCentersScreen()
        }
        composable(NavigationItem.Library.route) {
            LibraryScreen()
        }

        composable(NavigationItem.ProjectOffice.route) {
            ProjectOfficeScreen()
        }
        composable(NavigationItem.ProjectSchool.route) {
            ProjectSchoolScreen()
        }
        composable(NavigationItem.ProjectDocumentation.route) {
            ProjectDocumentationScreen()
        }

        composable(NavigationItem.CourseMaterials.route) {
            CourseMaterialsScreen()
        }
        composable(NavigationItem.AdditionalMaterials.route) {
            AdditionalMaterialsScreen()
        }
        composable(NavigationItem.Tracks.route) {
            TracksScreen()
        }

        composable(NavigationItem.StudentCouncilMIEM.route) {
            StudentCouncilMIEMScreen()
        }
        composable(NavigationItem.Movement.route) {
            MovementScreen()
        }

        composable(NavigationItem.PortfolioOfStudents.route) {
            PortfolioOfStudentsScreen()
        }
        composable(NavigationItem.PortfolioOfEmployees.route) {
            PortfolioOfEmployeesScreen()
        }
        composable(NavigationItem.Statistics.route) {
            StatisticsScreen()
        }

        composable(NavigationItem.Educational.route) {
            EducationalScreen()
        }
        composable(NavigationItem.Project.route) {
            ProjectScreen()
        }
        composable(NavigationItem.Other.route) {
            OtherScreen()
        }

        composable(NavigationItem.OperatingInstructions.route) {
            OperatingInstructionsScreen()
        }
    }
}