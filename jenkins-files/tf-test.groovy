pipeline {
    agent any

    stages {
        stage('checkout') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/noorul-haque/gcp-learning.git']])
            }
        }

        stage('workspace') {
            steps {
                sh '''
                  set -x
                  gcloud auth activate-service-account  ansible@gcp-learning-428307.iam.gserviceaccount.com --key-file=/var/lib/jenkins/gke.json
                  cd /var/lib/jenkins/workspace/git-checkout-pipeline/terraform-files/
                  terraform init
                '''
            }
        }      
        
    }
}
