#!groovy
import jenkins.pipeline.lib.Constants

def InVirtualEnv(String name = "venv", String command = "python --version") {
    echo "InVirtualEnv $name $command"
    sh(script:'''#!/bin/bash
    source ''' + name + '''/bin/activate && ''' + command, label: "VIRTUALENV: ${command}")
}

def call(String name="venv", String command="python --version") {
    InVirtualEnv(name, command)
}