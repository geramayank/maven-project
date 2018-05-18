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
            	 echo 'Hello, Java'
            	sh 'java -version'
            	 echo 'Hello, Maven'
                sh 'mvn --version'
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
