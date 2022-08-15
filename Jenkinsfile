pipeline {
    agent {
        label 'master'
    }
    options {
        buildDiscarder(logRotator(numToKeepStr: '3', artifactNumToKeepStr: '3'))
    }
    stages {
        stage("Packaging") {
            steps {
                sh 'mvn package -Pprod -Dmaven.test.skip=true'
            }
        }
        stage("Delivering artifact to AWS") {
            steps {
                echo 'Delivering artifact to remote server...'
                dir('target') {
                    sh 'scp cutter-0.2.0.jar ubuntu@enumerable-entity.host:/home/ubuntu/app'
                }
            }
        }
        stage("Deploy artifact") {
            steps {
                script {
                    echo 'Deploying...'
                    sshagent(credentials: ['jenkinsAWSssh']) {
                        sh """ ssh ubuntu@enumerable-entity.host << EOF
                       docker restart SpringAppCutter
                       exit
                       EOF """
                    }
                }
            }
        }
    }
}

