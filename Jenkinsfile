 pipeline {
     agent any
     stages {
         stage ('build') {
             agent {
                 docker {
                     image 'maven:3.8.2-adoptopenjdk-11'
                     args '-u root -v mvn-repository:/root/.m2' 
                     reuseNode true
                 }
             }

             steps {
                 sh 'cd 02-embedded-kafka;mvn clean package'
             }
         }
     }
     post {
        always {
            junit '02-embedded-kafka/target/surefire-reports/**/*.xml'
        }
    }
 }
