package com.example.students.archunit

import com.example.students.archunit.configuration.ConfigurationRules
import com.example.students.archunit.core.*
import com.example.students.archunit.gateway.DataProviderRules
import com.example.students.archunit.gateway.EntrypointRules
import com.example.students.archunit.gateway.GatewayRules
import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.junit.ArchTests

@AnalyzeClasses(packages = [CleanArchitectureConstantes.PACKAGE_NAME], importOptions = [ImportOption.DoNotIncludeTests::class])
class ArchitectureTest {

    @ArchTest
    val configurationRules: ArchTests = ArchTests.`in`(ConfigurationRules::class.java)

    @ArchTest
    val commandRules: ArchTests = ArchTests.`in`(CommandRules::class.java)

    @ArchTest
    val coreRules: ArchTests = ArchTests.`in`(CoreRules::class.java)

    @ArchTest
    val eventRules: ArchTests = ArchTests.`in`(EventRules::class.java)

    @ArchTest
    val portRules: ArchTests = ArchTests.`in`(PortRules::class.java)

    @ArchTest
    val useCaseRules: ArchTests = ArchTests.`in`(UseCaseRules::class.java)

    @ArchTest
    val dataProviderRules: ArchTests = ArchTests.`in`(DataProviderRules::class.java)

    @ArchTest
    val entrypointRules: ArchTests = ArchTests.`in`(EntrypointRules::class.java)

    @ArchTest
    val gatewayRules: ArchTests = ArchTests.`in`(GatewayRules::class.java)

}