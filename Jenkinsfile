pipeline{
    agent {
        label 'master'
    }
    options{
        buildDiscarder(logRotator(numToKeepStr: '3', artifactNumKeepStr: '3'))
        timestamps()
    }
    stages{
        stage("Build&Packaging"){
            steps {
                sh 'mvn package -Dmaven.test.skip=true'
                sh 'cd target'
                sh 'ls -la'
            }
        }
        stage("Docker Image create"){
            steps {
                dir ('docker') {
                    sh 'docker build . '
                }
            }
        }
        
    }



}
