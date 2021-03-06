#!groovy
import jenkins.pipeline.lib.Constants


def ListHTML(String name) {
    return findFiles(glob: """**/${name}/**/html/*.html""")
}


def PublishHTML() {
    for (f in ListHTML(env.STAGE_NAME)) {
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
        }
    }
}




// def PublishSample(String name) {
//     def file_list = []
//     for (f in  ListHtml(name)) {
//       if (! f.directory) {
//         echo """Publishing ${f.name} ${f.path} ${f.directory} ${f.length} ${f.lastModified}"""
//         file_list.add(f.path)
//       }
//     }
    // def obj_list_files
    // obj_list_files = ListHtml(name)
    // echo """File list ${file_list} ${obj_list_files}"""

    // publishHTML (target : [allowMissing: false,
    //     alwaysLinkToLastBuild: true,
    //     keepAll: true,
    //     reportDir: """samples/${name}""",
    //     reportFiles: obj_list_files.join(','),
    //     reportName: name])
// }


def call(args) {
    PublishHTML()
}

