apply {
    from("$rootDir/base-module.gradle")
}

dependencies {
    "api"(project(Modules.coreUseCase))
}