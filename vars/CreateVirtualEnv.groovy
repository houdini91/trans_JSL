#!groovy
import jenkins.pipeline.lib.Constants

def CreatePython3VirtualEnv(String name) {
    sh "echo GOT NAME $name"
    sh "echo GOT NAME ${name}"
    sh """echo GOT NAME $name"""
    sh """echo GOT NAME ${name}"""

    sh(script: """python3 -m venv ${name}""",returnStdout: true)
    // sh "python3 -m venv ${name}"
}

def createVirtualEnv(String name) {
    sh "virutalenv $name"
}

def call(String name="venv") {
    sh "echo GOT NAME $name"
    sh "echo GOT NAME ${name}"
    sh """echo GOT NAME $name"""
    sh """echo GOT NAME ${name}"""

    CreatePython3VirtualEnv(name)
}