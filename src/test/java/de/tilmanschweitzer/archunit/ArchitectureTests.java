package de.tilmanschweitzer.archunit;

import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;

@AnalyzeClasses(packages = "de.tilmanschweitzer.adventofcode", importOptions = ImportOption.DoNotIncludeTests.class)
public class ArchitectureTests {

	@ArchTest
	public void noCyclesInTopLevelPackages(JavaClasses importedClasses) {
		slices().matching("de.tilmanschweitzer.adventofcode.(*)..")
				.should().beFreeOfCycles()
				.check(importedClasses);
	}

	@ArchTest
	public void noCyclesInAllPackages(JavaClasses importedClasses) {
		slices().matching("de.tilmanschweitzer.adventofcode.(**)")
				.should().beFreeOfCycles()
				.check(importedClasses);
	}

	@ArchTest
	public void noDependenciesBetweenImplementations(JavaClasses importedClasses) {
		slices().matching("de.tilmanschweitzer.adventofcode.puzzle.(*)..")
				.should().notDependOnEachOther()
				.check(importedClasses);
	}

}
