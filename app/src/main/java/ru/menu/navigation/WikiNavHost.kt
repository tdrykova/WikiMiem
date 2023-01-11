package ru.menu.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.menu.R
import ru.menu.screens.*

sealed class NavRoute(var route: String, var icon: Int?, var title: String) {
    object Welcome : NavRoute("welcome", null, "")
    object Main : NavRoute("main", null, "Главная")

    // Top items
    object Home : NavRoute("home", R.drawable.ic_home, "Домашняя")
    object Review : NavRoute("review", R.drawable.review_tree, "Обзор")
    object MainMenu : NavRoute("mainMenu", R.drawable.navigation, "Главное меню")

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

    object PortfolioOfStudents : NavRoute("portfolioOfStudents", R.drawable.ic_home, "Портфолио студентов")
    object PortfolioOfEmployees : NavRoute("portfolioOfEmployees", R.drawable.ic_home, "Портфолио сотрудников")
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
fun WikiNavHost(navController: NavHostController) {
//    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoute.Welcome.route
    ) {
        composable(NavRoute.Welcome.route) { WelcomeScreen(navController = navController) }

        composable(NavRoute.Main.route) { CustomScreen(text = NavRoute.Main.title) }

        // Top items
        composable(NavRoute.Home.route) { CustomScreen(text = NavRoute.Home.title)}
        composable(NavRoute.Review.route) { CustomScreen(text = NavRoute.Review.title)}
        composable(NavRoute.MainMenu.route) { CustomScreen(text = NavRoute.MainMenu.title)}

        // Main menu items
        composable(NavRoute.DigitalMIEM.route) { CustomScreen(text = NavRoute.DigitalMIEM.title)}
        composable(NavRoute.ProjectActivities.route) { CustomScreen(text = NavRoute.ProjectActivities.title)}
        composable(NavRoute.DigestsMIEM.route) { CustomScreen(text = NavRoute.DigestsMIEM.title)}

        composable(NavRoute.Administration.route) { CustomScreen(text = NavRoute.Administration.title)}
        composable(NavRoute.Departments.route) { CustomScreen(text = NavRoute.Departments.title)}
        composable(NavRoute.EducationalPrograms.route) { CustomScreen(text = NavRoute.EducationalPrograms.title)}
        composable(NavRoute.Laboratories.route) { CustomScreen(text = NavRoute.Laboratories.title)}
        composable(NavRoute.ResourceCenters.route) { CustomScreen(text = NavRoute.ResourceCenters.title)}
        composable(NavRoute.Library.route) { CustomScreen(text = NavRoute.Library.title)}

        composable(NavRoute.ProjectOffice.route) { CustomScreen(text = NavRoute.ProjectOffice.title)}
        composable(NavRoute.ProjectSchool.route) { CustomScreen(text = NavRoute.ProjectSchool.title)}
        composable(NavRoute.ProjectDocumentation.route) { CustomScreen(text = NavRoute.ProjectDocumentation.title)}

        composable(NavRoute.CourseMaterials.route) { CustomScreen(text = NavRoute.CourseMaterials.title)}
        composable(NavRoute.AdditionalMaterials.route) { CustomScreen(text = NavRoute.AdditionalMaterials.title)}
        composable(NavRoute.Tracks.route) { CustomScreen(text = NavRoute.Tracks.title)}

        composable(NavRoute.StudentCouncilMIEM.route) { CustomScreen(text = NavRoute.StudentCouncilMIEM.title)}
        composable(NavRoute.Movement.route) { CustomScreen(text = NavRoute.Movement.title)}

        composable(NavRoute.PortfolioOfStudents.route) { CustomScreen(text = NavRoute.PortfolioOfStudents.title)}
        composable(NavRoute.PortfolioOfEmployees.route) { CustomScreen(text = NavRoute.PortfolioOfEmployees.title)}
        composable(NavRoute.Statistics.route) { CustomScreen(text = NavRoute.Statistics.title)}

        composable(NavRoute.Educational.route) { CustomScreen(text = NavRoute.Educational.title)}
        composable(NavRoute.Project.route) { CustomScreen(text = NavRoute.Project.title)}
        composable(NavRoute.Other.route) { CustomScreen(text = NavRoute.Other.title)}

        composable(NavRoute.OperatingInstructions.route) { CustomScreen(text = NavRoute.OperatingInstructions.title)}

        // Review items
        composable(NavRoute.Drafts.route) { CustomScreen(text = NavRoute.Drafts.title)}
        composable(NavRoute.Groups.route) { CustomScreen(text = NavRoute.Groups.title)}
        composable(NavRoute.Digests.route) { CustomScreen(text = NavRoute.Digests.title)}
        composable(NavRoute.Documentation.route) { CustomScreen(text = NavRoute.Documentation.title)}
        composable(NavRoute.People.route) { CustomScreen(text = NavRoute.People.title)}
        composable(NavRoute.DepartmentsReview.route) { CustomScreen(text = NavRoute.DepartmentsReview.title)}
        composable(NavRoute.ProjectsReview.route) { CustomScreen(text = NavRoute.ProjectsReview.title)}
        composable(NavRoute.Studies.route) { CustomScreen(text = NavRoute.Studies.title)}
        composable(NavRoute.HomePage.route) { CustomScreen(text = NavRoute.HomePage.title)}
        composable(NavRoute.Contacts.route) { CustomScreen(text = NavRoute.Contacts.title)}

    }
}