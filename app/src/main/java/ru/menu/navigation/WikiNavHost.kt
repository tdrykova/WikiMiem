package ru.menu.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.menu.R
import ru.menu.screens.*

sealed class NavRoute(var route: String, var icon: Int?, var title: String) {
    object Welcome : NavRoute("welcome", null, "")
    object Main : NavRoute("main", null, "Главная")

    object Home : NavRoute("home", R.drawable.ic_home, "Домашняя")
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

        composable(NavRoute.Main.route) { CustomScreen(navController = navController, text = NavRoute.Main.title) }

        composable(NavRoute.Home.route) { CustomScreen(navController = navController, text = NavRoute.Home.title)}
        composable(NavRoute.Review.route) { CustomScreen(navController = navController, text = NavRoute.Review.title)}

        composable(NavRoute.DigitalMIEM.route) { CustomScreen(navController = navController, text = NavRoute.DigitalMIEM.title)}
        composable(NavRoute.ProjectActivities.route) { CustomScreen(navController = navController, text = NavRoute.ProjectActivities.title)}
        composable(NavRoute.DigestsMIEM.route) { CustomScreen(navController = navController, text = NavRoute.DigestsMIEM.title)}

        composable(NavRoute.Administration.route) { CustomScreen(navController = navController, text = NavRoute.Administration.title)}
        composable(NavRoute.Departments.route) { CustomScreen(navController = navController, text = NavRoute.Departments.title)}
        composable(NavRoute.EducationalPrograms.route) { CustomScreen(navController = navController, text = NavRoute.EducationalPrograms.title)}
        composable(NavRoute.Laboratories.route) { CustomScreen(navController = navController, text = NavRoute.Laboratories.title)}
        composable(NavRoute.ResourceCenters.route) { CustomScreen(navController = navController, text = NavRoute.ResourceCenters.title)}
        composable(NavRoute.Library.route) { CustomScreen(navController = navController, text = NavRoute.Library.title)}

        composable(NavRoute.ProjectOffice.route) { CustomScreen(navController = navController, text = NavRoute.ProjectOffice.title)}
        composable(NavRoute.ProjectSchool.route) { CustomScreen(navController = navController, text = NavRoute.ProjectSchool.title)}
        composable(NavRoute.ProjectDocumentation.route) { CustomScreen(navController = navController, text = NavRoute.ProjectDocumentation.title)}

        composable(NavRoute.CourseMaterials.route) { CustomScreen(navController = navController, text = NavRoute.CourseMaterials.title)}
        composable(NavRoute.AdditionalMaterials.route) { CustomScreen(navController = navController, text = NavRoute.AdditionalMaterials.title)}
        composable(NavRoute.Tracks.route) { CustomScreen(navController = navController, text = NavRoute.Tracks.title)}

        composable(NavRoute.StudentCouncilMIEM.route) { CustomScreen(navController = navController, text = NavRoute.StudentCouncilMIEM.title)}
        composable(NavRoute.Movement.route) { CustomScreen(navController = navController, text = NavRoute.Movement.title)}

        composable(NavRoute.PortfolioOfStudents.route) { CustomScreen(navController = navController, text = NavRoute.PortfolioOfStudents.title)}
        composable(NavRoute.PortfolioOfEmployees.route) { CustomScreen(navController = navController, text = NavRoute.PortfolioOfEmployees.title)}
        composable(NavRoute.Statistics.route) { CustomScreen(navController = navController, text = NavRoute.Statistics.title)}

        composable(NavRoute.Educational.route) { CustomScreen(navController = navController, text = NavRoute.Educational.title)}
        composable(NavRoute.Project.route) { CustomScreen(navController = navController, text = NavRoute.Project.title)}
        composable(NavRoute.Other.route) { CustomScreen(navController = navController, text = NavRoute.Other.title)}

        composable(NavRoute.OperatingInstructions.route) { CustomScreen(navController = navController, text = NavRoute.OperatingInstructions.title)}
    }
}