package com.example.students.archunit

import com.tngtech.archunit.library.Architectures
import com.tngtech.archunit.library.Architectures.LayeredArchitecture


        fun LayeredArchitecture.cleanArchitectureLayer() = Architectures.layeredArchitecture()
            .layer("UseCases")
            .definedBy(CleanArchitectureConstantes.USE_CASES_DEEP_PACKAGE)
            .layer("Ports")
            .definedBy(CleanArchitectureConstantes.PORTS_PACKAGE)
            .layer("Gateway")
            .definedBy(CleanArchitectureConstantes.GATEWAY_PACKAGE)
            .layer("Configuration")
            .definedBy(CleanArchitectureConstantes.CONFIGURATION_PACKAGE)
            .layer("Entrypoints")
            .definedBy(CleanArchitectureConstantes.ENTRYPOINT_PACKAGE)
            .layer("Core")
            .definedBy(CleanArchitectureConstantes.CORE_PACKAGE)


