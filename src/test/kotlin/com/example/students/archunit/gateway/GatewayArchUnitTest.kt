package com.example.students.archunit.gateway

import com.example.students.archunit.CleanArchitectureTest
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.library.Architectures

@AnalyzeClasses(packages = [CleanArchitectureTest.PACKAGE_NAME])
class GatewayArchUnitTest {

    @ArchTest
    val gatewaysCannotBeAcessedByOthersLayers = Architectures.layeredArchitecture()
        .`as`("Gateways access control.")
        .layer("Core")
        .definedBy(CleanArchitectureTest.CORE_PACKAGE)
        .layer("Gateways")
        .definedBy(CleanArchitectureTest.GATEWAY_PACKAGE)
        .layer("Configuration")
        .definedBy(CleanArchitectureTest.CONFIGURATION_PACKAGE)
        .whereLayer("Gateways")
        .mayNotBeAccessedByAnyLayer()
        .because("Gateways should not be accessed by other layers.")




}