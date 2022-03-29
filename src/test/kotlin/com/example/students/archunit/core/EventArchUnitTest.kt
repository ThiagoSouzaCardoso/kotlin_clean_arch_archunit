package com.example.students.archunit.core

import com.example.students.archunit.CleanArchitectureConstantes.EVENTS_PACKAGE
import com.example.students.archunit.CleanArchitectureConstantes.PACKAGE_NAME
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition

@AnalyzeClasses(packages = [PACKAGE_NAME])
class EventArchUnitTest {

    @ArchTest
    val eventsShouldHaveNameEndingWithEvent = ArchRuleDefinition.classes()
        .that().
        resideInAPackage(EVENTS_PACKAGE).should().
        haveSimpleNameEndingWith("Event")
        .because("Events are need to ending with Event");


}