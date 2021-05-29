#!groovy
import jenkins.pipeline.lib.Constants

def InVirtualEnv(String name, String command) {
    echo "Sampling2 $name $command"
    sh(script:'''#!/bin/bash
    source ''' + name + '''/bin/activate && ''' + command, label: "VIRTUALENV: ${command}")
}

def call(String name = "venv", String command="python --version") {
    InVirtualEnv(name, command)
}