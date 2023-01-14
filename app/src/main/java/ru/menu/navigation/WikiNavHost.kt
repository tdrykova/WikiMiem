package ru.menu.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ru.menu.R
import ru.menu.screens.*

sealed class NavRoute(var route: String, var icon: Int?, var title: String) {
    object Welcome : NavRoute("welcome", null, "")
    object Main : NavRoute("main", null, "Главная")

    // Top items
    object Home : NavRoute("home", R.drawable.ic_home, "Домашняя")

    // Main menu items
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

    object PortfolioOfStudents : NavRoute("portfolioOfStudents", R.drawable.materials, "Портфолио студентов")
    object PortfolioOfEmployees : NavRoute("portfolioOfEmployees", R.drawable.materials, "Портфолио сотрудников")
    object Statistics : NavRoute("statistics", R.drawable.statistics, "Статистика")

    object Educational : NavRoute("educational", R.drawable.students, "Учебные")
    object Project : NavRoute("project", R.drawable.students, "Проектные")
    object Other : NavRoute("other", R.drawable.students, "Прочие")

    object OperatingInstructions : NavRoute("operatingInstructions", R.drawable.instructions, "Инструкции по работе")

    // Review items
    object Drafts : NavRoute("drafts", R.drawable.folder, "_Черновики")
    object Groups : NavRoute("groups", R.drawable.folder, "Группы")
    object Digests : NavRoute("digests", R.drawable.folder, "Дайджесты")

    object Documentation : NavRoute("documentation", R.drawable.folder, "Документация")
    object People : NavRoute("people", R.drawable.folder, "Люди")
    object DepartmentsReview : NavRoute("departmentsReview", R.drawable.folder, "Подразделения")
    object ProjectsReview : NavRoute("projectsReview", R.drawable.folder, "Проекты")
    object Studies : NavRoute("studies", R.drawable.folder, "Учеба")
    object HomePage : NavRoute("homePage", R.drawable.text_box, "Главная страница")
    object Contacts : NavRoute("contacts", R.drawable.text_box, "Контакты")
}

@Composable
fun WikiNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoute.Welcome.route
    ) {
        composable(NavRoute.Welcome.route) { WelcomeScreen(navController = navController) }
        composable(
            route = "{route}",
            arguments = listOf(
                navArgument("route") { type = NavType.StringType })
        ) {
            val currentRoute = it.arguments?.getString("route")!!
            CustomScreen(navController = navController)
        }
    }
}