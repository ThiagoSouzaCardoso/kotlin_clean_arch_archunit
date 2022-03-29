package com.example.students.archunit.configuration

import com.example.students.archunit.CleanArchitectureTest
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.library.Architectures

@AnalyzeClasses(packages = [CleanArchitectureTest.PACKAGE_NAME])
class ConfigurationArchUnitTest {

    @ArchTest
    val configurationCantBeAcessedByAnyLayer = Architectures.layeredArchitecture()
        .layer("Core")
        .definedBy(CleanArchitectureTest.CORE_PACKAGE)
        .layer("Gateways")
        .definedBy(CleanArchitectureTest.GATEWAY_PACKAGE)
        .layer("Configuration")
        .definedBy(CleanArchitectureTest.CONFIGURATION_PACKAGE)
        .whereLayer("Configuration")
        .mayNotBeAccessedByAnyLayer()
        .because("Configuration is our last external layer and should not be accessed by other layers.");


}