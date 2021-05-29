#!groovy
import jenkins.pipeline.lib.Constants

def inVirtualEnv(String name, String command) {
    sh script:'''#!/bin/bash
    source ''' + name + '''/bin/activate && ''' + command, label: "VIRTUALENV 2: ${script}"
}

def call(String name = "venv", String command="python --version") {
     echo "Sampling $name $command"
    inVirtualEnv(name, command)
}

// def call(String name = "venv") {
//     sh 'echo RunInVirutalENv222'
// }