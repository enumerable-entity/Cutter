pipeline{
    agent {
        label 'master'
    }
    stages{
        stage("Build&Packaging"){
            steps {
                sh 'mvn jar:jar'
            }
        }
    }



}
