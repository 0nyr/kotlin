

// $ gradle koans:tasks intro
// always run on task execution
/*task("intro") {
    description = "Default running task"

    println(".")
}*/

// make task available (see with $ gradle tasks --all)
//  gradle -q koans:example-task
tasks.register("example-task") {
    description = "Example task"

    println("Example task, registered inside :koans")
}

