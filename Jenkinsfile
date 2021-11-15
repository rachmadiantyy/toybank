 pipeline {
     agent any
     stages {
         stage ('build') {
            withMaven {
                sh "mvn package"
                }
             }
     }
}
