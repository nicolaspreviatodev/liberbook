package com.liberbook;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

/**
 * Trava a regra de dependência do hexagonal: o pacote "domain" de qualquer
 * módulo nunca pode depender de Spring ou JPA. Roda a cada "mvn test" / push no CI.
 */
@AnalyzeClasses(packages = "com.liberbook", importOptions = ImportOption.DoNotIncludeTests.class)
class ArchitectureTest {

    @ArchTest
    static final ArchRule domainNaoDependeDeSpring =
            noClasses().that().resideInAPackage("..domain..")
                    .should().dependOnClassesThat().resideInAnyPackage(
                            "org.springframework..", "jakarta.persistence..");
}
