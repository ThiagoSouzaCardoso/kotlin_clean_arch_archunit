package com.example.students

import com.example.students.CleanArchitectureTest.Companion.PACKAGE_NAME
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition
import com.tngtech.archunit.library.Architectures
import com.tngtech.archunit.library.dependencies.SlicesRuleDefinition


@AnalyzeClasses(packages = [PACKAGE_NAME])
class CleanArchitectureTest {

    companion object{
        const val ROOT_PACKAGE = ".."
        const val PACKAGE_NAME: String = "com.example.students"
        const val CORE_PACKAGE: String = "..core.."
        const val USE_CASES_PACKAGE: String = "..core.usecases"
        const val PORTS_PACKAGE: String = "..core.ports.."
        const val EVENTS_PACKAGE: String = "..core.events.."
        const val COMMANDS_PACKAGE: String = "..core.commands.."
        const val GATEWAY_PACKAGE: String = "..gateway.."
        const val ENTRYPOINT_PACKAGE: String = "..gateway.entrypoints.."
        const val ENTRYPOINT_REST_PACKAGE: String = "..gateway.entrypoints.rest"
        const val ENTRYPOINT_REST_INPUTS_PACKAGE: String = "..gateway.entrypoints.rest.inputs.."
        const val ENTRYPOINT_REST_OUTPUTS_PACKAGE: String = "..gateway.entrypoints.rest.outputs.."
        const val DATA_PROVIDERS_DATABASES_COLLECTIONS_PACKAGE: String = "..gateway.dataproviders.databases.collections.."
        const val DATA_PROVIDERS_INTEGRATIONS_INPUTS_PACKAGE: String = "..gateway.dataproviders.integrations.*.inputs"
        const val DATA_PROVIDERS_INTEGRATIONS_OUTPUTS_PACKAGE: String = "..gateway.dataproviders.integrations.*.outputs"
        const val DATA_PROVIDERS_PACKAGE: String = "..gateway.dataproviders"
        const val CONFIGURATION_PACKAGE: String = "..configuration.."
        const val USE_CASES_PUBLIC_METHODS_LIMIT = 1
    }








}