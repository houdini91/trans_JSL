#!groovy
import jenkins.pipeline.lib.Constants

def InVirtualEnv(String name, String command) {
    sh script:'''#!/bin/bash
    source ''' + name + '''/bin/activate && ''' + command, label: "VIRTUALENV 2: ${script}"
}

def call(String name = "venv", String command="python --version") {
    // InVirtualEnv(name, command)
     echo "Sampling $name $command"
}

// def call(String name = "venv") {
//     sh 'echo RunInVirutalENv222'
// }