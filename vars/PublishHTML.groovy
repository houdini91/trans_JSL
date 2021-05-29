#!groovy
import jenkins.pipeline.lib.Constants

def ListHtml() {
    return findFiles(glob: """**/${env.STAGE_NAME}/**/html/*.html""")
}

def PublishHTML() {
    for (f in  ListHtml()) {
        if (! f.directory) {
            echo """Publishing ${f.name} ${f.path} ${f.directory} ${f.length} ${f.lastModified}"""
            REPORT_DIR = sh(script: 'dirname ' + f.path, returnStdout: true)
            REPORT_NAME = sh(script: 'basename ' + f.path, returnStdout: true)
            echo """VARS $REPORT_DIR $REPORT_NAME"""

            publishHTML (target : [allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: REPORT_DIR,
                reportFiles: f.name,
                reportName: REPORT_NAME,
                reportTitles: REPORT_NAME])
                
            DELETE = sh(script: 'rm -rf ' + f.path, returnStdout: true)
        }
    }
}

def call(args) {
    PublishHTML()
}