#!groovy
import jenkins.pipeline.lib.Constants

def RunInVirtualEnv2(String name, String command) {
    sh script:'''#!/bin/bash
    source ''' + name + '''/bin/activate && ''' + command, label: "VIRTUALENV 2: ${script}"
}

def call(String name = "venv", String command) {
    RunInVirtualEnv2(name, command)
}