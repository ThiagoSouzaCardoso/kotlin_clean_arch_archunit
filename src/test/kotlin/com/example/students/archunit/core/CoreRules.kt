package com.example.students.archunit.core

import com.example.students.archunit.CleanArchitectureConstantes.CORE_PACKAGE
import com.example.students.archunit.CleanArchitectureConstantes.JAVA_PACKAGE
import com.example.students.archunit.CleanArchitectureConstantes.JETBRAINS_PACKAGE
import com.example.students.archunit.CleanArchitectureConstantes.KOTLIN_PACKAGE
import com.example.students.archunit.CleanArchitectureConstantes.LOG_PACKAGE
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition

class CoreRules{

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