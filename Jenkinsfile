pipeline {
    agent any

    environment {
        registry = "bhavya16/my-spring-boot-app-assign" // Update registry name to match your assignment
        registryCredential = 'dockerhub' // Assuming you have credentials configured in Jenkins
        dockerRegistryUrl = "https://index.docker.io/v1/" // Define the Docker registry URL explicitly
        dateTag = new Date().format("yyyyMMdd-HHmmss")
        kubernetesCredentialsId = 'KubeConfig'
    }

    stages {
        stage('Building Docker Image') {
            steps {
                script {
                    // Build Docker image with the tag 'latest'
                    docker.build(registry + ":latest")
                }
            }
        }

        stage('Publishing Docker Image to Docker Hub') {
            steps {
                script {
                    // Push the Docker image to Docker Hub
                    docker.withRegistry("${dockerRegistryUrl}", "${registryCredential}") {
                        docker.image(registry + ":latest").push()
                    }
                }
            }
        }

        stage('Deploying to Kubernetes Cluster') {
            steps {
                // Assuming you have Kubernetes configurations set up in your Jenkins environment
                // Deploy to Kubernetes using kubectl
                // sh 'kubectl apply -f deployment.yaml'
                // sh 'kubectl apply -f nodeport.yaml'
                // sh 'kubectl rollout restart deployment/deployment'
                script{
                // Use withCredentials to securely pass Kubernetes credentials
                    withCredentials([file(credentialsId: kubernetesCredentialsId, variable: 'KUBECONFIG')]) {
                        // Set KUBECONFIG environment variable to use the provided kubeconfig file
                        sh 'export KUBECONFIG=$KUBECONFIG'
                        
                        // Run kubectl commands to apply deployment and nodeport services
                        sh 'kubectl apply -f deployment.yaml'
                        sh 'kubectl apply -f nodeport.yaml'
                        // sh 'kubectl get service webpage-nodeport-service-star -n default -o yaml > latest_service.yaml'
                        // sh 'kubectl apply -f latest_service.yaml'
                        
                        
                        // Restart the deployment
                        sh 'kubectl rollout restart deployment/deployment'
                    }
            }
            }
        }
    }

    post {
        always {
            // Always logout from Docker registry after the pipeline execution
            sh 'docker logout'
        }
    }
}
