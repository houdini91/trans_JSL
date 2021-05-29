#!groovy
import jenkins.pipeline.lib.Constants

// def InVirtualEnv(String name , String command) {
//     sh script:'''#!/bin/bash
//     source ''' + name + '''/bin/activate && ''' + command, label: "VIRTUALENV 2: ${script}"
// }


def test(String name, String command) {
    echo "Sampling2 $name $command"
    sh(script:'''#!/bin/bash
    source ''' + name + '''/bin/activate && ''' + command, label: "VIRTUALENV 2: ${command}")
}

def call(String name = "venv", String command="python --version") {
    echo "Sampling $name $command"
    test(name, command)
}

// def call(String name = "venv") {
//     sh 'echo RunInVirutalENv222'
// }