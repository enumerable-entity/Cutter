pipeline{
    agent {
        label 'master'
    }
    options{
        buildDiscarder(logRotator(numToKeepStr: '3', artifactNumToKeepStr: '3'))
    }
    stages{
        stage("Packaging"){
            steps {
                sh 'mvn package -Dmaven.test.skip=true'
            }
        }
        stage("Delivering artifact to AWS"){
            steps {
                dir ('target') {
                    sh 'scp cutter-0.0.1-SNAPSHOT.jar jenkins@enumerable-entity.link:/home/jenkins/app'
                }
            }
        }
        stage("Deploy artifact"){
             steps {
                   sh 'ssh jenkins@enumerable-entity.link'
                   sh 'docker restart 8b7feaa4604d'
                    }
                }
    }
}
