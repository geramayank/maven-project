pipeline {
    agent any
    tools {
        maven 'localMaven'
    }
    triggers {
         pollSCM('* * * * *')
     }
    stages{
        stage('Build'){
            steps {
                sh 'mvn clean package'
            }
            post {
                success {
                    echo 'Now Archiving...'                   
                }
            }
        }   
    }
}
