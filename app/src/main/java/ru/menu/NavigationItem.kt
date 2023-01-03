package ru.menu

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.ic_home, "")
    object Review : NavigationItem("review", R.drawable.review_tree, "Обзор")

    object DigitalMIEM : NavigationItem("digitalMIEM", R.drawable.digital_miem, "Цифровой МИЭМ")
    object ProjectActivities : NavigationItem("projectActivities", R.drawable.project, "Проектная деятельность")
    object DigestsMIEM : NavigationItem("digestsMIEM", R.drawable.digests, "Дайджесты МИЭМ")

    object Administration : NavigationItem("administration", R.drawable.departments, "Администрация")
    object Departments : NavigationItem("departments", R.drawable.departments, "Департаменты")
    object EducationalPrograms : NavigationItem("educationalPrograms", R.drawable.materials, "Образовательные программы")
    object Laboratories : NavigationItem("laboratories", R.drawable.labs, "Лаборатории")
    object ResourceCenters : NavigationItem("resourceCenters", R.drawable.resourse_centers, "Ресурсные центры")
    object Library : NavigationItem("library", R.drawable.library, "Библиотека")

    object ProjectOffice : NavigationItem("projectOffice", R.drawable.project_office, "Проектный офис")
    object ProjectSchool : NavigationItem("projectSchool", R.drawable.project_school, "Проектная школа")
    object ProjectDocumentation : NavigationItem("projectDocumentation", R.drawable.documintation, "Документация проектов")

    object CourseMaterials : NavigationItem("courseMaterials", R.drawable.materials, "Материалы курсов")
    object AdditionalMaterials : NavigationItem("additionalMaterials", R.drawable.materials, "Дополнительные материалы")
    object Tracks : NavigationItem("tracks", R.drawable.tracks, "Треки (специализации)")

    object StudentCouncilMIEM : NavigationItem("studentCouncilMIEM", R.drawable.group, "Студенческий совет МИЭМ")
    object Movement : NavigationItem("movement", R.drawable.group, "Movement")

    object PortfolioOfStudents : NavigationItem("portfolioOfStudents", R.drawable.ic_home, "Портфолио студентов")
    object PortfolioOfEmployees : NavigationItem("portfolioOfEmployees", R.drawable.ic_home, "Портфолио сотрудников")
    object Statistics : NavigationItem("statistics", R.drawable.statistics, "Статистика")

    object Educational : NavigationItem("educational", R.drawable.students, "Учебные")
    object Project : NavigationItem("project", R.drawable.students, "Проектные")
    object Other : NavigationItem("other", R.drawable.students, "Прочие")

    object OperatingInstructions : NavigationItem("operatingInstructions", R.drawable.instructions, "Инструкции по работе")
}
