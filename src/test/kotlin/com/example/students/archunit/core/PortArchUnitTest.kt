package com.example.students.archunit.core

import com.example.students.archunit.CleanArchitectureConstantes.PACKAGE_NAME
import com.example.students.archunit.CleanArchitectureConstantes.USE_CASES_DEEP_PACKAGE
import com.example.students.archunit.CleanArchitectureConstantes.PORTS_PACKAGE
import com.example.students.archunit.CleanArchitectureConstantes.GATEWAY_PACKAGE
import com.example.students.archunit.CleanArchitectureConstantes.CONFIGURATION_PACKAGE
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition
import com.tngtech.archunit.library.Architectures

@AnalyzeClasses(packages = [PACKAGE_NAME])
class PortArchUnitTest {

    @ArchTest
    val portsBelongToUsecasesAndGateway = Architectures.layeredArchitecture()
        .`as`("UseCase Gateways Access.")
        .layer("UseCases")
        .definedBy(USE_CASES_DEEP_PACKAGE)
        .layer("Ports")
        .definedBy(PORTS_PACKAGE)
        .layer("Gateway")
        .definedBy(GATEWAY_PACKAGE)
        .layer("Configuration")
        .definedBy(CONFIGURATION_PACKAGE)
        .whereLayer("Ports")
        .mayOnlyBeAccessedByLayers("UseCases", "Gateway")
        .allowEmptyShould(true)
        .because("Ports interfaces should not leak.")

    @ArchTest
    val portsShouldHaveNameEndingWithPort = ArchRuleDefinition.classes()
        .that().
        resideInAPackage(PORTS_PACKAGE).should().
        haveSimpleNameEndingWith("Port").andShould().beInterfaces()
        .because("Ports are need to ending with Port and be an interface.");
}