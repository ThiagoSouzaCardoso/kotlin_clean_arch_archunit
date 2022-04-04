package com.example.students.archunit.configuration

import com.example.students.archunit.cleanArchitectureLayer
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.library.Architectures

class ConfigurationRules {

    @ArchTest
    val configurationCantBeAcessedByAnyLayer = Architectures.layeredArchitecture().cleanArchitectureLayer()
        .whereLayer("Configuration")
        .mayNotBeAccessedByAnyLayer()
        .because("Configuration is our last external layer and should not be accessed by other layers.");


}