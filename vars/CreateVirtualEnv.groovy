#!groovy
import jenkins.pipeline.lib.Constants

def CreatePython3VirtualEnv(String name) {
    sh(script: """python3 -m venv ${name}""",returnStdout: true)
}

def CreateVirtualEnv(String name) {
    sh "virutalenv $name"
}

def call(String name="venv") {
    CreatePython3VirtualEnv(name)
}