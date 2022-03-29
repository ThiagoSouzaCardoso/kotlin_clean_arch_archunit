package com.example.students.archunit.core

import com.example.students.archunit.CleanArchitectureConstantes.PACKAGE_NAME
import com.example.students.archunit.CleanArchitectureConstantes.COMMANDS_PACKAGE
import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition

@AnalyzeClasses(packages = [PACKAGE_NAME], importOptions = [ImportOption.DoNotIncludeTests::class])
class CommandUnitTest {


    @ArchTest
    val commandsShouldHaveNameEndingWithCommand = ArchRuleDefinition.classes()
        .that().
        resideInAPackage(COMMANDS_PACKAGE).should().
        haveSimpleNameEndingWith("Command")
        .because("Commands are need to ending with Command");




}