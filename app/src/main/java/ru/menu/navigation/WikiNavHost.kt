package ru.menu.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.menu.R
import ru.menu.screens.*

sealed class NavRoute(var route: String, var icon: Int?, var title: String) {
    object Welcome : NavRoute("welcome", null, "")
    object Main : NavRoute("main", null, "")

    object Home : NavRoute("home", R.drawable.ic_home, "")
    object Review : NavRoute("review", R.drawable.review_tree, "Обзор")

    object DigitalMIEM : NavRoute("digitalMIEM", R.drawable.digital_miem, "Цифровой МИЭМ")
    object ProjectActivities : NavRoute("projectActivities", R.drawable.project, "Проектная деятельность")
    object DigestsMIEM : NavRoute("digestsMIEM", R.drawable.digests, "Дайджесты МИЭМ")

    object Administration : NavRoute("administration", R.drawable.departments, "Администрация")
    object Departments : NavRoute("departments", R.drawable.departments, "Департаменты")
    object EducationalPrograms : NavRoute("educationalPrograms", R.drawable.materials, "Образовательные программы")
    object Laboratories : NavRoute("laboratories", R.drawable.labs, "Лаборатории")
    object ResourceCenters : NavRoute("resourceCenters", R.drawable.resourse_centers, "Ресурсные центры")
    object Library : NavRoute("library", R.drawable.library, "Библиотека")

    object ProjectOffice : NavRoute("projectOffice", R.drawable.project_office, "Проектный офис")
    object ProjectSchool : NavRoute("projectSchool", R.drawable.project_school, "Проектная школа")
    object ProjectDocumentation : NavRoute("projectDocumentation", R.drawable.documintation, "Документация проектов")

    object CourseMaterials : NavRoute("courseMaterials", R.drawable.materials, "Материалы курсов")
    object AdditionalMaterials : NavRoute("additionalMaterials", R.drawable.materials, "Дополнительные материалы")
    object Tracks : NavRoute("tracks", R.drawable.tracks, "Треки (специализации)")

    object StudentCouncilMIEM : NavRoute("studentCouncilMIEM", R.drawable.group, "Студенческий совет МИЭМ")
    object Movement : NavRoute("movement", R.drawable.group, "Movement")

    object PortfolioOfStudents : NavRoute("portfolioOfStudents", R.drawable.ic_home, "Портфолио студентов")
    object PortfolioOfEmployees : NavRoute("portfolioOfEmployees", R.drawable.ic_home, "Портфолио сотрудников")
    object Statistics : NavRoute("statistics", R.drawable.statistics, "Статистика")

    object Educational : NavRoute("educational", R.drawable.students, "Учебные")
    object Project : NavRoute("project", R.drawable.students, "Проектные")
    object Other : NavRoute("other", R.drawable.students, "Прочие")

    object OperatingInstructions : NavRoute("operatingInstructions", R.drawable.instructions, "Инструкции по работе")
}

@Composable
fun WikiNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoute.Welcome.route
    ) {
        composable(NavRoute.Welcome.route) { WelcomeScreen(navController = navController) }
        composable(NavRoute.Main.route) { MainScreen(navController = navController) }

        composable(NavRoute.Home.route) { HomeScreen(navController = navController)}
        composable(NavRoute.Review.route) { ReviewScreen(navController = navController)}

        composable(NavRoute.DigitalMIEM.route) { DigitalMIEMScreen(navController = navController)}
        composable(NavRoute.ProjectActivities.route) { ProjectActivitiesScreen(navController = navController)}
        composable(NavRoute.DigestsMIEM.route) { DigestsMIEMScreen(navController = navController)}

        composable(NavRoute.Administration.route) { AdministrationScreen(navController = navController)}
        composable(NavRoute.Departments.route) { DepartmentsScreen(navController = navController)}
        composable(NavRoute.EducationalPrograms.route) { EducationalProgramsScreen(navController = navController)}
        composable(NavRoute.Laboratories.route) { LaboratoriesScreen(navController = navController)}
        composable(NavRoute.ResourceCenters.route) { ResourceCentersScreen(navController = navController)}
        composable(NavRoute.Library.route) { LibraryScreen(navController = navController)}

        composable(NavRoute.ProjectOffice.route) { ProjectOfficeScreen(navController = navController)}
        composable(NavRoute.ProjectSchool.route) { ProjectSchoolScreen(navController = navController)}
        composable(NavRoute.ProjectDocumentation.route) { ProjectDocumentationScreen(navController = navController)}

        composable(NavRoute.CourseMaterials.route) { CourseMaterialsScreen(navController = navController)}
        composable(NavRoute.AdditionalMaterials.route) { AdditionalMaterialsScreen(navController = navController)}
        composable(NavRoute.Tracks.route) { TracksScreen(navController = navController)}

        composable(NavRoute.StudentCouncilMIEM.route) { StudentCouncilMIEMScreen(navController = navController)}
        composable(NavRoute.Movement.route) { MovementScreen(navController = navController)}

        composable(NavRoute.PortfolioOfStudents.route) { PortfolioOfStudentsScreen(navController = navController)}
        composable(NavRoute.PortfolioOfEmployees.route) { PortfolioOfEmployeesScreen(navController = navController)}
        composable(NavRoute.Statistics.route) { StatisticsScreen(navController = navController)}

        composable(NavRoute.Educational.route) { EducationalScreen(navController = navController)}
        composable(NavRoute.Project.route) { ProjectScreen(navController = navController)}
        composable(NavRoute.Other.route) { OtherScreen(navController = navController)}

        composable(NavRoute.OperatingInstructions.route) { OperatingInstructionsScreen(navController = navController)}
    }
}