package com.example.students.archunit.core

import com.example.students.archunit.CleanArchitectureTest
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition

@AnalyzeClasses(packages = [CleanArchitectureTest.PACKAGE_NAME])
class CoreCommandUnitTest {





    @ArchTest
    val commandsShouldHaveNameEndingWithCommand = ArchRuleDefinition.classes()
        .that().
        resideInAPackage(CleanArchitectureTest.COMMANDS_PACKAGE).should().
        haveSimpleNameEndingWith("Command")
        .because("Commands are need to ending with Command");




}