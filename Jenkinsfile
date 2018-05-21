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
                sh 'mvn clean package checkstyle:checkstyle'
            }
            post {
                success {
                    echo 'Now Archiving...'
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }

        stage ('Deployments'){
            parallel{
                stage ('Deploy to Staging'){
                    steps {
                        echo 'Deploy Staging...'
                    }
                }

                stage ("Deploy to Production"){
                    steps {
                        echo 'Deploy Production...'
                    }
                }
            }
        }
    }
}
