package com.example.students.archunit

import com.example.students.archunit.CleanArchitectureConstantes.PACKAGE_NAME
import com.tngtech.archunit.junit.AnalyzeClasses


@AnalyzeClasses(packages = [PACKAGE_NAME])
object CleanArchitectureConstantes {
        const val PACKAGE_NAME: String = "com.example.students.."
        const val CORE_PACKAGE: String = "..core.."
        const val USE_CASES_PACKAGE: String = "..core.usecases"
//        const val FACADE_PACKAGE: String = "..core.facade.."
        const val USE_CASES_DEEP_PACKAGE: String = "..core.usecases.."
//        const val USE_CASES_IMPL_PACKAGE: String = "..core.usecases.impl"
        const val PORTS_PACKAGE: String = "..core.ports.."
        const val EVENTS_PACKAGE: String = "..core.events.."
        const val COMMANDS_PACKAGE: String = "..core.commands.."
        const val DOMAINS_PACKAGE: String = "..core.domains.."
        const val GATEWAY_PACKAGE: String = "..gateway.."
        const val ENTRYPOINT_PACKAGE: String = "..gateway.entrypoints.."
        const val ENTRYPOINT_REST_PACKAGE: String = "..gateway.entrypoints.rest"
        const val ENTRYPOINT_REST_INPUTS_PACKAGE: String = "..gateway.entrypoints.rest.inputs.."
        const val ENTRYPOINT_REST_OUTPUTS_PACKAGE: String = "..gateway.entrypoints.rest.outputs.."
        const val DATA_PROVIDERS_DATABASES_COLLECTIONS_PACKAGE: String = "..gateway.dataproviders.databases.collections.."
        const val DATA_PROVIDERS_DATABASES_REPOSITORY_PACKAGE: String = "..gateway.dataproviders.databases.repositories.."
        const val DATA_PROVIDERS_INTEGRATIONS_INPUTS_PACKAGE: String = "..gateway.dataproviders.integrations.*.inputs"
        const val DATA_PROVIDERS_INTEGRATIONS_OUTPUTS_PACKAGE: String = "..gateway.dataproviders.integrations.*.outputs"
        const val DATA_PROVIDERS_PACKAGE: String = "..gateway.dataproviders"
        const val CONFIGURATION_PACKAGE: String = "..configuration.."

        const val USE_CASES_PUBLIC_METHODS_LIMIT = 1

        const val JAVA_PACKAGE: String = "java.."
        const val KOTLIN_PACKAGE: String = "kotlin.."
        const val JETBRAINS_PACKAGE: String = "org.jetbrains.annotations.."
        const val SPRING_PACKAGE: String = "org.springframework.."
        const val LOG_PACKAGE: String = "org.slf4j.."

}