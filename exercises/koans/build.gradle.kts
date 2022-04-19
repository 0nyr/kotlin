
// $ gradle koans:tasks intro
// run on build
task("intro") {             
    description = "Some meaningful words"

    println("Intro Intro Intro... This is an Intro task.")
}

// make task available (see with $ gradle tasks --all)
tasks.register("example-task") {
    description = "Example task"

    println("Example task")
}

