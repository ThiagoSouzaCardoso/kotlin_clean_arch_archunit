package com.example.students.archunit.core

import com.example.students.archunit.CleanArchitectureConstantes.CORE_PACKAGE
import com.example.students.archunit.CleanArchitectureConstantes.JAVA_PACKAGE
import com.example.students.archunit.CleanArchitectureConstantes.JETBRAINS_PACKAGE
import com.example.students.archunit.CleanArchitectureConstantes.KOTLIN_PACKAGE
import com.example.students.archunit.CleanArchitectureConstantes.LOG_PACKAGE
import com.example.students.archunit.CleanArchitectureConstantes.PACKAGE_NAME
import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition

@AnalyzeClasses(packages = [PACKAGE_NAME], importOptions = [ImportOption.DoNotIncludeTests::class])
class CoreArchUnitTest{

    @ArchTest
    val coreLayerCannotDependOnFrameworks = ArchRuleDefinition.classes()
        .that().resideInAPackage(CORE_PACKAGE)
        .should().onlyDependOnClassesThat().resideInAnyPackage(
            JAVA_PACKAGE,
            KOTLIN_PACKAGE,
            LOG_PACKAGE,
            CORE_PACKAGE,
            JETBRAINS_PACKAGE
        )

}