 pipeline {
     agent any
     stages {
         stage ('build') {
            withMaven {
                    steps {
                        sh "mvn package"
                    }
                }
             }
     }
}
