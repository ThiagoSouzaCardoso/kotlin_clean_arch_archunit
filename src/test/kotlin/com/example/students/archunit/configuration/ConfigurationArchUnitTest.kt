package com.example.students.archunit.configuration

import com.example.students.archunit.CleanArchitectureConstantes.CONFIGURATION_PACKAGE
import com.example.students.archunit.CleanArchitectureConstantes.CORE_PACKAGE
import com.example.students.archunit.CleanArchitectureConstantes.GATEWAY_PACKAGE
import com.example.students.archunit.CleanArchitectureConstantes.PACKAGE_NAME
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.library.Architectures

@AnalyzeClasses(packages = [PACKAGE_NAME])
class ConfigurationArchUnitTest {

    @ArchTest
    val configurationCantBeAcessedByAnyLayer = Architectures.layeredArchitecture()
        .layer("Core")
        .definedBy(CORE_PACKAGE)
        .layer("Gateways")
        .definedBy(GATEWAY_PACKAGE)
        .layer("Configuration")
        .definedBy(CONFIGURATION_PACKAGE)
        .whereLayer("Configuration")
        .mayNotBeAccessedByAnyLayer()
        .because("Configuration is our last external layer and should not be accessed by other layers.");


}