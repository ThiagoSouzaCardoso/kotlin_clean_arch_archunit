package com.example.students.archunit.gateway

import com.example.students.archunit.cleanArchitectureLayer
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.library.Architectures

class GatewayRules {

    @ArchTest
    val gatewaysCannotBeAcessedByOthersLayers = Architectures.layeredArchitecture().cleanArchitectureLayer()
        .`as`("Gateway access control.")
        .whereLayer("Gateway")
        .mayNotBeAccessedByAnyLayer()
        .because("Gateway should not be accessed by other layers.")




}