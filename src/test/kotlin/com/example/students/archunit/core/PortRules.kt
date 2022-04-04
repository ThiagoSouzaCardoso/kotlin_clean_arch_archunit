package com.example.students.archunit.core

import com.example.students.archunit.CleanArchitectureConstantes.PORTS_PACKAGE
import com.example.students.archunit.cleanArchitectureLayer
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition
import com.tngtech.archunit.library.Architectures

class PortRules {

    @ArchTest
    val portsBelongToUsecasesAndGateway = Architectures.layeredArchitecture().cleanArchitectureLayer()
        .whereLayer("Ports")
        .mayOnlyBeAccessedByLayers("UseCases", "Gateway","Configuration")
        .allowEmptyShould(true)
        .because("Ports interfaces should not leak.")

    @ArchTest
    val portsShouldHaveNameEndingWithPort = ArchRuleDefinition.classes()
        .that().
        resideInAPackage(PORTS_PACKAGE).should().
        haveSimpleNameEndingWith("Port").andShould().beInterfaces()
        .because("Ports are need to ending with Port and be an interface.");
}