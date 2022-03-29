package com.example.students.archunit.core

import com.example.students.archunit.CleanArchitectureTest
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition
import com.tngtech.archunit.library.Architectures

@AnalyzeClasses(packages = [CleanArchitectureTest.PACKAGE_NAME])
class PortArchUnitTest {

    @ArchTest
    val portsBelongToUsecasesAndGateway = Architectures.layeredArchitecture()
        .`as`("UseCase Gateways Access.")
        .layer("UseCases")
        .definedBy(CleanArchitectureTest.USE_CASES_PACKAGE+ CleanArchitectureTest.ROOT_PACKAGE)
        .layer("Ports")
        .definedBy(CleanArchitectureTest.PORTS_PACKAGE)
        .layer("Gateway")
        .definedBy(CleanArchitectureTest.GATEWAY_PACKAGE)
        .layer("Configuration")
        .definedBy(CleanArchitectureTest.CONFIGURATION_PACKAGE)
        .whereLayer("Ports")
        .mayOnlyBeAccessedByLayers("UseCases", "Gateway")
        .allowEmptyShould(true)
        .because("Ports interfaces should not leak.")

    @ArchTest
    val portsShouldHaveNameEndingWithPort = ArchRuleDefinition.classes()
        .that().
        resideInAPackage(CleanArchitectureTest.PORTS_PACKAGE).should().
        haveSimpleNameEndingWith("Port").andShould().beInterfaces()
        .because("Ports are need to ending with Port and be an interface.");
}