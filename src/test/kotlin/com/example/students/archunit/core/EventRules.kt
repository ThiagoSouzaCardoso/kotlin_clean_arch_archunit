package com.example.students.archunit.core

import com.example.students.archunit.CleanArchitectureConstantes.EVENTS_PACKAGE
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition

class EventRules {

    @ArchTest
    val eventsShouldHaveNameEndingWithEvent = ArchRuleDefinition.classes()
        .that().
        resideInAPackage(EVENTS_PACKAGE).should().
        haveSimpleNameEndingWith("Event")
        .because("Events are need to ending with Event");


}