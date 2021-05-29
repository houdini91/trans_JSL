#!groovy
import jenkins.pipeline.lib.Constants

def RunInVirtualEnv(String name, String command) {
    sh script:'''#!/bin/bash
    source ''' + name + '''/bin/activate && ''' + command, label: "VIRTUALENV: ${script}"
}

def call(String name = "venv", String command) {
    RunInVirtualEnv(name)
}