apply {
    from("$rootDir/compose-module.gradle")
}

dependencies {
    "implementation"(project(Modules.coreUtil))
    "implementation"(project(Modules.coreUi))
    "implementation"(project(Modules.trackerDomain))

    "implementation"(Coil.coilCompose)
}