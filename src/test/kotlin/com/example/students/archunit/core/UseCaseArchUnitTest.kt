package com.example.students.archunit.core

import com.example.students.archunit.CleanArchitectureTest
import com.tngtech.archunit.core.domain.JavaClass
import com.tngtech.archunit.core.domain.JavaMethod
import com.tngtech.archunit.core.domain.JavaModifier
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.ArchCondition
import com.tngtech.archunit.lang.ConditionEvents
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition
import com.tngtech.archunit.library.Architectures

@AnalyzeClasses(packages = [CleanArchitectureTest.PACKAGE_NAME])
class UseCaseArchUnitTest {

    @ArchTest
    val usecasesShouldHaveOnlyOnePublicMethod =  ArchRuleDefinition.classes()
        .that()
        .haveSimpleNameEndingWith("UseCase")
        .should(containOnlyOnePublicMethod())
        .because("Use Cases should have only one business responsibility.");

    @ArchTest
    val useCasesImplCannotBeAcessedByExternalWorld = Architectures.layeredArchitecture()
        .`as`("")
        .layer("UseCases")
        .definedBy(CleanArchitectureTest.USE_CASES_PACKAGE)
        .layer("UseCasesImpl")
        .definedBy("..core.usecases.impl..")
        .whereLayer("UseCasesImpl")
        .mayOnlyBeAccessedByLayers("UseCases")

    @ArchTest
    val useCasesShouldResideInsideCore = ArchRuleDefinition.classes()
        .that()
        .resideInAPackage(CleanArchitectureTest.USE_CASES_PACKAGE)
        .should()
        .haveSimpleNameEndingWith("UseCase")
        .because("UseCases are the core of our business, hence they should stay inside core.");

    @ArchTest
    val useCasesCanBeAccessedByExternalWorld = Architectures.layeredArchitecture()
        .`as`("Use Case External World Access.")
        .layer("UseCases")
        .definedBy(CleanArchitectureTest.USE_CASES_PACKAGE + CleanArchitectureTest.ROOT_PACKAGE)
        .layer("Entrypoints")
        .definedBy(CleanArchitectureTest.ENTRYPOINT_PACKAGE)
        .layer("Configuration")
        .definedBy(CleanArchitectureTest.CONFIGURATION_PACKAGE)
        .whereLayer("UseCases")
        .mayOnlyBeAccessedByLayers("UseCases", "Entrypoints", "Configuration")
        .because("It's ok for Use Cases to be accessed by external world.")


    private fun containOnlyOnePublicMethod(): ArchCondition<JavaClass> {
        return object : ArchCondition<JavaClass>("Only one public method") {
            override fun check(clazz: JavaClass, events: ConditionEvents) {
                val name: String = clazz.name
                val methodsSet: Set<JavaMethod> = clazz.methods
                var publicMethodsCount = 0
                for (javaMethod in methodsSet) {
                    if (javaMethod.modifiers
                            .contains(JavaModifier.PUBLIC)
                    ) {
                        publicMethodsCount += 1
                    }
                }
                if (publicMethodsCount > CleanArchitectureTest.USE_CASES_PUBLIC_METHODS_LIMIT) {
                    throw AssertionError(
                        java.lang.String.format(
                            "Class %s contains %d public methods, when limit is %d",
                            name, publicMethodsCount, CleanArchitectureTest.USE_CASES_PUBLIC_METHODS_LIMIT
                        )
                    )
                }
            }
        }
    }

}