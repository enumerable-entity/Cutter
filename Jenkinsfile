pipeline{
    agent {
        label 'master'
    }
    options{
        timestamps()
    }
    stages{
        stage("Build&Packaging"){
            steps {
                sh 'mvn package -Dmaven.test.skip=true'
                sh 'cd target/'
                sh 'ls -la'
            }
        }
    }



}
