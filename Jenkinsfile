 pipeline {
     agent any
     stages {
         stage ('build') {
            steps {
                    withMaven ( 
                        maven: 'maven-3-8',
                        mavenLocalRepo: '.repository'
                        ) {
                        sh "mvn package"
                    }
                }
             }
     }
}
