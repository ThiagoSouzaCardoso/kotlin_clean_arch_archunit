package com.example.students.archunit

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition

@AnalyzeClasses(packages = [CleanArchitectureTest.PACKAGE_NAME])
class CoreEventArchUnitTest {

    @ArchTest
    val eventsShouldHaveNameEndingWithEvent = ArchRuleDefinition.classes()
        .that().
        resideInAPackage(CleanArchitectureTest.EVENTS_PACKAGE).should().
        haveSimpleNameEndingWith("Event")
        .because("Events are need to ending with Event");


}