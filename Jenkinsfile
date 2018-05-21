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
                	steps{
	                	timeout(time:5, unit:'DAYS'){
	                    input message:'Approve PRODUCTION Deployment?'
                		}

                 		echo 'Deploy Production...'
            		}
            		post {
                		success {
                    		echo 'Code deployed to Production.'
                		}

                		failure {
                    		echo ' Deployment failed.'
                		}
            		}                    
                }
            }
        }
    }
}
